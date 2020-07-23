package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;

public class PmsProductCategoryAttributeRelation implements Serializable {
    private Integer id;

    /**
     * 商品分类id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productCategoryId;

    /**
     * 商品属性id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productAttributeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Integer productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", productAttributeId=").append(productAttributeId);
        sb.append("]");
        return sb.toString();
    }
}