package com.findngo.findngo.dao;

import com.findngo.findngo.models.Deporte;

import java.util.List;

/**
 *
 * Esta clase es la encargada de importar el modelo de datos para ser usado por el controlador.
 * Esta clase llama a los deportes existentes.
 */
public interface DeporteDao {


    /**
     * Obtiene todos los deportes mediante una lista
     * @return : una lista de deportes.
     */
    List<Deporte> getDeportes();
}
