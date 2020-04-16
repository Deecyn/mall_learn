package deecyn.mall_learn_13.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UmsPermission implements Serializable {
    private Integer id;

    /**
     * 父级权限id
     *
     * @mbg.generated 2020/04/13
     */
    private Integer pid;

    /**
     * 名称
     *
     * @mbg.generated 2020/04/13
     */
    private String name;

    /**
     * 权限值
     *
     * @mbg.generated 2020/04/13
     */
    private String value;

    /**
     * 图标
     *
     * @mbg.generated 2020/04/13
     */
    private String icon;

    /**
     * 权限类型：0->目录，1->菜单，2->按钮（接口绑定权限）
     *
     * @mbg.generated 2020/04/13
     */
    private Integer type;

    /**
     * 前端资源路径
     *
     * @mbg.generated 2020/04/13
     */
    private String uri;

    /**
     * 启用状态：0->禁用，1->启用
     *
     * @mbg.generated 2020/04/13
     */
    private Integer status;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/04/13
     */
    private LocalDateTime createTime;

    /**
     * 排序
     *
     * @mbg.generated 2020/04/13
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", uri=").append(uri);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }
}