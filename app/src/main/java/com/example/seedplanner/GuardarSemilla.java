package com.example.seedplanner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class GuardarSemilla extends Fragment {

    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guardar_semilla, container, false);
        spinner = view.findViewById(R.id.spinner5);
        Button guardarButton = view.findViewById(R.id.button6);

        // Realiza una consulta a Firestore para obtener los _id de los documentos
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("lista") // Reemplaza "lista" con el nombre de tu colección en Firestore
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            // Procesa los resultados de la consulta y crea una lista de _id
                            final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String id = document.getId();
                                adapter.add(id);
                            }

                            // Configura el adaptador del Spinner
                            spinner.setAdapter(adapter);
                        } else {
                            // Maneja errores aquí
                            Toast.makeText(getContext(), "Error al cargar las opciones", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene la opción seleccionada en el Spinner
                String selectedOption = spinner.getSelectedItem().toString();

                // Crea una instancia de FirebaseFirestore
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                // Crea un nuevo documento en la colección "inventario" con la opción seleccionada
                db.collection("inventario")
                        .add(new Inventario(selectedOption))
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                // La opción seleccionada se ha guardado exitosamente
                                Toast.makeText(getContext(), "Opción guardada en inventario", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Ocurrió un error al guardar la opción seleccionada
                                Toast.makeText(getContext(), "Error al guardar la opción", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        return view;
    }
}
