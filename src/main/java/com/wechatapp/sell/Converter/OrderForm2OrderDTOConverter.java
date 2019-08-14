package com.wechatapp.sell.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wechatapp.sell.DTO.OrderDTO;
import com.wechatapp.sell.DataObject.OrderDetail;
import com.wechatapp.sell.Enums.ResultEnum;
import com.wechatapp.sell.Exception.SellException;
import com.wechatapp.sell.Form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());


        // Items in orderForm is a json String as API.
        // We need to convert the json string to a required list, so we use gson dependency here
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }
                            .getType()); // json -> list
        } catch (Exception e) {
            log.error("【对象转换】JSON -> list gets WRONG. item string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
