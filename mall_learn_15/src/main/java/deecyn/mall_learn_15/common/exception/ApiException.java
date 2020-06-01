package deecyn.mall_learn_15.common.exception;

import deecyn.mall_learn_15.common.api.ResponseCodeEnum;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 自定义 API 异常
 */
public class ApiException extends RuntimeException {
    private ResponseCodeEnum responseCode;

    public ApiException(ResponseCodeEnum responseCode) {
        super(responseCode.getDescription());
        this.responseCode = responseCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ResponseCodeEnum getResponseCode() {
        return responseCode;
    }
}
