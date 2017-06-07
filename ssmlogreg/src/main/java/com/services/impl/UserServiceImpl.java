package com.services.impl;

import com.dao.UserDao;
import com.entities.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: 徐鹏举.
 * DateTime: 2017/5/30-21:42.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public int findByName(User user) {
        return userDao.findByName(user);
    }

    @Override
    public int findByNameAndPass(User user) {
        return userDao.findByNameAndPass(user);
    }

}
