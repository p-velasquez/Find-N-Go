package com.findngo.findngo.dao;

import com.findngo.findngo.models.Calificacion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Esta clase es una implementacion de la clase Dao, la cual se encarga
 * de traer resultados desde la base de datos, en este caso de calificaciones.
 */

@Repository
@Transactional
public class CalificacionDaoImp implements CalificacionDao {
    @PersistenceContext
    EntityManager entityManager;


    /**
     * Retorna una lista con todas las calificaciones existentes desde la base de datos
     * se utiliza una sentencia SQL para realizar la consulta directa.
     * @return ResultList transformado a Lista de tipo Calificacion
     */
    @Override
    @Transactional
    public List<Calificacion> getCalificaciones() {
        String query = "FROM Calificacion";
        return entityManager.createQuery(query).getResultList();
    }

}
