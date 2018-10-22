package com.library.dao;

import com.library.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User theUser) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theUser);

    }

/*
    @Override
    public List<User> getUsers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> theQuery = currentSession.createQuery(
                "from User ordered by username", User.class);

        List<User> users = theQuery.getResultList();

        return users;
    }
*/

}
