package com.wechatapp.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Product and category
 */
@Data
public class ProductVO {

    @JsonProperty("name")  // rename the variable in JSON
    private String categoryName;

    // To differentiate names in code, we cant simply name variable as name or type.
    // But the API documentation requires the fields should be *name* or *type*.
    // So we use JsonProperty to rename the variable in JSON result.
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
