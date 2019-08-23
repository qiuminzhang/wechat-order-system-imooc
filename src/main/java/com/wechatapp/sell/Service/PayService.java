package com.wechatapp.sell.Service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.wechatapp.sell.DTO.OrderDTO;

/** Payment Service*/

public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO );
}
