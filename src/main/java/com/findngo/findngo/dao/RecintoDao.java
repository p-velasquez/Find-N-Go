package com.findngo.findngo.dao;

import com.findngo.findngo.models.Recinto;

import java.util.List;

/**
 *
 * Esta clase es la encargada de importar el modelo de datos para ser usado por el controlador.
 * Esta clase llama a los Recintos existentes, segun sus condiciones.
 */
public interface RecintoDao {
    /**
     * Obtiene todos los recintos en una lista llamada Recinto
     * @return trae en una lista todos los recintos.
     */
    List<Recinto> getRecintos();
    /**
     * Permite crear un objeto de pito Recinto
     * @param recinto : Se recibo un objeto de tipo Recinto para poder setear.
     */
    void crearRecinto(Recinto recinto);

    /**
     * Permitira cambiar el estado de un recinto.
     */
    void cambiarEstado();
}
