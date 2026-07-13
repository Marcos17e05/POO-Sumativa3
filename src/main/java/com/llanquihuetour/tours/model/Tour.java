package com.llanquihuetour.tours.model;

public class Tour {

    private String nombre;
    private String comuna;
    private double precio;

    public Tour(String nombre, String comuna, double precio) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "nombre='" + nombre + '\'' +
                ", comuna='" + comuna + '\'' +
                ", precio=" + precio +
                '}';
    }
}
