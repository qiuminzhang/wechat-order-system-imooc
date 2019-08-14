package com.wechatapp.sell.Enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "New Order"),
    FINISH(1, "Finished"),
    CANCEL(2, "Canceled"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
