package com.services;

import com.entities.User;

/**
 * Created by IntelliJ IDEA.
 * User: 徐鹏举.
 * DateTime: 2017/5/30-21:42.
 */
public interface UserService {
    public void insert(User user);			//插入，用实体作为参数
    public int findByName(User user); // 验证用户名是否存在
    public int findByNameAndPass(User user); // 验证用户名和密码是否存在
}
