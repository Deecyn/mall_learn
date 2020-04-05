package deecyn.mall_learn_02.mbg.model;

import java.io.Serializable;

public class PmsBrand implements Serializable {
    /**
     * 商品品牌id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 商品品牌名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 品牌首字母
     *
     * @mbg.generated
     */
    private String firstLetter;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 品牌制造商
     *
     * @mbg.generated
     */
    private Integer factoryStatus;

    /**
     * 显示状态
     *
     * @mbg.generated
     */
    private Integer showStatus;

    /**
     * 产品计数
     *
     * @mbg.generated
     */
    private Integer productCount;

    /**
     * 产品评论数量
     *
     * @mbg.generated
     */
    private String productCommentCount;

    /**
     * 品牌logo图片
     *
     * @mbg.generated
     */
    private String logo;

    /**
     * 品牌大图
     *
     * @mbg.generated
     */
    private String bigPic;

    /**
     * 品牌故事
     *
     * @mbg.generated
     */
    private String brandStory;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(String productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", firstLetter=").append(firstLetter);
        sb.append(", sort=").append(sort);
        sb.append(", factoryStatus=").append(factoryStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", productCount=").append(productCount);
        sb.append(", productCommentCount=").append(productCommentCount);
        sb.append(", logo=").append(logo);
        sb.append(", bigPic=").append(bigPic);
        sb.append(", brandStory=").append(brandStory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}