package com.dao;

import com.entities.User;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: 徐鹏举.
 * DateTime: 2017/5/30-21:39.
 */
@Repository
public interface UserDao extends BaseDao<User> {
    //  判断用户名是否存在
    public int findByName(User user);

    //  验证登陆用户名和密码
    public int findByNameAndPass(User user);
}
