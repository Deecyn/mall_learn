package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PmsProductVerifyRecord implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productId;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/07/22
     */
    private LocalDateTime createTime;

    /**
     * 审核人
     *
     * @mbg.generated 2020/07/22
     */
    private String verifyMan;

    /**
     * 审核后的状态，0->未通过，1->已通过
     *
     * @mbg.generated 2020/07/22
     */
    private Integer status;

    /**
     * 反馈详情
     *
     * @mbg.generated 2020/07/22
     */
    private String detail;

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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getVerifyMan() {
        return verifyMan;
    }

    public void setVerifyMan(String verifyMan) {
        this.verifyMan = verifyMan == null ? null : verifyMan.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", createTime=").append(createTime);
        sb.append(", verifyMan=").append(verifyMan);
        sb.append(", status=").append(status);
        sb.append(", detail=").append(detail);
        sb.append("]");
        return sb.toString();
    }
}