package deecyn.mall_learn_15.component;

import deecyn.mall_learn_15.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 取消订单消息的接收者
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {

    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);

    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @RabbitHandler
    public void handel(Integer orderId) {
        LOGGER.info("receive delay message orderId:{}", orderId);
        omsPortalOrderService.cancelOrder(orderId);
    }


}
