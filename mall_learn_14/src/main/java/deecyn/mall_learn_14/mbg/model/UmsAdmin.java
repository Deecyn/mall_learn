package deecyn.mall_learn_14.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UmsAdmin implements Serializable {
    /**
     * 后台用户，id
     *
     * @mbg.generated 2020/05/25
     */
    private Integer id;

    /**
     * 用户名
     *
     * @mbg.generated 2020/05/25
     */
    private String username;

    /**
     * 密码
     *
     * @mbg.generated 2020/05/25
     */
    private String password;

    /**
     * 头像
     *
     * @mbg.generated 2020/05/25
     */
    private String icon;

    /**
     * 邮箱
     *
     * @mbg.generated 2020/05/25
     */
    private String email;

    /**
     * 昵称
     *
     * @mbg.generated 2020/05/25
     */
    private String nickName;

    /**
     * 备注信息
     *
     * @mbg.generated 2020/05/25
     */
    private String note;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/05/25
     */
    private LocalDateTime createTime;

    /**
     * 最后登录时间
     *
     * @mbg.generated 2020/05/25
     */
    private LocalDateTime loginTime;

    /**
     * 账号启用状态，0->禁用；1->启用
     *
     * @mbg.generated 2020/05/25
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", icon=").append(icon);
        sb.append(", email=").append(email);
        sb.append(", nickName=").append(nickName);
        sb.append(", note=").append(note);
        sb.append(", createTime=").append(createTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}