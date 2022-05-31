package com.findngo.findngo.service;

import com.findngo.findngo.models.Espaciodeportivo;

import java.util.List;

/**
 * Interfaz de servicio
 */
public interface EDService {
    /**
     * Declaracion de metodo
     * @param query query
     * @return Lista
     */
    List<Espaciodeportivo> buscarED(String query);

    /**
     * Declaracion de metodo
     * @param query query
     * @return Lista
     */
    List<Espaciodeportivo> buscarId(String query);

    /**
     * Declaracion de metodo
     * @param ed Objeto espacio deportivo
     * @return Objeto creado
     */
    Espaciodeportivo createEd(Espaciodeportivo ed);
}
