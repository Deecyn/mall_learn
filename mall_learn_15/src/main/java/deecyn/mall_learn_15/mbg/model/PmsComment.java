package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PmsComment implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productId;

    /**
     * 会员昵称
     *
     * @mbg.generated 2020/07/22
     */
    private String memberNickName;

    /**
     * 商品名称
     *
     * @mbg.generated 2020/07/22
     */
    private String productName;

    /**
     * 评价星数，0->5
     *
     * @mbg.generated 2020/07/22
     */
    private Integer star;

    /**
     * 评价的ip
     *
     * @mbg.generated 2020/07/22
     */
    private String memberIp;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/07/22
     */
    private LocalDateTime createTime;

    /**
     * 是否显示
     *
     * @mbg.generated 2020/07/22
     */
    private Integer showStatus;

    /**
     * 购买时的商品属性
     *
     * @mbg.generated 2020/07/22
     */
    private String productAttribute;

    /**
     * 收藏数量
     *
     * @mbg.generated 2020/07/22
     */
    private Integer collectCount;

    /**
     * 阅读数
     *
     * @mbg.generated 2020/07/22
     */
    private Integer readCount;

    /**
     * 上传图片的地址，以逗号隔开
     *
     * @mbg.generated 2020/07/22
     */
    private String pics;

    /**
     * 评论用户头像
     *
     * @mbg.generated 2020/07/22
     */
    private String memberIcon;

    /**
     * 回复数
     *
     * @mbg.generated 2020/07/22
     */
    private Integer replayCount;

    /**
     * 内容
     *
     * @mbg.generated 2020/07/22
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName == null ? null : memberNickName.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getMemberIp() {
        return memberIp;
    }

    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp == null ? null : memberIp.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(String productAttribute) {
        this.productAttribute = productAttribute == null ? null : productAttribute.trim();
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon == null ? null : memberIcon.trim();
    }

    public Integer getReplayCount() {
        return replayCount;
    }

    public void setReplayCount(Integer replayCount) {
        this.replayCount = replayCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", memberNickName=").append(memberNickName);
        sb.append(", productName=").append(productName);
        sb.append(", star=").append(star);
        sb.append(", memberIp=").append(memberIp);
        sb.append(", createTime=").append(createTime);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", productAttribute=").append(productAttribute);
        sb.append(", collectCount=").append(collectCount);
        sb.append(", readCount=").append(readCount);
        sb.append(", pics=").append(pics);
        sb.append(", memberIcon=").append(memberIcon);
        sb.append(", replayCount=").append(replayCount);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}