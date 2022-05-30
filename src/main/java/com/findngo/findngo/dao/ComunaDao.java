package com.findngo.findngo.dao;

import com.findngo.findngo.models.Comuna;

import java.util.List;
/**
 *
 * Esta clase es la encargada de importar el modelo de datos para ser usado por el controlador.
 */

public interface ComunaDao {


    /**
     * Obtiene todas las comunas mediante una lista.
     * @return :  lista de comunas
     */
    List<Comuna> getComunas();
}
