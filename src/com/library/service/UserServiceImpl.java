package com.library.service;

import com.library.dao.UserDAO;
import com.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveUser(User theUser) {

        userDAO.saveUser(theUser);
    }

  /*  @Override
    public List<User> getUsers() {

        return userDAO.getUsers();
    }*/


}
