package com.llanquihuetour.tours.ui;

import com.llanquihuetour.tours.data.GestorEntidades;
import com.llanquihuetour.tours.model.GuiaTuristico;
import com.llanquihuetour.tours.model.Vehiculo;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        GestorEntidades gestor = new GestorEntidades();

        boolean continuar = true;

        try {
            while (continuar) {
                String opcion = JOptionPane.showInputDialog(
                        null,
                        "Llanquihue Tour\n\n"
                                + "1. Registrar guía turístico\n"
                                + "2. Registrar vehículo\n"
                                + "3. Mostrar registros\n"
                                + "\n"
                                + "Seleccione una opción:",
                        "Sistema de gestión",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (opcion == null) {
                    break;
                }

                switch (opcion) {
                    case "1":
                        registrarGuia(gestor);
                        break;
                    case "2":
                        registrarVehiculo(gestor);
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(
                                null,
                                gestor.mostrarEntidadesConTipo(),
                                "Registros existentes",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                                null,
                                "Opción no válida. Intente nuevamente.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                }
            }

            JOptionPane.showMessageDialog(null, "Sistema finalizado.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Algo salió mal. El programa se cerrará.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);
        }
    }

    private static void registrarGuia(GestorEntidades gestor) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del guía:");
        String idioma = JOptionPane.showInputDialog("Ingrese el idioma del guía:");
        int experiencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los años de experiencia:"));

        gestor.agregarEntidad(new GuiaTuristico(nombre, idioma, experiencia));

        JOptionPane.showMessageDialog(null, "Guía turístico registrado correctamente.");
    }

    private static void registrarVehiculo(GestorEntidades gestor) {
        String nombre = JOptionPane.showInputDialog("Ingrese la marca del vehiculo:");
        String patente = JOptionPane.showInputDialog("Ingrese la patente del vehículo:");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo:");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de pasajeros:"));

        gestor.agregarEntidad(new Vehiculo(nombre, patente, tipo, capacidad));

        JOptionPane.showMessageDialog(null, "Vehículo registrado correctamente.");
    }
}