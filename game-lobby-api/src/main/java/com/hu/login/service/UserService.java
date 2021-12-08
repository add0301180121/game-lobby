package com.hu.login.service;

import com.hu.login.entity.User;

/**
 * @author hu
 * @date 2021/12/3
 */
public interface UserService {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    Boolean login(User user);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Boolean register(User user);
}
