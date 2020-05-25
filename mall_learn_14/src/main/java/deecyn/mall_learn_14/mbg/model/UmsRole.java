package deecyn.mall_learn_14.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UmsRole implements Serializable {
    /**
     * 后台用户角色id
     *
     * @mbg.generated 2020/05/25
     */
    private Integer id;

    /**
     * 名称
     *
     * @mbg.generated 2020/05/25
     */
    private String name;

    /**
     * 描述
     *
     * @mbg.generated 2020/05/25
     */
    private String description;

    /**
     * 后台用户数量
     *
     * @mbg.generated 2020/05/25
     */
    private Integer adminCount;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/05/25
     */
    private LocalDateTime createTime;

    /**
     * 启用状态，0->禁用；1->启用
     *
     * @mbg.generated 2020/05/25
     */
    private Integer status;

    /**
     * 排序
     *
     * @mbg.generated 2020/05/25
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", adminCount=").append(adminCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }
}