package com.wechatapp.sell.Service.Implementation;

import com.wechatapp.sell.DTO.CartDTO;
import com.wechatapp.sell.DataObject.OrderDetail;
import com.wechatapp.sell.DataObject.ProductInfo;
import com.wechatapp.sell.Enums.ProductStatusEnum;
import com.wechatapp.sell.Enums.ResultEnum;
import com.wechatapp.sell.Exception.SellException;
import com.wechatapp.sell.Repository.ProductInfoRepository;
import com.wechatapp.sell.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String  productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOSList) {
        for(CartDTO cartDTO : cartDTOSList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            // update stock
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional  // Once error appears, roll back.
    public void decreaseStock(List<CartDTO> cartDTOSList) {
        for(CartDTO cartDTO : cartDTOSList){
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            // Update Stock
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
