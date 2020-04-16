package deecyn.mall_learn_13.common.api;

/**
 * @author Deecyn
 * @version 1.0
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
     * 参数校验失败时的响应结果，数据 data 默认为空
     * @param message 返回的提示消息
     * @return ResponseMsg<T>
     */
    public static <T> ResponseMsg<T> validateFailed(String message) {
        return new ResponseMsg<T>(ResponseCodeEnum.VALIDATE_FAILED.getCode(), message, null);
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
