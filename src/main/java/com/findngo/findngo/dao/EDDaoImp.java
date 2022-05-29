package com.findngo.findngo.dao;

import com.findngo.findngo.models.Espaciodeportivo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EDDaoImp implements EDDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Espaciodeportivo> getEds() {
        String query = "FROM Espaciodeportivo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Espaciodeportivo> getCoincidence(String busqueda) {
        String query = "FROM Espaciodeportivo WHERE nombre LIKE :nombre";
        List<Espaciodeportivo> lista = entityManager.createQuery(query)
                .setParameter("nombre", busqueda)
                .getResultList();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Espaciodeportivo ed = entityManager.find(Espaciodeportivo.class, id);
        entityManager.remove(ed);
    }

    @Override
    public void insert(Espaciodeportivo ed) {
        entityManager.merge(ed);
    }
}
