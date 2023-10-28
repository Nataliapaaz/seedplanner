package com.example.seedplanner;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;


import java.util.ArrayList;


public class fragmento1 extends Fragment {
    private Spinner mesesSpinner;
    private ArrayAdapter<String> mesesAdapter;
    private ArrayList<String> mesesList = new ArrayList<>();

    private Spinner diasSpinner;

    private ArrayAdapter<String> diasAdapter;
    private ArrayList<String> diasList = new ArrayList<>();
    public fragmento1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);
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

}