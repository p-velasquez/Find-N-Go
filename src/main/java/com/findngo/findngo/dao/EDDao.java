package com.findngo.findngo.dao;

import com.findngo.findngo.models.Espaciodeportivo;

import java.util.List;

public interface EDDao {
    List<Espaciodeportivo> getEds();
    Espaciodeportivo getEdById(int id);
    List<Espaciodeportivo> getCoincidence(String busqueda);
    void delete(int id);
    void insert(Espaciodeportivo ed);
}
