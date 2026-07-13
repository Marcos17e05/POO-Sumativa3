package com.llanquihuetour.tours.data;

import com.llanquihuetour.tours.model.ExcursionCultural;
import com.llanquihuetour.tours.model.PaseoLacustre;
import com.llanquihuetour.tours.model.RutaGastronomica;
import com.llanquihuetour.tours.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;


public class GestorServicios {

    public List<ServicioTuristico> obtenerServicios() {



        List<ServicioTuristico> servicios = new ArrayList<>();

        servicios.add(new RutaGastronomica(
                "Ruta del Salmón",
                4,
                5));

        servicios.add(new RutaGastronomica(
                "Sabores del Sur",
                3,
                4));

        servicios.add(new PaseoLacustre(
                "Lago Llanquihue",
                2,
                "Bote"));

        servicios.add(new PaseoLacustre(
                "Río Maullín",
                3,
                "Lancha"));

        servicios.add(new ExcursionCultural(
                "Puerto Varas Histórico",
                5,
                "Muelle Frutillar"));

        servicios.add(new ExcursionCultural(
                "Frutillar Patrimonial",
                4,
                "Casa Von Bischoffshaussen"));

        return servicios;
    }
}
