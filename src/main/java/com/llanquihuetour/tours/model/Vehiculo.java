package com.llanquihuetour.tours.model;

public class Vehiculo extends RecursoAgencia {

    private String patente;
    private String tipo;
    private int capacidadPasajeros;

    public Vehiculo(String nombre, String patente, String tipo, int capacidadPasajeros) {
        super(nombre);
        this.patente = patente;
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getPatente() {
        return patente;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    @Override
    public String mostrarResumen() {
        return "Vehículo: " + nombre
                + " | Tipo: " + tipo
                + " | Patente: " + patente
                + " | Capacidad: " + capacidadPasajeros + " pasajeros";
    }
}