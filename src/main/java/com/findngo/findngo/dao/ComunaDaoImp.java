package com.findngo.findngo.dao;

import com.findngo.findngo.models.Comuna;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ComunaDaoImp implements ComunaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Comuna> getComunas() {
        String query = "FROM Comuna";
        return entityManager.createQuery(query).getResultList();
    }
}
