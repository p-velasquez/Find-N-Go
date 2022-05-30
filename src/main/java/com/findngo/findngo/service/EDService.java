package com.findngo.findngo.service;

import com.findngo.findngo.models.Espaciodeportivo;

import java.util.List;

public interface EDService {
    List<Espaciodeportivo> buscarED(String query);

    Espaciodeportivo createEd(Espaciodeportivo ed);
}
