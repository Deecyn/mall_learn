package deecyn.mall_learn_15.service;

import deecyn.mall_learn_15.component.CancelOrderSender;
import deecyn.mall_learn_15.dto.OrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 前台订单管理Service
 */
@Service
public class OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderService.class);

    private final CancelOrderSender cancelOrderSender;

    @Autowired
    public OmsPortalOrderService(CancelOrderSender cancelOrderSender) {
        this.cancelOrderSender = cancelOrderSender;
    }

    /**
     * 根据提交的信息生成订单
     */
    @Transactional
    public void generateOrder(OrderParam orderParam){
        // TODO 执行一系列下单的操作

        LOGGER.info("process generatorOrder");

        // 下单完成后开启一个延迟消息，用于用户没有付款时取消订单（orderId）应该在下单之后生成
        sendDelayMessageCancelOrder(12);
    }

    /**
     * 取消单个超时订单
     */
    @Transactional
    public void cancelOrder(Integer orderId) {
        // TODO 执行一系列取消订单的操作

        LOGGER.info("process cancelOrder orderId:{}", orderId);
    }


    private void sendDelayMessageCancelOrder(Integer orderId) {
        // 获取订单超时时间，这里先假设为 60 分钟
        long delayTimes = 3 * 1000;
        // 发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

}
