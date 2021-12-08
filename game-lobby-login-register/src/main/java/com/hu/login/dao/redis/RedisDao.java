package com.hu.login.dao.redis;

/**
 * @author hu
 * @date 2021/12/4
 */
public interface RedisDao {
    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    Boolean existKey(String key);

    /**
     * 获取value
     *
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 根据key 获取过期时间
     *
     * @param key
     * @return
     */
    Long getExpire(String key);

    /**
     * 指定缓存失效时间
     *
     * @param key
     * @param time 秒
     * @return
     */
    Boolean expire(String key, long time);

    /**
     * 删除缓存 可以删多个
     * @param key
     * @return
     */
    Boolean del(String... key);

    /**
     * 加入缓存
     * @param key
     * @param value
     * @return
     */
    Boolean set(String key, Object value);

    /**
     * 加入缓存并设置过期时间
     * @param key String
     * @param value Object
     * @param time 秒
     * @return boolean
     */
    Boolean set(String key, Object value, long time);
}
