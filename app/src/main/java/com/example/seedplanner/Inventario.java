package com.example.seedplanner;

public class Inventario {
    private String semilla;

    public Inventario() {
        // Constructor vacío requerido por Firestore
    }

    public Inventario(String semilla) {
        this.semilla = semilla;
    }

    public String getSemilla() {
        return semilla;
    }
}
