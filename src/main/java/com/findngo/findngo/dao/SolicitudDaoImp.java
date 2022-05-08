package com.findngo.findngo.dao;

import com.findngo.findngo.models.Recinto;
import com.findngo.findngo.models.Solicitud;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SolicitudDaoImp implements SolicitudDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Solicitud> getSolicitudes() {
        String query = "FROM Solicitud";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void rechazar(int id) {

    }

    @Override
    public void aceptar(int id) {

    }
}
