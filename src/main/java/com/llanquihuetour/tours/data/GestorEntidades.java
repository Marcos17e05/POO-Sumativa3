package com.llanquihuetour.tours.data;

import com.llanquihuetour.tours.model.ColaboradorExterno;
import com.llanquihuetour.tours.model.GuiaTuristico;
import com.llanquihuetour.tours.model.Registrable;
import com.llanquihuetour.tours.model.Vehiculo;

import java.util.ArrayList;

public class GestorEntidades {

    private final ArrayList<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        entidades.add(new GuiaTuristico(
                "Mario Hugo",
                "Español e Catalan",
                5
        ));

        entidades.add(new GuiaTuristico(
                "Maria Tunez",
                "ingles",
                3
        ));

        entidades.add(new Vehiculo(
                "Bus turismo",
                "JDYH45",
                "Bus turística",
                43
        ));

        entidades.add(new Vehiculo(
                "Minibús Tukepe",
                "LDKE34",
                "Minibús",
                20
        ));

        entidades.add(new ColaboradorExterno(
                "Pichanga Rural",
                "Alimentación para excursiones",
                "+56983742841"
        ));
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    public ArrayList<Registrable> obtenerEntidades() {
        return entidades;
    }
    //Puede almecenar cualquier objeto que implemente Registrable, aunque este no se hedere de RecursoAgencia.

    public String mostrarEntidadesConTipo() {
        StringBuilder resumen = new StringBuilder();
        //
        for (Registrable entidad : entidades) {
            resumen.append(entidad.mostrarResumen()).append("\n");

            if (entidad instanceof GuiaTuristico) {
                resumen.append("Tipo detectado: Guía turístico asignable a rutas y excursiones.\n");
            } else if (entidad instanceof Vehiculo) {
                resumen.append("Tipo detectado: Vehículo disponible para traslado de pasajeros.\n");
            } else if (entidad instanceof ColaboradorExterno) {
                resumen.append("Tipo detectado: Colaborador externo asociado a servicios complementarios.\n");
            }

            resumen.append("-----------------\n");
        }

        return resumen.toString();
    }
}