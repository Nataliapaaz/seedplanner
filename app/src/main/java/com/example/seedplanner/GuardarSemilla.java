package com.example.seedplanner;

import android.content.Context;
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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
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
        final Context context = getContext();

        // Firestore ID de los documentos
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("lista")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String id = document.getId();
                                adapter.add(id);
                            }
                            spinner.setAdapter(adapter);
                        } else {
                            Toast.makeText(context, "Error al cargar las opciones", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOption = spinner.getSelectedItem().toString();

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                // Colección "inventario"
                CollectionReference inventarioRef = db.collection("inventario");

                // Verificar si ya existe un documento con el mismo nombre
                Query query = inventarioRef.whereEqualTo("nombre", selectedOption);

                query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().isEmpty()) {
                                // No hay documentos con el mismo nombre, por lo que podemos agregar uno nuevo
                                Inventario inventario = new Inventario(selectedOption);
                                inventarioRef.add(inventario)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(getContext(), "Semilla guardada en inventario", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getContext(), "Error al guardar la opción", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            } else {
                                // Ya existe un documento con el mismo nombre
                                Toast.makeText(getContext(), "La semilla ya existe en el inventario", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "Error al verificar la opción", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        return view;
    }
}
