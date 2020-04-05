package deecyn.mall_learn_01.common;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/4 20:12.
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
     * 成功时返回的结果
     * @param data 返回的数据
     * @return
     */
    public static <T> ResponseMsg<T> success(T data){
        return new ResponseMsg<T>(ResCode.SUCCESS.getCode(),ResCode.SUCCESS.getContent(),data);
    }

    /**
     * 成功时返回的结果
     * @param data 返回的数据
     * @param message 提示消息
     * @return
     */
    public static <T> ResponseMsg<T> success(T data,String message){
        return new ResponseMsg<T>(ResCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 失败返回结果，数据 data 默认为空
     * @param message 提示消息
     * @return
     */
    public static <T> ResponseMsg<T> failed(String message){
        return new ResponseMsg<T>(ResCode.FAILED.getCode(),message,null);
    }

    /**
     * 参数校验失败返回结果，数据 data 默认为空
     * @param message 提示消息
     * @return
     */
    public static <T> ResponseMsg<T> validateFail(String message){
        return new ResponseMsg<T>(ResCode.VALIDATE_FAIL.getCode(),message,null);
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
