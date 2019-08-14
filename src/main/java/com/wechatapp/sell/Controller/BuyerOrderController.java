package com.wechatapp.sell.Controller;

import com.wechatapp.sell.Converter.OrderForm2OrderDTOConverter;
import com.wechatapp.sell.DTO.OrderDTO;
import com.wechatapp.sell.DataObject.OrderDetail;
import com.wechatapp.sell.Enums.ResultEnum;
import com.wechatapp.sell.Exception.SellException;
import com.wechatapp.sell.Form.OrderForm;
import com.wechatapp.sell.Service.BuyerService;
import com.wechatapp.sell.Service.OrderService;
import com.wechatapp.sell.Utils.ResultVOUtil;
import com.wechatapp.sell.VO.ResultVO;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    // Create Order
    /**
     * Create an order
     * @param orderForm Contains required parameters(refer to API) defined and validated in OrderForm class.
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {  //
            log.error("【创建订单】Wrong Parameters, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());   // Throw code and actual error msg defined in OrderForm
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】The cart cant be empty");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        // Use Service to create order
        OrderDTO createResult = orderService.create(orderDTO);
        // According to the API and build the return value.
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    // Order List
    @GetMapping(value = "/list")
    public ResultVO<List<OrderDTO>> list (@RequestParam("openid") String openid,
                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
                                          @RequestParam(value = "size", defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)) {
            log.error("【订单查询列表】 openid is null");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    // View Order Detail
    @GetMapping("/detail")
    public ResultVO<List<OrderDTO>> detail(@RequestParam("openid") String openid,
                                           @RequestParam("orderId") String orderId) {
        // By this method, it validates if the openid matches the order's openid
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    // Cancel Order
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrderOne(openid, orderId);
        return ResultVOUtil.success();
    }

}
