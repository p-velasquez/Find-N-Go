package com.findngo.findngo.dao;

import com.findngo.findngo.models.Espaciodeportivo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Esta clase es una implementacion de la clase Dao, la cual se encarga
 * de traer resultados desde la base de datos, en este caso de espacios deportivos.
 */

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
     * @param id: corresponde al id del espacio deportivo a eliminar.
     */
    @Override
    public void delete(int id) {
        Espaciodeportivo ed = entityManager.find(Espaciodeportivo.class, id);
        entityManager.remove(ed);
    }

    /**
     *
     * @param ed: corresponde al objeto de espacio deportivo.
     */
    @Override
    public void insert(Espaciodeportivo ed) {
        entityManager.merge(ed);
    }
}
