package com.example.seedplanner;

import java.io.Serializable;

public class Semillas implements Serializable {

    private String ruta;
    private String nombre;
    private String estacion;

    public Semillas(String ruta, String nombre, String estacion) {
        this.ruta = ruta;
        this.nombre = nombre;
        this.estacion = estacion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    @Override
    public String toString() {
        return "Semillas{" +
                "ruta='" + ruta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estacion='" + estacion + '\'' +
                '}';
    }
}

