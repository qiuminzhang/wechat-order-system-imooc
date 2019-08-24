package com.wechatapp.sell.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wechatapp.sell.DataObject.OrderDetail;
import com.wechatapp.sell.Enums.OrderStatusEnum;
import com.wechatapp.sell.Enums.PayStatusEnum;
import com.wechatapp.sell.Serializer.Date2LongSerializer;
import com.wechatapp.sell.Utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** DTO stands for data transfer object. DTO is especially used to transfer data between
 * different levels like service level, controller level and DAO level.*/

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL )
// ⬆️If any attribute is null, don't even show the attribute name in json result.
// This annotation has been configured at application.yml file
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 0 by default*/
    private Integer orderStatus;

    private Integer payStatus;

    /** Because we will order or update the orders, so we need these two times in this class.*/
    @JsonSerialize(using = Date2LongSerializer.class)   // convert date to long datatype?
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    /** Given code, return its enum.  eg: given 1 0 for this case, return NEW */
    @JsonIgnore // If this is a restAPI and an orderDTO would be return, besides the above fields, these two method would return extra two enum, so we need to ignore these two.
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getEnumValueByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getEnumValueByCode(payStatus, PayStatusEnum.class);
    }
}
