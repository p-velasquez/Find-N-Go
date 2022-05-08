package com.findngo.findngo.dao;

import com.findngo.findngo.models.Solicitud;

import java.util.List;

public interface SolicitudDao {
    List<Solicitud> getSolicitudes();
    void rechazar(int id);
    void aceptar(int id);
}
