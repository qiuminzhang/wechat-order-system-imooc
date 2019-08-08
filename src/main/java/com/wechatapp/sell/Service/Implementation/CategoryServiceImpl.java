package com.wechatapp.sell.Service.Implementation;

import com.wechatapp.sell.DataObject.ProductCategory;
import com.wechatapp.sell.Repository.ProductCategoryRepository;
import com.wechatapp.sell.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Product Category Service
 */
@Service
// shortcut: control + O to add methods in interface
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository repository;

    @Override
    public ProductCategory findOneById(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    /**
     * select * from table;
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
