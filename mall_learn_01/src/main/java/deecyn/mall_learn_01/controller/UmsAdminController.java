package deecyn.mall_learn_01.controller;

import com.alibaba.fastjson.JSONObject;
import deecyn.mall_learn_01.common.ResponseMsg;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 后台用户管理
 */
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    /**
     * 登录，目前为假数据
     * @param jsonObject
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseMsg login(@RequestBody JSONObject jsonObject) {
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", "abcd123");
        tokenMap.put("tokenHead", "abc");
        return ResponseMsg.success(tokenMap);
    }

    /**
     * 用户信息，目前为假数据
     * @param principal
     * @return
     */
    @GetMapping(value = "/info")
    public ResponseMsg getAdminInfo(Principal principal) {
        Map<String, Object> data = new HashMap<>();
        data.put("username", "zhangsan");
        data.put("roles", new String[]{"TEST"});
        data.put("icon", "https://www.baidu.com/img/bd_logo1.png");
        return ResponseMsg.success(data);
    }

}
