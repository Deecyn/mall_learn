package deecyn.mall_learn_13.mbg.model;

import java.io.Serializable;

public class UmsAdminPermissionRelation implements Serializable {
    /**
     * 表id
     *
     * @mbg.generated 2020/04/13
     */
    private Integer id;

    private Integer adminId;

    private Integer permissionId;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adminId=").append(adminId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}