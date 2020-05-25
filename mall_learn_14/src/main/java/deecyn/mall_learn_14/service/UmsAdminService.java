package deecyn.mall_learn_14.service;


import deecyn.mall_learn_14.mbg.model.UmsAdmin;
import deecyn.mall_learn_14.mbg.model.UmsPermission;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 后台用户管理 Service
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return 后台管理员 UmsAdmin 对象
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return 注册成功的后台管理员 UmsAdmin 对象
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return 生成的 JWT 的 token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和额外增删的权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Integer adminId);

}

