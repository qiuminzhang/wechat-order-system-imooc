package com.wechatapp.sell.Service.Implementation;

import com.lly835.bestpay.model.PayRequest;
import com.wechatapp.sell.DTO.OrderDTO;
import com.wechatapp.sell.Service.OrderService;
import com.wechatapp.sell.Service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    private final static String ORDER_ID = "1566029318245662841";

    @Test
    public void create() {
//        OrderDTO orderDTO = new OrderDTO();
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        payService.create(orderDTO);
    }

    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.findOne("1566029318245662841");
        payService.refund(orderDTO);
    }
}
