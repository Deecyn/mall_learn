package deecyn.mall_learn_14.service.impl;

import deecyn.mall_learn_14.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long step) {
        return stringRedisTemplate.opsForValue().increment(key, step);
    }

    @Override
    public Boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public Boolean expire(String key, long expire, TimeUnit timeUnit) {
        return stringRedisTemplate.expire(key, expire, timeUnit);
    }
}

