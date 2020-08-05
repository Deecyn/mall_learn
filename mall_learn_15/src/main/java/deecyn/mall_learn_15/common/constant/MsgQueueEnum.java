package deecyn.mall_learn_15.common.constant;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 消息队列枚举配置
 */
public enum MsgQueueEnum {

    /** 消息通知队列  */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),

    /** 消息通知 ttl 队列  */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl",
            "mall.order.cancel.ttl");

    /** 交换名称 */
    private String exchange;

    /** 队列名称  */
    private String name;

    /** 路由键  */
    private String routeKey;

    MsgQueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getName() {
        return name;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
