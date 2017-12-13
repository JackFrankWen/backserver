package com.jackfrank.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by jack on 17-12-12.
 */
@Transactional
public abstract class AbstractRepository {
    @PersistenceContext
    protected EntityManager em;

    protected Criteria createCriteria(final Class<?> persistenceClass) {
        return em.unwrap(Session.class).createCriteria(persistenceClass);
    }
}
