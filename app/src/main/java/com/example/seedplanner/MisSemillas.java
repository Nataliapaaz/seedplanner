package com.example.seedplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class MisSemillas extends Fragment {
    private ArrayList<Inventario> listado;
    private Adaptador adaptador; // Declarar adaptador a nivel de clase
    private FirebaseFirestore db; // Declarar db a nivel de clase

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializa la variable db
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mis_semillas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView l = view.findViewById(R.id.lvSemillas);
        listado = new ArrayList<>();
        adaptador = new Adaptador(getContext(), listado); // Inicializa adaptador
        l.setAdapter(adaptador);
        cargarDatos();
    }

    public void cargarDatos() {
        // consulta a Firestore colección "inventario"
        db.collection("inventario")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            listado.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Inventario inventario = document.toObject(Inventario.class);
                                listado.add(inventario);
                            }

                            adaptador.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), "Error al cargar las opciones", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
