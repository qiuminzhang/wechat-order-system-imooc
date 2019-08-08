package com.wechatapp.sell.Service;

import com.wechatapp.sell.DataObject.ProductCategory;

import java.util.List;

public interface CategoryService {

     // for backend
     ProductCategory findOneById(Integer categoryId);

     List<ProductCategory> findAll();

     List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

     ProductCategory save(ProductCategory productCategory);

}
