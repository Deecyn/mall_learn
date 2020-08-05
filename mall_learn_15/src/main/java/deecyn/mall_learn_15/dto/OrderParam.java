package deecyn.mall_learn_15.dto;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 生成订单时传入的参数
 */
public class OrderParam {

    // 收货地址 id
    private Integer memberReceiveAddressId;

    // 优惠卷
    private Integer couponId;

    // 使用的积分数
    private Integer useIntegration;

    // 支付方式
    private Integer payType;

    public Integer getMemberReceiveAddressId() {
        return memberReceiveAddressId;
    }

    public void setMemberReceiveAddressId(Integer memberReceiveAddressId) {
        this.memberReceiveAddressId = memberReceiveAddressId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
