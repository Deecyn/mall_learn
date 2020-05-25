package deecyn.mall_learn_14.controller;


import deecyn.mall_learn_14.common.api.ResponseMsg;
import deecyn.mall_learn_14.dto.UmsAdminLoginParam;
import deecyn.mall_learn_14.mbg.model.UmsAdmin;
import deecyn.mall_learn_14.mbg.model.UmsPermission;
import deecyn.mall_learn_14.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 后台用户管理
 */
@Api(tags = "UmsAdminController", value = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "登录，登录成功以后返回 token")
    @PostMapping(value = "/login")
    public ResponseMsg<Map<String, String>> login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult bindingResult) {
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) return ResponseMsg.validateFailed("用户名或密码错误");

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseMsg.success(tokenMap);
    }

    @ApiOperation(value = "后台用户注册")
    @PostMapping("/register")
    public ResponseMsg<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult bindingResult){
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin == null) return ResponseMsg.failed("注册失败");

        return ResponseMsg.success(umsAdmin);
    }

    @ApiOperation(value = "获取用户所有权限")
    @GetMapping("/permission/{adminId}")
    public ResponseMsg<List<UmsPermission>> getPermissionList(@PathVariable("adminId") Integer adminId) {
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return ResponseMsg.success(permissionList);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg<Object> logout() {
        return ResponseMsg.success(null);
    }

    /**
     * 用户身份信息
     * @param principal 目前为假数据
     * @return
     */
/*    @GetMapping("/info")
    public ResponseMsg<Object> getAdminInfo(Principal principal) {
        Map<String, Object> data = new HashMap<>();
        data.put("username", "zhangsan");
        data.put("roles", new String[]{"TEST"});
        data.put("icon", "https://www.baidu.com/img/bd_logo1.png");
        return ResponseMsg.success(data);
    }*/

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public ResponseMsg<Map<String, Object>> getAdminInfo(Principal principal) {
        if(principal == null){
            return ResponseMsg.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
//        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("menus", null);
        data.put("icon", umsAdmin.getIcon());
        return ResponseMsg.success(data);
    }

}

