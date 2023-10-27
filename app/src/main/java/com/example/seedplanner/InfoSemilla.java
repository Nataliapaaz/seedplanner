package com.example.seedplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class InfoSemilla extends Fragment {
    private FirebaseFirestore db;

    // almacenar el nombre de la semilla
    private String nombreSemillaSeleccionada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_semilla, container, false);

        // Inicializa Firebase Firestore
        db = FirebaseFirestore.getInstance();

        Bundle bundle = getArguments();
        if (bundle != null) {
            nombreSemillaSeleccionada = bundle.getString("nombre");
        }

        if (nombreSemillaSeleccionada != null && nombreSemillaSeleccionada.equals("coliflor")) {
            db.collection("lista")
                    .document("coliflor")  // Documento específico
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                // acceder a campos
                                String sol = documentSnapshot.getString("sol");
                                String agua = documentSnapshot.getString("agua");
                                String estacion = documentSnapshot.getString("estacion");
                                String germinacion = documentSnapshot.getString("germinacion");

                                // Actualiza TextViews
                                TextView textViewSol = view.findViewById(R.id.textView11);
                                textViewSol.setText("Sol: " + sol);

                                TextView textViewAgua = view.findViewById(R.id.textView12);
                                textViewAgua.setText("Agua: " + agua);

                                TextView textViewEstacion = view.findViewById(R.id.textView17);
                                textViewEstacion.setText("Estación: " + estacion);

                                TextView textViewGerminacion = view.findViewById(R.id.textView18);
                                textViewGerminacion.setText("Germinación: " + germinacion);

                            }
                        }
                    });
        } else {
            // error
            Toast.makeText(getContext(), "La semilla seleccionada no coincide con 'berenjena'", Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
