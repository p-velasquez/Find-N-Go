package com.findngo.findngo.dao;

import com.findngo.findngo.models.Deporte;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * Esta clase es una implementacion de la clase Dao, la cual se encarga
 * de traer resultados desde la base de datos, en este caso de Deportes.
 */
@Repository
@Transactional
public class DeporteDaoImp implements DeporteDao{

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Obtiene todos los deportes de la base de datos ejecutando una query de sql
     * @return ResultList transformado a Lista de tipo Deporte
     */
    @Override
    @Transactional
    public List<Deporte> getDeportes() {
        String query = "FROM Deporte";
        return entityManager.createQuery(query).getResultList();
    }
}
