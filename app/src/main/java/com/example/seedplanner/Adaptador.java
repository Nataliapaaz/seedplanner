package com.example.seedplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context contexto;
    private ArrayList<Inventario> listItems;

    public Adaptador(Context contexto, ArrayList<Inventario> listItems) {
        this.contexto = contexto;
        this.listItems = listItems;
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
        TextView smNombre = (TextView) view.findViewById(R.id.smNombre);
        Inventario inventario = (Inventario) getItem(i);
        smNombre.setText(inventario.getSemilla());
        return view;
    }
}



