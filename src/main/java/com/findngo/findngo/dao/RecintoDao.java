package com.findngo.findngo.dao;

import com.findngo.findngo.models.Recinto;

import java.util.List;

public interface RecintoDao {
    List<Recinto> getRecintos();
    void crearRecinto(Recinto recinto);
    void cambiarEstado();
}
