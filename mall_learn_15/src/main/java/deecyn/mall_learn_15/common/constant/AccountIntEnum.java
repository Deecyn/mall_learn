package deecyn.mall_learn_15.common.constant;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public enum AccountIntEnum {
    /**  账号为启用状态，有效的 */
    STATUS_ENABLE(1),
    /** 账号为禁用状态 */
    STATUS_DISABLE(0),

    /** 权限类型：目录  */
    PERMISSION_TYPE_DIRECTORY(0),
    /** 权限类型：菜单  */
    PERMISSION_TYPE_MENU(1),
    /** 权限类型：按钮  */
    PERMISSION_TYPE_BUTTON(2)
    ;

    private Integer value;

    AccountIntEnum(Integer value) {
        this.value = value;
    }

    public Integer value(){
        return value;
    }

    public Integer getValue() {
        return value;
    }
}
