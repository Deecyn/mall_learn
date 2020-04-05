package deecyn.mall_learn_02.common.api;

/**
 * @author Deecyn
 * @version 1.0
 * Description: api 返回的响应码
 */
public enum  ResCode {
    /** 操作成功 */
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAIL(404,"参数校验失败"),
    UNAUTHORIZED(401,"暂未登录或token校验失败"),
    FORBIDDEN(403,"没有相关权限");

    private int code;
    private String content;

    ResCode(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode(){
        return code;
    }

    public String getContent(){
        return content;
    }
}
