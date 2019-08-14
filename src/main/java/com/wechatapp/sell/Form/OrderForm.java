package com.wechatapp.sell.Form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/** Classes under Form directory are used to do form validation*/

/** Attributes are filed name of arguments*/

@Data
public class OrderForm {

    /** Customer name*/
    @NotEmpty(message = "Name is required")
    private String name;

    /** Customer phone number*/
    @NotEmpty(message = "Phone is required")
    private String phone;

    /** Customer address*/
    @NotEmpty(message = "Address is required")
    private String address;

    /**Customer Openid*/
    @NotEmpty(message = "Openid is required")
    private String openid;

    /** Cart */
    @NotEmpty(message = "Cart can't be empty")
    private String items;
}
