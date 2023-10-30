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

    private String nombreSemillaSeleccionada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_semilla, container, false);

        // Inicializa Firebase
        db = FirebaseFirestore.getInstance();

        Bundle bundle = getArguments();
        if (bundle != null) {
            nombreSemillaSeleccionada = bundle.getString("nombre");
        }

        if (nombreSemillaSeleccionada != null) {
            if (nombreSemillaSeleccionada.equals("berenjena")) {
                // Código para la berenjena
                db.collection("lista")
                        .document("berenjena")  // Documento Berenjena
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
            } else if (nombreSemillaSeleccionada.equals("coliflor")) {
                db.collection("lista")
                        .document("coliflor")  // Documento Coliflor
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
            } else if (nombreSemillaSeleccionada.equals("brocoli")) {
                db.collection("lista")
                        .document("brocoli")  // Documento Brocoli
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
            } else if (nombreSemillaSeleccionada.equals("lechuga")) {
                db.collection("lista")
                        .document("lechuga")  // Documento Lechuga
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
            } else if (nombreSemillaSeleccionada.equals("tomate")) {
                db.collection("lista")
                        .document("tomate")  // Documento Tomate
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
            } else if (nombreSemillaSeleccionada.equals("pepino")) {
                db.collection("lista")
                        .document("pepino")  // Documento Pepino
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
            } else if (nombreSemillaSeleccionada.equals("zapallo")) {
                db.collection("lista")
                        .document("zapallo")  // Documento Zapallo
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    // Acceder a campos
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
                // Error si la semilla seleccionada no se encuentra
                Toast.makeText(getContext(), "La semilla seleccionada no coincide con ninguna semilla conocida", Toast.LENGTH_SHORT).show();
            }
        }

        return view;
    }
}
