package deecyn.mall_learn_13.controller;

import deecyn.mall_learn_13.common.RegexRuleEnum;
import deecyn.mall_learn_13.common.api.ResponseMsg;
import deecyn.mall_learn_13.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
@Api(tags = "UmsMemberController", value = "会员登录、注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Resource
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAutCode")
    public ResponseMsg<String> getAuthCode(@RequestParam String telephone) {
        if (StringUtils.isEmpty(telephone) || !Pattern.matches(RegexRuleEnum.TELEPHONE_REGEX.value(), telephone)) {
            return ResponseMsg.failed("请输入正确的手机号");
        }

        return ResponseMsg.success(umsMemberService.generateAuthCode(telephone));
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public ResponseMsg<Object> verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
        if (StringUtils.isEmpty(telephone) || !Pattern.matches(RegexRuleEnum.TELEPHONE_REGEX.value(), telephone)) {
            return ResponseMsg.failed("请输入正确的手机号");
        }
        if (StringUtils.isEmpty(authCode)) return ResponseMsg.failed("请输入验证码");

        return ResponseMsg.success(umsMemberService.verifyAuthCode(telephone, authCode));
    }

}
