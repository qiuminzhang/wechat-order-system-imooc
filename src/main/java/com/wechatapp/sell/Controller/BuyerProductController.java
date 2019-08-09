package com.wechatapp.sell.Controller;

import com.wechatapp.sell.DataObject.ProductCategory;
import com.wechatapp.sell.DataObject.ProductInfo;
import com.wechatapp.sell.Service.CategoryService;
import com.wechatapp.sell.Service.ProductService;
import com.wechatapp.sell.Utils.ResultVOUtil;
import com.wechatapp.sell.VO.ProductInfoVO;
import com.wechatapp.sell.VO.ProductVO;
import com.wechatapp.sell.VO.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")   // URL
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * Get product list.
     */
    @GetMapping("/list")
    public ResultVO list(){
        /**
         * Add data from database to the result
         * 1. check all available product
         * 2. check category (at one time)
         * 3. add these data to the format result.
         */

        // STEP 1. check all available product
        List<ProductInfo> productInfoList = productService.findUpAll();
        System.out.println(productInfoList.size());

        // STEP 2. check category (at one time一次性) ---> for loop and get types from productInfoList
        // 为啥呢？ 不要！把查询放到for loop里。试想如果有10000条数据，查起来十分耗时间。
//         (1). Traditional approach to get category types
////        for(ProductInfo productInfo : productInfoList){
////            categoryTypeList.add(productInfo.getCategoryType());
////        }
        // (2) simply approach ---> lambda
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // STEP 3. add these data to the format result 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO); // copy properties from scs to target. !Both object should have getter or setter or @Data
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("success");
//        resultVO.setData(productVOList);

        return ResultVOUtil.success(productVOList);
    }

}
