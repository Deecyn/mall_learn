package deecyn.mall_learn_14.common.constant;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public enum RegexRuleEnum {

    /** 手机号正则校验表达式，规则较宽松的 */
    TELEPHONE_REGEX("^(1[0-9])\\d{9}$");

    private String regexValue;

    RegexRuleEnum(String regexValue) {
        this.regexValue = regexValue;
    }

    public String getRegexValue() {
        return regexValue;
    }

    public String value() {
        return regexValue;
    }
}
