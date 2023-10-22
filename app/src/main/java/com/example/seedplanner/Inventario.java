package com.example.seedplanner;

public class Inventario {
    private String semilla;

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
}
