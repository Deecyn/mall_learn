package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;

public class PmsProductAttribute implements Serializable {
    private Integer id;

    /**
     * 商品属性分类的id
     *
     * @mbg.generated 2020/06/01
     */
    private Integer productAttributeCategoryId;

    /**
     * 商品属性的名称
     *
     * @mbg.generated 2020/06/01
     */
    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选。
     *
     * @mbg.generated 2020/06/01
     */
    private Integer selectType;

    /**
     * 属性录入方式：0->手动录入；1->从列表中选取
     *
     * @mbg.generated 2020/06/01
     */
    private Integer inputType;

    /**
     * 排序；最高的可以单独上传图片
     *
     * @mbg.generated 2020/06/01
     */
    private Integer sort;

    /**
     * 分类筛选样式：0->普通；1->颜色
     *
     * @mbg.generated 2020/06/01
     */
    private Integer filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     *
     * @mbg.generated 2020/06/01
     */
    private Integer searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     *
     * @mbg.generated 2020/06/01
     */
    private Integer relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     *
     * @mbg.generated 2020/06/01
     */
    private Integer handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数。规格用于用户购买商品时选择，参数用于标示商品属性及搜索时筛选。
     *
     * @mbg.generated 2020/06/01
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Integer productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
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
        sb.append(", productAttributeCategoryId=").append(productAttributeCategoryId);
        sb.append(", name=").append(name);
        sb.append(", selectType=").append(selectType);
        sb.append(", inputType=").append(inputType);
        sb.append(", sort=").append(sort);
        sb.append(", filterType=").append(filterType);
        sb.append(", searchType=").append(searchType);
        sb.append(", relatedStatus=").append(relatedStatus);
        sb.append(", handAddStatus=").append(handAddStatus);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}