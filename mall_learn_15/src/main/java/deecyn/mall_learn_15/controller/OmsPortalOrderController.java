package deecyn.mall_learn_15.controller;

import deecyn.mall_learn_15.common.api.ResponseMsg;
import deecyn.mall_learn_15.dto.OrderParam;
import deecyn.mall_learn_15.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RestController
@RequestMapping("/order")
public class OmsPortalOrderController {

    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    public ResponseMsg<Object> generateOrder(@RequestBody OrderParam orderParam) {

        omsPortalOrderService.generateOrder(orderParam);
        return ResponseMsg.success("下单成功", null);
    }
}
