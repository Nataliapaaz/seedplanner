package com.example.seedplanner;

import java.util.HashMap;

public class Inventario {
    private String semilla;


    private static HashMap<String, String> descripciones;

    static {
        descripciones = new HashMap<>();
        descripciones.put("tomate", "Semilla de tomate, conocida por su gran adaptabilidad.");
        descripciones.put("papa", "Semilla de papa, ideales para cultivos en regiones áridas.");
    }

    public Inventario() {
        // Constructor vacío necesario para Firestore
    }

    public Inventario(String semilla) {
        this.semilla = semilla;
    }

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public String getNombre() {
        return semilla;
    }

    public String getDescripcion() {
        return descripciones.get(semilla);
    }
}
