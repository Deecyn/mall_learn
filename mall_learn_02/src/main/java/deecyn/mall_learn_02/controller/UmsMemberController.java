package deecyn.mall_learn_02.controller;

import deecyn.mall_learn_02.common.api.RegexRuleEnum;
import deecyn.mall_learn_02.common.api.ResponseMsg;
import deecyn.mall_learn_02.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 会员登录、注册管理 Controller
 */
@Api(tags = "UmsMemberController", value = "会员登录、注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Resource
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public ResponseMsg<Object> getAuthCode(@RequestParam String telephone) {
        if (!Pattern.matches(RegexRuleEnum.TELEPHONE__REGEX.value(), telephone)) {
            return ResponseMsg.failed("请输入正确的手机号");
        }
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public ResponseMsg<Object> verifyAuthCode(@RequestParam String telephone,
                                              @RequestParam String authCode) {
        if (!Pattern.matches(RegexRuleEnum.TELEPHONE__REGEX.value(), telephone)) {
            return ResponseMsg.failed("请输入正确的手机号");
        }
        if (StringUtils.isEmpty(authCode)) return ResponseMsg.failed("请输入验证码");

        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
