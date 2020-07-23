package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PmsProductLadder implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productId;

    /**
     * 满足条件的商品数量
     *
     * @mbg.generated 2020/07/22
     */
    private Integer count;

    /**
     * 折扣
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal discount;

    /**
     * 打折后的价格
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal price;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", count=").append(count);
        sb.append(", discount=").append(discount);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}