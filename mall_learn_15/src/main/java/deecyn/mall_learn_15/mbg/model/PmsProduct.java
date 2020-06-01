package deecyn.mall_learn_15.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PmsProduct implements Serializable {
    private Integer id;

    /**
     * 品牌 id
     *
     * @mbg.generated 2020/06/01
     */
    private Integer brandId;

    /**
     * 品牌名称
     *
     * @mbg.generated 2020/06/01
     */
    private String brandName;

    /**
     * 产品分类 id
     *
     * @mbg.generated 2020/06/01
     */
    private Integer productCategoryId;

    /**
     * 产品分类名称
     *
     * @mbg.generated 2020/06/01
     */
    private String productCategoryName;

    /**
     * 运费模板 id
     *
     * @mbg.generated 2020/06/01
     */
    private Integer freightTemplateId;

    /**
     * 品牌属性 id
     *
     * @mbg.generated 2020/06/01
     */
    private Integer productAttributeCategoryId;

    /**
     * 商品名称
     *
     * @mbg.generated 2020/06/01
     */
    private String name;

    /**
     * 图片
     *
     * @mbg.generated 2020/06/01
     */
    private String pic;

    /**
     * 商品货号
     *
     * @mbg.generated 2020/06/01
     */
    private String productSn;

    /**
     * 删除状态：0->未删除；1->已删除。
     *
     * @mbg.generated 2020/06/01
     */
    private Integer deleteStatus;

    /**
     * 上架状态：0->下架；1->上架。
     *
     * @mbg.generated 2020/06/01
     */
    private Integer publishStatus;

    /**
     * 新品状态：0->不是新品；1->新品。
     *
     * @mbg.generated 2020/06/01
     */
    private Integer newStatus;

    /**
     * 推荐状态：0->不推荐；1->推荐
     *
     * @mbg.generated 2020/06/01
     */
    private Integer recommendStatus;

    /**
     * 审核状态：0->未审核；1->审核通过
     *
     * @mbg.generated 2020/06/01
     */
    private Integer verifyStatus;

    /**
     * 排序
     *
     * @mbg.generated 2020/06/01
     */
    private Integer sort;

    /**
     * 销量
     *
     * @mbg.generated 2020/06/01
     */
    private Integer sale;

    /**
     * 价格
     *
     * @mbg.generated 2020/06/01
     */
    private BigDecimal price;

    /**
     * 促销价格
     *
     * @mbg.generated 2020/06/01
     */
    private BigDecimal promotionPrice;

    /**
     * 赠送的成长值
     *
     * @mbg.generated 2020/06/01
     */
    private Integer giftGrowth;

    /**
     * 赠送的积分
     *
     * @mbg.generated 2020/06/01
     */
    private Integer giftPoint;

    /**
     * 限制使用的积分数量
     *
     * @mbg.generated 2020/06/01
     */
    private Integer usePointLimit;

    /**
     * 副标题
     *
     * @mbg.generated 2020/06/01
     */
    private String subTittle;

    /**
     * 市场价
     *
     * @mbg.generated 2020/06/01
     */
    private BigDecimal originalPrice;

    /**
     * 库存
     *
     * @mbg.generated 2020/06/01
     */
    private Integer stock;

    /**
     * 库存预警值
     *
     * @mbg.generated 2020/06/01
     */
    private Integer lowStock;

    /**
     * 单位
     *
     * @mbg.generated 2020/06/01
     */
    private String unit;

    /**
     * 商品重量，默认为克
     *
     * @mbg.generated 2020/06/01
     */
    private BigDecimal weight;

    /**
     * 是否为预告商品：0->不是；1->是。
     *
     * @mbg.generated 2020/06/01
     */
    private Integer previewStatus;

    /**
     * 以逗号分隔的产品服务，1->无忧退货；2->快速退款；3->免费包邮。
     *
     * @mbg.generated 2020/06/01
     */
    private String serviceIds;

    /**
     * 关键字
     *
     * @mbg.generated 2020/06/01
     */
    private String keywords;

    /**
     * 备注
     *
     * @mbg.generated 2020/06/01
     */
    private String note;

    /**
     * 画册图片，连产品图片限制为5张，以英文逗号分隔
     *
     * @mbg.generated 2020/06/01
     */
    private String albumPics;

    /**
     * 详情标题
     *
     * @mbg.generated 2020/06/01
     */
    private String detailTittle;

    /**
     * 促销开始时间
     *
     * @mbg.generated 2020/06/01
     */
    private LocalDateTime promotionStartTime;

    /**
     * 促销结束时间
     *
     * @mbg.generated 2020/06/01
     */
    private LocalDateTime promotionEndTime;

    /**
     * 活动限购数量
     *
     * @mbg.generated 2020/06/01
     */
    private Integer promotionPerLimit;

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     *
     * @mbg.generated 2020/06/01
     */
    private Integer promotionType;

    /**
     * 商品描述
     *
     * @mbg.generated 2020/06/01
     */
    private String description;

    /**
     * 详情描述
     *
     * @mbg.generated 2020/06/01
     */
    private String detailDesc;

    /**
     * 产品详情网页内容
     *
     * @mbg.generated 2020/06/01
     */
    private String detailHtml;

    /**
     * 移动端网页详情内容
     *
     * @mbg.generated 2020/06/01
     */
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName == null ? null : productCategoryName.trim();
    }

    public Integer getFreightTemplateId() {
        return freightTemplateId;
    }

    public void setFreightTemplateId(Integer freightTemplateId) {
        this.freightTemplateId = freightTemplateId;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    public Integer getUsePointLimit() {
        return usePointLimit;
    }

    public void setUsePointLimit(Integer usePointLimit) {
        this.usePointLimit = usePointLimit;
    }

    public String getSubTittle() {
        return subTittle;
    }

    public void setSubTittle(String subTittle) {
        this.subTittle = subTittle == null ? null : subTittle.trim();
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPreviewStatus() {
        return previewStatus;
    }

    public void setPreviewStatus(Integer previewStatus) {
        this.previewStatus = previewStatus;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds == null ? null : serviceIds.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics == null ? null : albumPics.trim();
    }

    public String getDetailTittle() {
        return detailTittle;
    }

    public void setDetailTittle(String detailTittle) {
        this.detailTittle = detailTittle == null ? null : detailTittle.trim();
    }

    public LocalDateTime getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(LocalDateTime promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public LocalDateTime getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(LocalDateTime promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml == null ? null : detailHtml.trim();
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml == null ? null : detailMobileHtml.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandId=").append(brandId);
        sb.append(", brandName=").append(brandName);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", productCategoryName=").append(productCategoryName);
        sb.append(", freightTemplateId=").append(freightTemplateId);
        sb.append(", productAttributeCategoryId=").append(productAttributeCategoryId);
        sb.append(", name=").append(name);
        sb.append(", pic=").append(pic);
        sb.append(", productSn=").append(productSn);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", newStatus=").append(newStatus);
        sb.append(", recommendStatus=").append(recommendStatus);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", sort=").append(sort);
        sb.append(", sale=").append(sale);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", giftGrowth=").append(giftGrowth);
        sb.append(", giftPoint=").append(giftPoint);
        sb.append(", usePointLimit=").append(usePointLimit);
        sb.append(", subTittle=").append(subTittle);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", stock=").append(stock);
        sb.append(", lowStock=").append(lowStock);
        sb.append(", unit=").append(unit);
        sb.append(", weight=").append(weight);
        sb.append(", previewStatus=").append(previewStatus);
        sb.append(", serviceIds=").append(serviceIds);
        sb.append(", keywords=").append(keywords);
        sb.append(", note=").append(note);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", detailTittle=").append(detailTittle);
        sb.append(", promotionStartTime=").append(promotionStartTime);
        sb.append(", promotionEndTime=").append(promotionEndTime);
        sb.append(", promotionPerLimit=").append(promotionPerLimit);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", description=").append(description);
        sb.append(", detailDesc=").append(detailDesc);
        sb.append(", detailHtml=").append(detailHtml);
        sb.append(", detailMobileHtml=").append(detailMobileHtml);
        sb.append("]");
        return sb.toString();
    }
}