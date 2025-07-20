package com.lucianobrito.poc.javaee.services.domain.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * @param <T> Entidade
 * @param <P> primary key
 */
public abstract class BaseEntity<T, P> {

    @PersistenceContext
    private EntityManager entityManager;


    public List<T> findAll(Class<T> clazz) {
        String jpql = "from " + clazz.getSimpleName();
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        return query.getResultList();
    }

    public T findById(P id, Class<T> clazz) {
        return entityManager.find(clazz, id);
    }

    public T persist(T entity) {
        entityManager.persist(entity);
        return entity;
    }

}
