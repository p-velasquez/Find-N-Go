package com.findngo.findngo.dao;

import com.findngo.findngo.models.Espaciodeportivo;

import java.util.List;

public interface EDDao {
    List<Espaciodeportivo> getEds();
    List<Espaciodeportivo> getCoincidence(String busqueda);
}
