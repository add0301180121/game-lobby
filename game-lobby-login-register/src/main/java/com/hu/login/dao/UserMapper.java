package com.hu.login.dao;

import com.hu.login.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;

/**
 * @author hu
 * @date 2021/12/3
 */
@Mapper
@CacheNamespace(blocking = true, eviction = FifoCache.class)
public interface UserMapper {
    /**
     * 获取所有用户
     *
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> getUserList();

    /**
     * 通过name查找用户
     *
     * @param name
     * @return
     */
    @Select("SELECT * FROM user WHERE name=#{name,jdbcType=VARCHAR}")
    User findByName(@Param("name") String name);

    /**
     * 通过name password查找用户
     *
     * @param name
     * @param password
     * @return
     */
    @Select("SELECT * FROM user WHERE name=#{name,jdbcType=VARCHAR} AND password=#{password,jdbcType=VARCHAR}")
    User findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Insert("INSERT INTO user (id,name,password) VALUES (#{id},#{name},#{password})")
    boolean insertUser(User user);

    /**
     * 清库
     */
    @Delete("delete from user")
    void deleteUser();

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Update("UPDATE user SET password=#{password} WHERE name=#{name}")
    boolean updatePassword(User user);
}
