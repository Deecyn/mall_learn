package deecyn.mall_learn_15.common.api;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class ResponseMsg<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseMsg() {
    }

    public ResponseMsg(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作成功时的响应结果
     * @param data 返回的数据
     * @param <T> 返回数据的类型
     * @return ResponseMsg<T>
     */
    public static <T> ResponseMsg<T> success(T data) {
        return new ResponseMsg<T>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription(), data);
    }

    /**
     * 操作成功时的响应结果
     * @param message 返回的提示消息
     * @param data 返回的数据
     * @param <T> 返回数据的类型
     * @return ResponseMsg<T>
     */
    public static <T> ResponseMsg<T> success(String message, T data) {
        return new ResponseMsg<>(ResponseCodeEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败时的响应结果，数据 data 默认为空
     * @param message 返回的提示消息
     * @return ResponseMsg<T>
     */
    public static <T> ResponseMsg<T> failed(String message) {
        return new ResponseMsg<>(ResponseCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 多种情况下，操作失败时的响应结果
     * @param code 返回的响应码
     * @param message 返回的提示消息
     * @param data 返回的数据
     * @return ResponseMsg<T>
     */
    public static <T> ResponseMsg<T> failed(Integer code, String message, T data) {
        return new ResponseMsg<>(ResponseCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 参数校验失败时的响应结果，数据 data 默认为空
     * @param message 返回的提示消息
     * @return ResponseMsg<T>
     */
    public static <T> ResponseMsg<T> validateFailed(String message) {
        return new ResponseMsg<T>(ResponseCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 没有访问权限时的响应结果
     * @param data 未授权的提示信息
     * @param <T> data 的数据类型
     * @return
     */
    public static <T> ResponseMsg<T> forbidden(T data) {
        return new ResponseMsg<>(ResponseCodeEnum.FORBIDDEN.getCode(), ResponseCodeEnum.FORBIDDEN.getDescription(), data);
    }

    /**
     * 未授权（未登录等）时的返回结果
     * @param data 未授权的提示信息
     * @param <T> data 的数据类型
     * @return
     */
    public static <T> ResponseMsg<T> unauthorized(T data) {
        return new ResponseMsg<>(ResponseCodeEnum.UNAUTHORIZED.getCode(), ResponseCodeEnum.UNAUTHORIZED.getDescription(), data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
