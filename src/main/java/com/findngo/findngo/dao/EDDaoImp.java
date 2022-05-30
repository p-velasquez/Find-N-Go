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

    /**
     * Obtiene todos los recintos deportivos ejecutando una query de sql
     * @return ResultList transformado a Lista de tipo EspacioDeportivo
     */
    @Override
    @Transactional
    public List<Espaciodeportivo> getEds() {
        String query = "FROM Espaciodeportivo";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     *
     * @param id recibe el id tipo int
     * @return
     */
    @Override
    public List<Espaciodeportivo> getEdById(int id) {
        String query = "FROM Espaciodeportivo WHERE id_ed = :id";
        List<Espaciodeportivo> ed = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        return entityManager.createQuery(query).getResultList();
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        Espaciodeportivo ed = entityManager.find(Espaciodeportivo.class, id);
        entityManager.remove(ed);
    }

    /**
     *
     * @param ed
     */
    @Override
    public void insert(Espaciodeportivo ed) {
        entityManager.merge(ed);
    }
}
