package com.findngo.findngo.dao;

import com.findngo.findngo.models.Calificacion;

import java.util.List;



/**
 * Esta clase tiene metodos los cuales son llamados desde DaoImp para ser utilizados por el controlador.
 */
public interface CalificacionDao {
    /**
     * Esta metodo traer una lista de calificaciones.
     * @return : retorna una lista de calificaciones utilizando modelos.
     */
    List<Calificacion> getCalificaciones();

}
