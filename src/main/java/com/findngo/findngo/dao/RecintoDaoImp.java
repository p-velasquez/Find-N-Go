package com.findngo.findngo.dao;

import com.findngo.findngo.models.Recinto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * Esta clase es una implementacion de la clase Dao, la cual se encarga
 * de traer resultados desde la base de datos, en este caso de Recintos..
 */

@Repository
@Transactional
public class RecintoDaoImp implements RecintoDao{

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Obtiene todos los Recintos mediante una consulta SQL
     * @return trae una result list de tipo Recinto.
     */
    @Override
    public List<Recinto> getRecintos() {
        String query = "FROM Recinto";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Permite crear un recinto mediante un objeto.
     * @param recinto : Corresponde al objeto recinto
     */
    @Override
    public void crearRecinto(Recinto recinto) {
        entityManager.merge(recinto);
    }

    @Override
    public void cambiarEstado() {

    }
}
