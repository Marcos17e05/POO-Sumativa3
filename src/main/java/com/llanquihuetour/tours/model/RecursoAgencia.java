package com.llanquihuetour.tours.model;

public class RecursoAgencia implements Registrable {

    protected String nombre;

    public RecursoAgencia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String mostrarResumen() {
        return "";
    }
}