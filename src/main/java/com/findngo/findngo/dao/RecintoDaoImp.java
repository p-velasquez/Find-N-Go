package com.findngo.findngo.dao;

import com.findngo.findngo.models.Recinto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RecintoDaoImp implements RecintoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Recinto> getRecintos() {
        String query = "FROM Recinto";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void crearRecinto(Recinto recinto) {
        entityManager.merge(recinto);
    }

    @Override
    public void cambiarEstado() {

    }
}
