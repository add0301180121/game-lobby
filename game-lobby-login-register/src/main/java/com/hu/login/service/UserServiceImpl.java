package com.hu.login.service;

import com.google.common.hash.Hashing;
import com.hu.login.dao.UserMapper;
import com.hu.login.dao.redis.RedisDaoImpl;
import com.hu.login.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author hu
 * @date 2021/12/3
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisDaoImpl redisDao;

    public User findUserByName(String name) {
        return userMapper.findByName(name);
    }

    public User findUserByNameAndPassword(String name, String password) {
        return userMapper.findByNameAndPassword(name, password);
    }

    @Override
    public Boolean login(User user) {
        if (!isExist(user)) {
            log.error("登录服务:user is null");
            return false;
        }

        if (redisDao.existKey(newKey(user.getName(), user.getPassword())) &&
                null != redisDao.get(newKey(user.getName(), user.getPassword()))) {
            return true;
        } else {
            User byNameAndPassword = findUserByNameAndPassword(user.getName(),
                    setSha256(user.getPassword()));
            int number = (int) (Math.random() * 1000) + 1;
            if (byNameAndPassword == null) {
                redisDao.set(newKey(user.getName(), user.getPassword()), null, number + 300);
                return false;
            }
            redisDao.set(newKey(user.getName(), user.getPassword()), user.getId(), number + 300);
            redisDao.set(user.getName(), null, number + 300);
        }
        return true;
    }

    @Override
    public Boolean register(User user) {
        if (!isExist(user)) {
            log.error("注册服务:user is null");
            return false;
        }

        if (redisDao.existKey(user.getName())) {
            return false;
        }
        User userByName = findUserByName(user.getName());
        // 重名
        if (userByName != null) {
            return false;
        }
        // sh256加密
        String newPass = setSha256(user.getPassword());
        user.setPassword(newPass);
        if (user.getId() == null || "".equals(user.getId())) {
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.replace("-", "");
            // uuid
            user.setId(uuid);
        }
        // 插入
        userMapper.insertUser(user);

        // redis操作
        int number = (int) (Math.random() * 1000) + 1;
        redisDao.set(user.getName() + "|" + setCrc32(user.getPassword()), setCrc32(user.getId()), number + 300);
        redisDao.set(user.getName(), null, number + 300);

        return true;
    }

    @Override
    public Boolean updatePassword(User user) {
        if (!isExist(user)) {
            log.error("更新密码服务:user is null");
            return false;
        }

        User userByName = findUserByName(user.getName());
        // 校验 用户名是否存在
        if (userByName == null) {
            return false;
        }
        return userMapper.updatePassword(user);
    }

    private boolean isExist(User user) {
        return null != user && null != (user.getName()) && null != (user.getPassword());
    }

    private String setSha256(String v) {
        return Hashing.sha256().hashBytes(v.getBytes()).toString();
    }

    private String setCrc32(String v) {
        return Hashing.crc32().hashBytes(v.getBytes()).toString();
    }

    private String newKey(String k, String v) {
        return k + "|" + setCrc32(v);
    }
}
