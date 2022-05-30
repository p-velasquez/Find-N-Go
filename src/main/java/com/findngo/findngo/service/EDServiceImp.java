package com.findngo.findngo.service;

import com.findngo.findngo.models.Espaciodeportivo;
import com.findngo.findngo.repository.EDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EDServiceImp implements EDService{

    private EDRepository edRepository;

    public EDServiceImp(EDRepository edRepository) {
        this.edRepository = edRepository;
    }

    @Override
    public List<Espaciodeportivo> buscarED(String query) {
        return edRepository.buscarED(query);
    }

    @Override
    public Espaciodeportivo createEd(Espaciodeportivo ed) {
        return edRepository.save(ed);
    }
}
