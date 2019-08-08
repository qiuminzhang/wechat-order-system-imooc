package com.wechatapp.sell.Service.Implementation;

import com.wechatapp.sell.DataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * Test by assertion
     * If test passes, show pass and nothing on console. otherwise raise error.
     */
    @Test
    public void findOneById() {
        ProductCategory productCategory = categoryService.findOneById(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertEquals(new Integer(2), new Integer(list.size()));
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotEquals(new Integer(0), new Integer(list.size()));
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("Boys' likes", 4);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}
