package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PmsProductOperateLog implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productId;

    /**
     * 改变前的价格
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal priceOld;

    /**
     * 改变后的价格
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal priceNew;

    /**
     * 改变前的优惠价
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal salePriceOld;

    /**
     * 改变后的优惠价
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal salePriceNew;

    /**
     * 改变前的积分
     *
     * @mbg.generated 2020/07/22
     */
    private Integer giftPointOld;

    /**
     * 改变后的积分
     *
     * @mbg.generated 2020/07/22
     */
    private Integer giftPointNew;

    /**
     * 改变前的积分使用限制
     *
     * @mbg.generated 2020/07/22
     */
    private Integer usePointLimitOld;

    /**
     * 改变后的积分使用限制
     *
     * @mbg.generated 2020/07/22
     */
    private Integer usePointLimitNew;

    /**
     * 操作人
     *
     * @mbg.generated 2020/07/22
     */
    private String operateMan;

    /**
     * 创建时间
     *
     * @mbg.generated 2020/07/22
     */
    private LocalDateTime createTime;

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

    public BigDecimal getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    public BigDecimal getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    public BigDecimal getSalePriceOld() {
        return salePriceOld;
    }

    public void setSalePriceOld(BigDecimal salePriceOld) {
        this.salePriceOld = salePriceOld;
    }

    public BigDecimal getSalePriceNew() {
        return salePriceNew;
    }

    public void setSalePriceNew(BigDecimal salePriceNew) {
        this.salePriceNew = salePriceNew;
    }

    public Integer getGiftPointOld() {
        return giftPointOld;
    }

    public void setGiftPointOld(Integer giftPointOld) {
        this.giftPointOld = giftPointOld;
    }

    public Integer getGiftPointNew() {
        return giftPointNew;
    }

    public void setGiftPointNew(Integer giftPointNew) {
        this.giftPointNew = giftPointNew;
    }

    public Integer getUsePointLimitOld() {
        return usePointLimitOld;
    }

    public void setUsePointLimitOld(Integer usePointLimitOld) {
        this.usePointLimitOld = usePointLimitOld;
    }

    public Integer getUsePointLimitNew() {
        return usePointLimitNew;
    }

    public void setUsePointLimitNew(Integer usePointLimitNew) {
        this.usePointLimitNew = usePointLimitNew;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan == null ? null : operateMan.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", priceOld=").append(priceOld);
        sb.append(", priceNew=").append(priceNew);
        sb.append(", salePriceOld=").append(salePriceOld);
        sb.append(", salePriceNew=").append(salePriceNew);
        sb.append(", giftPointOld=").append(giftPointOld);
        sb.append(", giftPointNew=").append(giftPointNew);
        sb.append(", usePointLimitOld=").append(usePointLimitOld);
        sb.append(", usePointLimitNew=").append(usePointLimitNew);
        sb.append(", operateMan=").append(operateMan);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}