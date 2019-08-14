package com.wechatapp.sell.Service;

import com.wechatapp.sell.DTO.OrderDTO;
import com.wechatapp.sell.DataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /** Create Order*/
    OrderDTO create(OrderDTO orderDTO);

    /** Find single order and its detail*/
    OrderDTO findOne(String orderId);

    /** Find a list of orders*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** Cancel a order*/
    OrderDTO cancel(OrderDTO orderDTO);

    /** Finish order*/
    OrderDTO finish(OrderDTO orderDTO);

    /** Pay for a order*/
    OrderDTO paid(OrderDTO orderDTO);
}
