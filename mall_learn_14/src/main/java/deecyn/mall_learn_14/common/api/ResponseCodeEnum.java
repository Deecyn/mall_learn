package deecyn.mall_learn_14.common.api;

/**
 * @author Deecyn
 * @version 0.14
 * Description: API 响应码
 */
public enum ResponseCodeEnum {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UNAUTHORIZED(401, "暂未登录或 token 已过期"),
    FORBIDDEN(403, "没有相关权限");

    private int code;
    private String description;

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
