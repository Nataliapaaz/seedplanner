package com.example.seedplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class FootSquare extends Fragment {
    private Spinner opciones;
    private ImageView imageView;

    private Button verButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foot_square, container, false);

        opciones = view.findViewById(R.id.opciones);
        imageView = view.findViewById(R.id.imageView4);
        verButton = view.findViewById(R.id.ver);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.opciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opciones.setAdapter(adapter);

        opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Opción del Spinner
                String opcionSeleccionada = opciones.getSelectedItem().toString();

                // Cambiar la imagen
                if (opcionSeleccionada.equals("Verduras")) {
                    imageView.setImageResource(R.drawable.verduras);
                } else if (opcionSeleccionada.equals("Hierbas")) {
                    imageView.setImageResource(R.drawable.hierbas);
                } else {
                    imageView.setImageResource(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // errores
            }
        });

        verButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opción seleccionada
                String opcionSeleccionada = opciones.getSelectedItem().toString();

                // Cambiar la imagen
                if (opcionSeleccionada.equals("Verdura")) {
                    imageView.setImageResource(R.drawable.verduras);
                } else if (opcionSeleccionada.equals("Hierbas")) {
                    imageView.setImageResource(R.drawable.hierbas);
                }
            }
        });

        return view;
    }
}