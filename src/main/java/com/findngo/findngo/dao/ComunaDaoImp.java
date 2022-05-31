package com.findngo.findngo.dao;

import com.findngo.findngo.models.Comuna;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Esta clase es una implementacion de la clase Dao, la cual se encarga
 * de traer resultados desde la base de datos, en este caso de Comunas.
 */

@Repository
@Transactional
public class ComunaDaoImp implements ComunaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional

    /**
     * Obtiene las comunas utilizando una sentencia SQL para traerlas absoluatemente todas.
     * @return ResultList transformado a Lista de tipo Comuna.
     */
    public List<Comuna> getComunas() {
        String query = "FROM Comuna";
        return entityManager.createQuery(query).getResultList();
    }
}
