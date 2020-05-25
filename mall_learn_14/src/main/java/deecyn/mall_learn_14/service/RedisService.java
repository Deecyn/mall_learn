package deecyn.mall_learn_14.service;


import java.util.concurrent.TimeUnit;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public interface RedisService {

    /**
     * 存储数据
     * @param key 键值
     * @param value key 对应的 value 值
     */
    void set(String key, String value);

    /**
     * 查询数据
     * @param key 键值
     * @return key 对应的 value 值
     */
    String get(String key);

    /**
     * 删除数据
     * @param key 键值
     * @return key 对应的 value 值
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key 键值
     * @param step 步长
     * @return
     */
    Long increment(String key, long step);

    /**
     * 设置超期时间
     * @param key 键值
     * @param expire 超期时间，单位秒
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
}

