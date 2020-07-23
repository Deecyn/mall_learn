package deecyn.mall_learn_15.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 订单超时取消并解锁库存的定时器
 */
@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron 表达式：Seconds Minutes Hours DayOfMonth Month DayOfWeek [Year]
     * 每 10 分钟扫描一次，扫描设定超时时间之前用户下的订单，如果没支付则取消订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        // TODO 此处应调用取消订单的方法
        LOGGER.info("取消订单，并根据 sku 编号释放锁定库存");
    }
}
