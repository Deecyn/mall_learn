package deecyn.mall_learn_02.service;

import deecyn.mall_learn_02.common.api.ResponseMsg;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 会员管理 Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone 手机号码
     * @return
     */
    ResponseMsg<Object> generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone 手机号码
     * @param authCode 验证码
     * @return
     */
    ResponseMsg<Object> verifyAuthCode(String telephone, String authCode);
}
