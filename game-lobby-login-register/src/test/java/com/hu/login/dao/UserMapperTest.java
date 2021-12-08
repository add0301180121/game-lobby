package com.hu.login.dao;

import com.hu.login.config.DataConfig;
import com.hu.login.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hu
 * @date 2021/12/3
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        User user2 = new User();
        user.setId("111");
        user.setName("张三");
        user.setPassword("123456");
        user2.setId("122");
        user2.setName("李四");
        user2.setPassword("123");
        System.out.println(userMapper.insertUser(user));
        System.out.println(userMapper.insertUser(user2));
        System.out.println(userMapper.getUserList());
        System.out.println(userMapper.findByName("张三"));
        System.out.println(userMapper.findByNameAndPassword("张三", "123456"));
        user.setPassword("1234");
        System.out.println(userMapper.updatePassword(user));
        System.out.println(userMapper.findByName("张三"));
        userMapper.deleteUser();
    }

}
