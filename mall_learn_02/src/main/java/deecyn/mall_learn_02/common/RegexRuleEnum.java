package deecyn.mall_learn_02.common;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public enum RegexRuleEnum {

    /** 规则较宽松的手机号正则 */
    TELEPHONE__REGEX("^(1[0-9])\\d{9}$");

    private String regexValue;


    RegexRuleEnum(String regexValue) {
        this.regexValue = regexValue;
    }

    public String getRegexValue() {
        return regexValue;
    }

    public String value(){
        return regexValue;
    }
}
