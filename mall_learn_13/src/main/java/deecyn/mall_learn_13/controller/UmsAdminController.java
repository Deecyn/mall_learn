package deecyn.mall_learn_13.controller;

import com.alibaba.fastjson.JSONObject;
import deecyn.mall_learn_13.common.api.ResponseMsg;
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
     * 登录
     * @param jsonObject 目前为假数据
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseMsg<Object> login(@RequestBody JSONObject jsonObject) {
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", "abcd123");
        tokenMap.put("tokenHead", "abc");
        return ResponseMsg.success(tokenMap);
    }

    /**
     * 用户身份信息
     * @param principal 目前为假数据
     * @return
     */
    @GetMapping("/info")
    public ResponseMsg<Object> getAdminInfo(Principal principal) {
        Map<String, Object> data = new HashMap<>();
        data.put("username", "zhangsan");
        data.put("roles", new String[]{"TEST"});
        data.put("icon", "https://www.baidu.com/img/bd_logo1.png");
        return ResponseMsg.success(data);
    }

}
