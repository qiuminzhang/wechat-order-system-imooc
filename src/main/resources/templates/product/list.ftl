<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--side bar-->
    <#include "../common/nav.ftl">

    <#--main content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <#-- head-->
                        <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Icon</th>
                            <th>Price</th>
                            <th>Stock</th>
                            <th>Description</th>
                            <th>Category</th>
                            <th>Create Time</th>
                            <th>Update Time</th>
                            <th colspan="2">Action</th>
                        </tr>
                        </thead>
                        <#-- body-->
                        <tbody>
                        <#list productInfoPage.content as productInfo> <#-- loop -->
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td>${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                                <td>${productInfo.createTime}</td>
                                <td>${productInfo.updateTime}</td>
                                <td><a href="/sell/seller/product/index?productId=${productInfo.getProductId()}">Modify</a></td>
                                <td>
                                    <#if productInfo.getProductStatusEnum().message == "InStock">
                                        <a href="/sell/seller/product/off_sale?productId=${productInfo.getProductId()}">Off Sale</a>
                                    <#else >
                                        <a href="/sell/seller/product/on_sale?productId=${productInfo.getProductId()}">On Sale</a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <#--翻页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#--上一页-->
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">Prev</a></li>
                        <#else>
                            <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}">Prev</a></li>
                        </#if>
                        <#--当前页-->
                        <#list 1..productInfoPage.totalPages as index>
                            <#if currentPage == index> <#--Disable current page number-->
                                <li class="disabled"><a href="#">${currentPage}</a></li>
                            <#else>
                                <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                        <#--下一页-->
                        <#if currentPage gte productInfoPage.totalPages>
                            <li class="disabled"><a href="#">Next</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">Next</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<#--&lt;#&ndash;traverse a list&ndash;&gt;-->
<#--<#list orderDTOPage.content as orderDTO>-->
<#--    ${orderDTO.orderId}<br>-->
<#--</#list>-->