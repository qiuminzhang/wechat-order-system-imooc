package com.wechatapp.sell.DTO;

import com.wechatapp.sell.DataObject.OrderDetail;
import com.wechatapp.sell.Enums.OrderStatusEnum;
import com.wechatapp.sell.Enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** DTO stands for data transfer object. DTO is especially used to transfer data between
 * different levels like service level, controller level and DAO level.*/

@Data
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

    /** Because we will order or the orders, so we need these two times in this class.*/
    private Date createTime;

    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
