package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PmsMemberPrice implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productId;

    /**
     * 会员等级id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer memberLevelId;

    /**
     * 会员价格
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal memberPrice;

    /**
     * 会员等级名称
     *
     * @mbg.generated 2020/07/22
     */
    private String memberLevelName;

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

    public Integer getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Integer memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getMemberLevelName() {
        return memberLevelName;
    }

    public void setMemberLevelName(String memberLevelName) {
        this.memberLevelName = memberLevelName == null ? null : memberLevelName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", memberPrice=").append(memberPrice);
        sb.append(", memberLevelName=").append(memberLevelName);
        sb.append("]");
        return sb.toString();
    }
}