package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PmsCommentReplay implements Serializable {
    private Integer id;

    /**
     * 评论id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer commentId;

    /**
     * 会员昵称
     *
     * @mbg.generated 2020/07/22
     */
    private String memberNickName;

    /**
     * 会员头像
     *
     * @mbg.generated 2020/07/22
     */
    private String memberIcon;

    /**
     * 内容
     *
     * @mbg.generated 2020/07/22
     */
    private String content;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/07/22
     */
    private LocalDateTime createTime;

    /**
     * 评论人员类型，0->会员；1->管理员
     *
     * @mbg.generated 2020/07/22
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName == null ? null : memberNickName.trim();
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon == null ? null : memberIcon.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
        sb.append(", commentId=").append(commentId);
        sb.append(", memberNickName=").append(memberNickName);
        sb.append(", memberIcon=").append(memberIcon);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}