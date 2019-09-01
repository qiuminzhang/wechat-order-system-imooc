package com.wechatapp.sell.DataObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wechatapp.sell.Enums.ProductStatusEnum;
import com.wechatapp.sell.Utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    /** Product Icon which is actually an url*/
    private String productIcon;

    /** 0-Normal, 1-Sold out*/
    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


    /**Get enum value by status code*/
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getEnumValueByCode(productStatus, ProductStatusEnum.class);
    }
}
