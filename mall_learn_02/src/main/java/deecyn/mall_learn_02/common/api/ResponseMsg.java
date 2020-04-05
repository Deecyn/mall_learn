package deecyn.mall_learn_02.common.api;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class ResponseMsg<T> {
    private int code;
    private String message;
    private T data;

    public ResponseMsg() {
    }

    public ResponseMsg(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作成功时的响应结果
     * @param data 返回的数据
     * @param <T> 返回数据的类型
     * @return
     */
    public static <T> ResponseMsg<T> success(T data) {
        return new ResponseMsg<>(ResCode.SUCCESS.getCode(),ResCode.SUCCESS.getContent(),data);
    }

    /**
     * 操作成功时的响应结果
     * @param message 返回的提示消息
     * @param data 返回的数据
     * @param <T> 返回数据的类型
     * @return
     */
    public static <T> ResponseMsg<T> success(String message, T data) {
        return new ResponseMsg<>(ResCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败时的响应结果，数据 data 默认为空
     * @param message 返回的提示消息
     * @param <T> 返回数据 data 的类型
     * @return
     */
    public static <T> ResponseMsg<T> failed(String message) {
        return new ResponseMsg<>(ResCode.FAILED.getCode(), message, null);
    }

    /**
     * 参数校验失败时返回的结果，数据 data 默认为空
     * @param message 返回的提示消息
     * @param <T> 返回数据 data 的类型
     * @return
     */
    public static <T> ResponseMsg<T> validateFail(String message) {
        return new ResponseMsg<>(ResCode.VALIDATE_FAIL.getCode(), message, null);
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
