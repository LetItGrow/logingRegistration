package com.dao.impl;

import com.dao.UserDao;
import com.entities.User;

/**
 * Created by IntelliJ IDEA.
 * User: 徐鹏举.
 * DateTime: 2017/6/5-13:38.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        //设置命名空间
        super.setNs("com.dao.UserDao");
    }

    @Override
    public int findByName(User user) {
        return 0;
    }

    @Override
    public int findByNameAndPass(User user) {
        return 0;
    }
}
