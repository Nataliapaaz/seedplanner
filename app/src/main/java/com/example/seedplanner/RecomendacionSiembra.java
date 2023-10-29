package com.example.seedplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;


public class RecomendacionSiembra extends Fragment {

    private Spinner mesesSpinner;
    private ArrayAdapter<String> mesesAdapter;
    private ArrayList<String> mesesList = new ArrayList<>();

    private Spinner climaSpinner;
    private ArrayAdapter<String> climaAdapter;
    private ArrayList<String> climaList = new ArrayList<>();

    public RecomendacionSiembra() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recomendacion_siembra, container, false);

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

        mesesSpinner = view.findViewById(R.id.meses2);
        mesesAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, mesesList);
        mesesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mesesSpinner.setAdapter(mesesAdapter);

        climaList.clear();
        climaList.add("Arido");
        climaList.add("Húmedo");
        climaList.add("Polar");
        climaList.add("Tropical");

        climaSpinner = view.findViewById(R.id.clima);
        climaAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, climaList);
        climaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        climaSpinner.setAdapter(climaAdapter);

        Button button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seleccion del Spinner
                String selectedMes = mesesSpinner.getSelectedItem().toString();
                String selectedClima = climaSpinner.getSelectedItem().toString();
                // Cargar InfoRecomendacion
                InfoRecomendacion infoFragment = new InfoRecomendacion();
                Bundle args = new Bundle();
                args.putString("selectedMes", selectedMes);
                args.putString("selectedClima", selectedClima);
                infoFragment.setArguments(args);

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, infoFragment);
                transaction.addToBackStack(null); // Opcional: para agregar la transacción a la pila de retroceso
                transaction.commit();
            }
        });


        return view;
    }


}