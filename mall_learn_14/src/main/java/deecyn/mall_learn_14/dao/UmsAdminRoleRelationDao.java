package deecyn.mall_learn_14.dao;

import deecyn.mall_learn_14.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.14
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
