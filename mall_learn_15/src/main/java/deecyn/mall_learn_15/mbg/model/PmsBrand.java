package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;

public class PmsBrand implements Serializable {
    /**
     * 商品品牌id
     *
     * @mbg.generated 2020/07/22
     */
    private Integer id;

    /**
     * 商品品牌名称
     *
     * @mbg.generated 2020/07/22
     */
    private String name;

    /**
     * 品牌首字母
     *
     * @mbg.generated 2020/07/22
     */
    private String firstLetter;

    /**
     * 排序
     *
     * @mbg.generated 2020/07/22
     */
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     *
     * @mbg.generated 2020/07/22
     */
    private Integer factoryStatus;

    /**
     * 显示状态
     *
     * @mbg.generated 2020/07/22
     */
    private Integer showStatus;

    /**
     * 产品计数
     *
     * @mbg.generated 2020/07/22
     */
    private Integer productCount;

    /**
     * 产品评论数量
     *
     * @mbg.generated 2020/07/22
     */
    private String productCommentCount;

    /**
     * 品牌logo图片
     *
     * @mbg.generated 2020/07/22
     */
    private String logo;

    /**
     * 品牌大图
     *
     * @mbg.generated 2020/07/22
     */
    private String bigPic;

    /**
     * 品牌故事
     *
     * @mbg.generated 2020/07/22
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
        this.name = name == null ? null : name.trim();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
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
        this.productCommentCount = productCommentCount == null ? null : productCommentCount.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory == null ? null : brandStory.trim();
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
        sb.append("]");
        return sb.toString();
    }
}