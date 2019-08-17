package com.wechatapp.sell.Repository;

import com.wechatapp.sell.DataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("113");
        productInfo.setProductName("Chicken Fingers");
        productInfo.setProductPrice(new BigDecimal(12.9));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(20);
        productInfo.setProductIcon("http://tenders.com");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("Spicy and tender");

        repository.save(productInfo);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotNull(list);
    }
}
