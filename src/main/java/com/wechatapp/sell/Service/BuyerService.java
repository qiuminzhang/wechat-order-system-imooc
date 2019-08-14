package com.wechatapp.sell.Service;

import com.wechatapp.sell.DTO.OrderDTO;

/** Buyer
 * */
public interface BuyerService {
    // Find an order
    OrderDTO findOrderOne(String openid, String orderId);

    // Cancel an
    OrderDTO cancelOrderOne(String openid, String orderId);
}
