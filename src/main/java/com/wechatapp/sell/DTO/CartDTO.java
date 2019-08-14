package com.wechatapp.sell.DTO;

import lombok.Data;

@Data
public class CartDTO {

    // product id
    private String productId;

    // product quantity
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
