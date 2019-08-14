package com.wechatapp.sell.Repository;

import com.wechatapp.sell.DataObject.OrderDetail;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("112");
        orderDetail.setOrderId("2");
        orderDetail.setProductIcon("http//xxxx.com");
        orderDetail.setProductId("111");
        orderDetail.setProductName("5 Tenders");
        orderDetail.setProductPrice(new BigDecimal(8.9));
        orderDetail.setProductQuantity(4);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> list = repository.findByOrderId("1");
        Assert.assertNotEquals(0, list.size());
    }
}
