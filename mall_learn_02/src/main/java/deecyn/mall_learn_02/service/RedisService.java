package deecyn.mall_learn_02.service;

import java.util.concurrent.TimeUnit;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 操作 Redis 的 Service
 */
public interface RedisService {

    /**
     * 存储数据
     * @param key 键值
     * @param value 对应的 value 值
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @param key 键值
     * @return 对应的 value 值
     */
    String get(String key);

    /**
     * 设置超期时间
     * @param key 键值
     * @param expire 超期时间，秒
     * @return
     */
    Boolean expire(String key, long expire);

    /**
     * 设置超期时间
     * @param key 键值
     * @param expire 超期时间
     * @param timeUnit 超期时间单位
     * @return
     */
    Boolean expire(String key, long expire, TimeUnit timeUnit);

    /**
     * 删除数据
     * @param key 键值
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key 键值
     * @param step 自增步长
     * @return
     */
    Long increment(String key, long step);
}
