package com.hu.login.service;

import com.hu.login.config.DataConfig;
import com.hu.login.dao.UserMapper;
import com.hu.login.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author hu
 * @date 2021/12/3
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserServiceImplTest {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        User user = new User();
        User user2 = new User();
        user.setName("张三");
        user.setPassword("123456");
        user2.setName("李四");
        user2.setPassword("123");
        User user3 = new User();
        User user4 = new User();
        user3.setName("张三");
        user3.setPassword("123456");
        user4.setName("李四");
        user4.setPassword("123");
        System.out.println("user注册: " + userService.register(user));
        System.out.println("user2注册: " + userService.register(user2));
        System.out.println("user3注册: " + userService.login(user3));
        System.out.println("user4注册: " + userService.login(user4));
        User user5 = new User();
        user5.setName("张三");
        user5.setPassword("123456");
        System.out.println("user5注册: " + userService.register(user5));
        userMapper.deleteUser();
    }

    @Test
    public void test2() {
        User user = new User();
        user.setName("李四");
        user.setPassword("111");
        System.out.println(userService.login(user));
    }

    @Test
    public void test3() {
        User user = new User();
        user.setName("李四");
        user.setPassword("12");
        System.out.println(userService.register(user));
    }

    @Test
    public void delete() {
        userMapper.deleteUser();
    }

    @Test
    public void login1() {
        User user = new User();
        user.setName("李四");
        user.setPassword("12");
        System.out.println(userService.updatePassword(user));
    }
}
