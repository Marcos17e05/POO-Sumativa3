package com.llanquihuetour.tours.service;

import com.llanquihuetour.tours.model.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TourService {

    private final List<Tour> tours;

    public TourService(List<Tour> toursIniciales) {
        this.tours = toursIniciales;
    }

    public List<Tour> listarTodos() {
        return new ArrayList<>(tours);
    }

    public Optional<Tour> buscarPorNombre(String nombre) {
        return tours.stream()
                .filter(tours -> tours.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public List<Tour> filtrarPorComuna(String comuna) {
        return tours.stream()
                .filter(tour -> tour.getComuna().equalsIgnoreCase(comuna.trim()))
                .toList();
    }

    public List<Tour> filtrarPorPrecioMenorA(double precioMaximo) {
        return tours.stream()
                .filter(t -> t.getPrecio() < precioMaximo)
                .toList();
    }

    public int totalRegistros() {
        return tours.size();
    }
}