package com.wechatapp.sell.DataObject;
/** Order Master Table*/

import com.wechatapp.sell.Enums.OrderStatusEnum;
import com.wechatapp.sell.Enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 0 by default*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** Because we will order or the orders, so we need these two times in this class.*/
    private Date createTime;

    private Date updateTime;

//    Because the service might generate this list and then pass the list to controller, so
//    it would be complicated if do so, so for this case, we create a DTO class to deal with the scenario.
//    @Transient
//    // Because the database doesn't have this column, with this annotation, it will skip
//    // finding this column in database.
//    private List<OrderDetail> orderDetailList;
}
