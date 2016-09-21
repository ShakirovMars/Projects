package com.itis.dz.repositories;

import com.itis.dz.domain.UserInfo;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Marsel on 20.09.2016.
 */
@Repository
public class UserRepository extends CommonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(UserInfo user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(UserInfo user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public UserInfo getByEmail(String email) {
        return (UserInfo) sessionFactory.getCurrentSession().createCriteria(UserInfo.class).add(Restrictions.eq("email", email)).uniqueResult();
    }

    public List<UserInfo> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(UserInfo.class).list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void update(UserInfo user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
