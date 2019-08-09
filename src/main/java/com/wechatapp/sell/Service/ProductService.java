package com.wechatapp.sell.Service;

import com.wechatapp.sell.DataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findById(String id);

    /** Find all in stock products*/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // Add Stock

    // Eliminate Stock



}
