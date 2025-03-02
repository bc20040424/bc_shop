package com.ybc.entity.enums;

public enum VerifyEnum {
    NO("", "不校验"),
    EMAIL("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", "邮箱"),
    PASSWORD("^(?=.*\\d)(?=.*[a-zA-Z])[\\da-zA-Z~!@#$%^&*_]{8,}$", "只能是数字、字母、特殊字符，长度8-18位");
    //IP("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", "IP地址"),
    //POSITIVE_INTEGER("^[0-9]*[1-9][0-9]*$", "正整数"),
    //NUMBER_LETTER_UNDER_LINE("^\\w+$", "由数字、26个英文字母或者下划线组成的字符串"),
    //PHONE("(1[0-9])\\d{9}$", "手机号码"),
    //COMMON("^[a-zA-Z0-9_\\u4e00-\\u9fa5]+$", "数字、字母、中文、下划线"),
    //ACCOUNT("^[0-9a-zA-Z_]{1,}$", "字母开头，由数字、英文字母或者下划线组成"),
    //MONEY("^[0-9]+(.[0-9]{1,2})?$", "金额");

    private String regex; // 存储正则表达式的字符串
    private String desc; // 存储正则表达式的描述信息(注释)

    VerifyEnum(String regex, String desc) {
        this.regex = regex;
        this.desc = desc;
    }

    public String getRegex() {
        return regex;
    }

    public String getDesc() {
        return desc;
    }

}

