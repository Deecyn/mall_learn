package deecyn.mall_learn_14.common.exception;

import deecyn.mall_learn_14.common.api.ResponseCodeEnum;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 断言处理类，用于抛出各种 API 异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(ResponseCodeEnum responseCodeEnum) {
        throw new ApiException(responseCodeEnum);
    }
}
