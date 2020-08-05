package deecyn.mall_learn_15.config;

import deecyn.mall_learn_15.common.constant.MsgQueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 消息队列配置
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 「订单消息实际消费队列」所绑定的交换机
     */
    @Bean
    DirectExchange orderDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(MsgQueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单延迟队列所绑定的交换机
     */
    @Bean
    DirectExchange orderTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(MsgQueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单实际消费队列
     */
    public Queue orderQueue() {
        return new Queue(MsgQueueEnum.QUEUE_ORDER_CANCEL.getName());
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue orderTtlQueue() {
        return QueueBuilder.durable(MsgQueueEnum.QUEUE_TTL_ORDER_CANCEL.getName())
                // 到期后转发的交换机
                .withArgument("x-dead-letter-exchange", MsgQueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                // 到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", MsgQueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())
                .build();
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding orderBinding(DirectExchange orderDirect, Queue orderQueue) {
        return BindingBuilder.bind(orderQueue).to(orderDirect)
                .with(MsgQueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlDirect, Queue orderTtlQueue) {
        return BindingBuilder.bind(orderTtlQueue).to(orderTtlDirect)
                .with(MsgQueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }


}
