package deecyn.mall_learn_13.service.impl;

import deecyn.mall_learn_13.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

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
