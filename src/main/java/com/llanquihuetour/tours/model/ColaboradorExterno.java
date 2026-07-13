package com.llanquihuetour.tours.model;

public class ColaboradorExterno extends RecursoAgencia {

    private String servicioPrestado;
    private String telefono;

    public ColaboradorExterno(String nombre, String servicioPrestado, String telefono) {
        super(nombre);
        this.servicioPrestado = servicioPrestado;
        this.telefono = telefono;
    }

    public String getServicioPrestado() {
        return servicioPrestado;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String mostrarResumen() {
        return "Colaborador Externo: " + nombre
                + " | Servicio: " + servicioPrestado
                + " | Teléfono: " + telefono;
    }
}