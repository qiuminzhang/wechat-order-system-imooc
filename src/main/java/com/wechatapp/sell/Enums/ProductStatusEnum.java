package com.wechatapp.sell.Enums;


import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "InStock"),
    DOWN(1, "SoldOut")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
