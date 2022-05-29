package com.findngo.findngo.dao;

import com.findngo.findngo.models.Calificacion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CalificacionDaoImp implements CalificacionDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Calificacion> getCalificaciones() {
        String query = "FROM Calificacion";
        return entityManager.createQuery(query).getResultList();
    }

}
