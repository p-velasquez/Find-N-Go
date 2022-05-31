package com.findngo.findngo.dao;

import com.findngo.findngo.models.Espaciodeportivo;

import java.util.List;
/**
 *
 * Esta clase es la encargada de importar el modelo de datos para ser usado por el controlador.
 * Esta clase llama a los Espacios Deportivos existentes, segun sus condiciones.
 */
public interface EDDao {

    /**
     * Obtiene todos los espacios deportivos en general.
     * @return : retorna una lista de espacios deportivos.
     */
    List<Espaciodeportivo> getEds();

    /**
     * Borra el espacio deportivo segun el ID.
     * @param id : Corresponde al id del espacio deportivo.
     */
    void delete(int id);

    /**
     * Obtiene todos los espacios deportivos pero segun el ID
     * @param ed : Corresponde al objeto entero de espacio deportivo, el cual sera insertado en la BD.
     */
    void insert(Espaciodeportivo ed);
}
