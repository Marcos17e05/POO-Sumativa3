package com.llanquihuetour.tours.model;

public class GuiaTuristico extends RecursoAgencia implements Registrable{

    private String idioma;
    private int experienciaAnios;

    public GuiaTuristico(String nombre, String idioma, int experienciaAnios) {
        super(nombre);
        this.idioma = idioma;
        this.experienciaAnios = experienciaAnios;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getExperienciaAnios() {
        return experienciaAnios;
    }

    @Override
    public String mostrarResumen() {
        return "Guía Turístico: " + nombre
                + " | Idioma: " + idioma
                + " | Experiencia: " + experienciaAnios + " años";
    }
}