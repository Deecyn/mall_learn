package deecyn.mall_learn_14.service;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 会员管理 Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码，缓存到 Redis 里面
     * @param telephone 手机号
     * @return 验证码字符串
     */
    String generateAuthCode(String telephone);

    /**
     * 判断验证码与手机号是否匹配
     * @param telephone 手机号
     * @param authCode 验证码
     * @return
     */
    boolean verifyAuthCode(String telephone, String authCode);
}
