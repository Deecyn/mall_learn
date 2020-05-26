package deecyn.mall_learn_14.common.exception;

import deecyn.mall_learn_14.common.api.ResponseMsg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseMsg<Object> handle(ApiException e) {
        if (e.getResponseCode() != null) {
            return ResponseMsg.failed(e.getResponseCode().getCode(),
                    e.getResponseCode().getDescription(), null);
        }
        return ResponseMsg.failed(e.getMessage());
    }
}
