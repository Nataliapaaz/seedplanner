package com.example.seedplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MisSemillas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MisSemillas extends Fragment {
    private ArrayList<Semillas> listado;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_mis_semillas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView l = (ListView) view.findViewById(R.id.lvSemillas);
        Adaptador adaptador = new Adaptador(getContext(),cargar_datos());
        l.setAdapter(adaptador);
    }

    public ArrayList<Semillas> cargar_datos(){
        listado = new ArrayList<>();
        //listado.add(new Semillas());
        return listado;
    }



}