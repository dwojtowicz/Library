package com.library.dao;

import com.library.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User theUser) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theUser);

    }

}
