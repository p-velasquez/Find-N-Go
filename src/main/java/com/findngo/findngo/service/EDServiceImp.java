package com.findngo.findngo.service;

import com.findngo.findngo.models.Espaciodeportivo;
import com.findngo.findngo.repository.EDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de Espacio Deportivo
 */
@Service
public class EDServiceImp implements EDService{

    private EDRepository edRepository;

    /**
     * Constructor
     * @param edRepository objeto repositorio
     */
    public EDServiceImp(EDRepository edRepository) {
        this.edRepository = edRepository;
    }

    /**
     * Busca una lista de espacio deportivo por nombre de recinto o descripcion en la bd
     * @param query query
     * @return lista del espacio deportivo encontrado
     */
    @Override
    public List<Espaciodeportivo> buscarED(String query) {
        return edRepository.buscarED(query);
    }

    /**
     * Busca una lista de espacio deportivo por id en la bd
     * @param query query
     * @return lista del espacio deportivo encontrado
     */
    @Override
    public List<Espaciodeportivo> buscarId(String query) {
        return edRepository.buscarId(query);
    }

    /**
     * Crea un espacio deportivo y lo inserta en la bd
     * @param ed Objeto tipo Espaciodeportivo
     * @return lo guarda en la bd
     */
    @Override
    public Espaciodeportivo createEd(Espaciodeportivo ed) {
        return edRepository.save(ed);
    }
}
