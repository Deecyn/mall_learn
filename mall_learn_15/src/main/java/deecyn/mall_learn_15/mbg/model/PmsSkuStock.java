package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PmsSkuStock implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productId;

    /**
     * sku编码
     *
     * @mbg.generated 2020/07/22
     */
    private String skuCode;

    /**
     * 价格
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal price;

    /**
     * 库存量
     *
     * @mbg.generated 2020/07/22
     */
    private Integer stock;

    /**
     * 预警库存量
     *
     * @mbg.generated 2020/07/22
     */
    private Integer lowStock;

    /**
     * 规格属性1
     *
     * @mbg.generated 2020/07/22
     */
    private String sp1;

    /**
     * 规格属性 2
     *
     * @mbg.generated 2020/07/22
     */
    private String sp2;

    /**
     * 规格属性 3
     *
     * @mbg.generated 2020/07/22
     */
    private String sp3;

    /**
     * 展示的图片
     *
     * @mbg.generated 2020/07/22
     */
    private String pic;

    /**
     * 销量
     *
     * @mbg.generated 2020/07/22
     */
    private Integer sale;

    /**
     * 单品促销价格
     *
     * @mbg.generated 2020/07/22
     */
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     *
     * @mbg.generated 2020/07/22
     */
    private Integer lockStock;

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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1 == null ? null : sp1.trim();
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2 == null ? null : sp2.trim();
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3 == null ? null : sp3.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", lowStock=").append(lowStock);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", pic=").append(pic);
        sb.append(", sale=").append(sale);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", lockStock=").append(lockStock);
        sb.append("]");
        return sb.toString();
    }
}