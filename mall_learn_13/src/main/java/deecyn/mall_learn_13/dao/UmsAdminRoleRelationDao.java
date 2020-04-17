package deecyn.mall_learn_13.dao;

import deecyn.mall_learn_13.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限（包括角色权限和额外增删的权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Integer adminId);
}
