package com.wechatapp.sell.Repository;

import com.wechatapp.sell.DataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByIdTest(){
        ProductCategory productCategory = repository.findById(1).orElse(null);
        System.out.print(productCategory.toString());
    }

    @Test
    @Transactional  // With this annotation, the test result won't really go to database. Roll back
    public void saveTest(){   // add
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Boys' likes");
        productCategory.setCategoryType(4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    /**
     * By this method, you have to set primary key and other columns.
     * For the createTime and updateTime, there're three results depending on @Dynamicupdate
     *  - Without @Dynamicupdate and createTime and updateTime, the createTime is constant, and updateTime would be updated to current time when run this method
     *  - With @Dynamicupdate, but createTime and updateTime exist in DataObject class. Both createTime and updateTime would be up-to-date.
     */
    @Test
    public void updateTest(){      // If you want to update, you have to set primary key
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryType(3);
        productCategory.setCategoryName("Boyss' likes");
        repository.save(productCategory);
    }


    /**
     * Recommended. The create_time won't be changed,
     * the update_time will be updated as expected.
     */
    @Test
    public void updateTest2(){
        ProductCategory productCategory = repository.findById(2).orElse(null);
        productCategory.setCategoryName("Girls' likes");
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());

    }
}
