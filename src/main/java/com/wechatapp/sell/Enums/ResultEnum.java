package com.wechatapp.sell.Enums;

import lombok.Getter;

/** Used in SellException */

@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "Wrong Parameters"),
    PRODUCT_NOT_EXIST(10, "Product Not Exist"),
    PRODUCT_STOCK_ERROR(11, "Wrong Stock"),
    ORDER_NOT_EXIST(12, "Order Not Exist"),
    ORDERDETAIL_NOT_EXIST(13, "Order Details Not Exist"),
    ORDER_STATUS_ERROR(14, "Wrong Order Status"),
    ORDER_UPDATE_FAIL(15, "Fail to Update"),
    ORDER_DETAIL_EMPTY(16, "Order Detail is Empty"),
    ORDER_PAY_STATUS_ERROR(17, "Wrong Pay Status"),
    CART_EMPTY(18, "Cart is empty"),
    ORDER_OWNER_ERROR(19, "This order doesn't belong to this openid"),
    WECHAT_MP_ERROR(20, "WeChat MP account error"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "WXPay nofity money verity error");
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
