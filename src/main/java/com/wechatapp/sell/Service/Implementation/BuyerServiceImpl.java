package com.wechatapp.sell.Service.Implementation;

import com.wechatapp.sell.DTO.OrderDTO;
import com.wechatapp.sell.Enums.ResultEnum;
import com.wechatapp.sell.Exception.SellException;
import com.wechatapp.sell.Service.BuyerService;
import com.wechatapp.sell.Service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO == null){
            log.error("【取消订单】Can't find this order, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    public OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        // check if the openid matches the order's openid
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】openids doesn't match. openid={}, orderDTO={}", openid, orderDTO );
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
