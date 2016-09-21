package com.itis.dz.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by Marsel on 20.09.2016.
 */
@Repository
public class CommonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Object getById(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Object.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
}
