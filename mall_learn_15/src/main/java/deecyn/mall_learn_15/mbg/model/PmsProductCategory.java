package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;

public class PmsProductCategory implements Serializable {
    private Integer id;

    /**
     * 上级分类的编号，0表示一级分类
     *
     * @mbg.generated 2020/07/22
     */
    private Integer parentId;

    /**
     * 商品分类的名称
     *
     * @mbg.generated 2020/07/22
     */
    private String name;

    /**
     * 分类的级别：0->1级；1->2级。
     *
     * @mbg.generated 2020/07/22
     */
    private Integer level;

    /**
     * 商品数量
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productCount;

    /**
     * 商品的数量单位
     *
     * @mbg.generated 2020/07/22
     */
    private String productUnit;

    /**
     * 是否在客户端的导航栏显示：0->不显示；1->显示。
     *
     * @mbg.generated 2020/07/22
     */
    private Integer navStatus;

    /**
     * 是否在客户端显示：0->不显示；1->显示。
     *
     * @mbg.generated 2020/07/22
     */
    private Integer showStatus;

    /**
     * 排序
     *
     * @mbg.generated 2020/07/22
     */
    private Integer sort;

    /**
     * 图标
     *
     * @mbg.generated 2020/07/22
     */
    private String icon;

    /**
     * 关键字
     *
     * @mbg.generated 2020/07/22
     */
    private String keywords;

    /**
     * 描述
     *
     * @mbg.generated 2020/07/22
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", productCount=").append(productCount);
        sb.append(", productUnit=").append(productUnit);
        sb.append(", navStatus=").append(navStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", sort=").append(sort);
        sb.append(", icon=").append(icon);
        sb.append(", keywords=").append(keywords);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}