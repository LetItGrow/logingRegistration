package com.user;

import com.dao.UserDao;
import com.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: 徐鹏举.
 * DateTime: 2017/6/3-10:42.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:springMybatis.xml" })
public class UserTest {
    @Autowired
    private UserDao userDao;

    // 测试注册功能
    @Test
    public void save() {
        User user = new User();
        user.setName("张三");
        user.setPass("123123");
        userDao.insert(user);
    }

    // 测试用户名是否存在
    @Test
    public void findByName(){
        User user = new User();
        user.setName("张三");
        int count = userDao.findByName(user);
        // System.out.println(count); //1 存在 ； 0 不存在

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("num",count);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    // 验证用户名和密码是否存在
    @Test
    public void findByNameAndPass(){
        User user = new User();
        user.setName("张三");
        user.setPass("123123");

        int count = userDao.findByNameAndPass(user);
        System.out.println(count); //1 存在 ； 0 不存在
    }
}
