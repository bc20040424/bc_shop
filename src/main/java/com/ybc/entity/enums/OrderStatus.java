package com.ybc.entity.enums;

public enum OrderStatus {
    UNPAID(0, "未支付"),
    PAID(1, "已支付"),
    CANCELLED(2, "已取消"),
    CLOSED(3, "已关闭"),
    COMPLETED(4, "已完成");

    private final int code;
    private final String description;

    OrderStatus(int code, String description) {
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