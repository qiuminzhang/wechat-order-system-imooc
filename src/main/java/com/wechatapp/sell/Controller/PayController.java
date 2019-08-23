package com.wechatapp.sell.Controller;


import com.lly835.bestpay.model.PayResponse;
import com.wechatapp.sell.DTO.OrderDTO;
import com.wechatapp.sell.Enums.ResultEnum;
import com.wechatapp.sell.Exception.SellException;
import com.wechatapp.sell.Service.OrderService;
import com.wechatapp.sell.Service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller // Return a web page instead of JSON
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService  payService;

    @GetMapping(value = "/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        // 1. Search an order
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2. Start payment request (logic is in service)
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);  // The invoke result is a blank page, but you can inspect the webpage source code for result.
    }

    @PostMapping(value = "/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);

        // 返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
