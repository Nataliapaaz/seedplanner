package com.example.seedplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import android.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context contexto;
    private ArrayList<Inventario> listItems;
    private FirebaseFirestore db; // Agrega una instancia de FirebaseFirestore

    public Adaptador(Context contexto, ArrayList<Inventario> listItems, FirebaseFirestore db) {
        this.contexto = contexto;
        this.listItems = listItems;
        this.db = db; // Inicializa la instancia de FirebaseFirestore
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(contexto).inflate(R.layout.items_listview, null);
        TextView smNombre = view.findViewById(R.id.smNombre);
        Button eliminar = view.findViewById(R.id.eliminar);

        final Inventario inventario = (Inventario) getItem(i);
        smNombre.setText(inventario.getSemilla());

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realiza la eliminación del documento correspondiente en Firestore
                String nombreDocumento = inventario.getSemilla();
                eliminarDocumento(nombreDocumento);
            }
        });

        return view;
    }

    public void eliminarDocumento(String nombreSemilla) {
        // Referencia a la colección "inventario"
        CollectionReference inventarioRef = db.collection("inventario");

        // Consulta para encontrar documentos que coincidan con el nombre de semilla
        Query query = inventarioRef.whereEqualTo("semilla", nombreSemilla);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        // Obten el ID del documento y elimínalo
                        String documentId = document.getId();
                        inventarioRef.document(documentId).delete();
                    }
                } else {
                    Toast.makeText(contexto, "Error al eliminar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cargarDatos() {
        // consulta a Firestore colección "inventario"
        db.collection("inventario")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            listItems.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Inventario inventario = document.toObject(Inventario.class);
                                listItems.add(inventario);
                            }

                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(contexto, "Error al cargar las opciones", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}



