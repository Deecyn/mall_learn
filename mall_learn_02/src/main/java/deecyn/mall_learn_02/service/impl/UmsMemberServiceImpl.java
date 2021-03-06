package deecyn.mall_learn_02.service.impl;

import deecyn.mall_learn_02.common.api.ResponseMsg;
import deecyn.mall_learn_02.service.RedisService;
import deecyn.mall_learn_02.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Resource
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 获取验证码
     */
    @Override
    public ResponseMsg<Object> generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return ResponseMsg.success("获取验证码成功", sb.toString());
    }

    /**
     * 对输入的验证码进行校验
     */
    @Override
    public ResponseMsg<Object> verifyAuthCode(String telephone, String authCode) {

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return realAuthCode.equals(authCode) ? ResponseMsg.success("验证码校验成功") : ResponseMsg.failed("验证码不正确");
    }
}
