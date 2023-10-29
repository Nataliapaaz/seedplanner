package com.example.seedplanner;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;


import java.util.ArrayList;
import java.util.Calendar;


public class fragmento1 extends Fragment {
    private Spinner mesesSpinner;
    private ArrayAdapter<String> mesesAdapter;
    private ArrayList<String> mesesList = new ArrayList<>();

    private Spinner diasSpinner;

    private ArrayAdapter<String> diasAdapter;
    private ArrayList<String> diasList = new ArrayList<>();

    private EditText diasAnticipacionEditText;
    private int diaObjetivo;

    public fragmento1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        diaObjetivo = 6;

        mesesList.clear();
        mesesList.add("Enero");
        mesesList.add("Febrero");
        mesesList.add("Marzo");
        mesesList.add("Abril");
        mesesList.add("Junio");
        mesesList.add("Julio");
        mesesList.add("Agosto");
        mesesList.add("Septiembre");
        mesesList.add("Octubre");
        mesesList.add("Noviembre");
        mesesList.add("Diciembre");

        mesesSpinner = view.findViewById(R.id.meses);
        mesesAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, mesesList);
        mesesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mesesSpinner.setAdapter(mesesAdapter);

        diasList.clear();
        diasList.add("1");
        diasList.add("2");
        diasList.add("3");
        diasList.add("4");

        diasSpinner = view.findViewById(R.id.dias);
        diasAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, diasList);
        diasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diasSpinner.setAdapter(diasAdapter);

        //cargarMesesDesdeFirestore();

        Button btguardar = view.findViewById(R.id.btguardar);
        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Se ha Guardado!", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }



    private void cargarMesesDesdeFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("meses")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        mesesList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String mes = document.getString("mes");
                            if(mes!=null){
                                mesesList.add(mes);

                            }
                            System.out.println("valor:" + mes);
                        }
                        mesesAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getContext(), "Error al cargar las opciones", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void programarRecordatorio() {
        int mesSeleccionado = mesesSpinner.getSelectedItemPosition();
        String diasAnticipacionStr = diasSpinner.getSelectedItem().toString(); // seleccionado del Spinner
        int diasAnticipacion = Integer.parseInt(diasAnticipacionStr);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR)); // Año actual
        calendar.set(Calendar.MONTH, mesSeleccionado); // Mes seleccionado
        calendar.set(Calendar.DAY_OF_MONTH, diaObjetivo); // Día objetivo
        calendar.add(Calendar.DAY_OF_MONTH, -diasAnticipacion);

        // Configura la notificación
        AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(requireContext(), NotificacionReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(requireContext(), 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }


}