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
                                <th>Order ID</th>
                                <th>Name</th>
                                <th>Phone Number</th>
                                <th>Address</th>
                                <th>Amount</th>
                                <th>OrderStatus</th>
                                <th>PaymentStatus</th>
                                <th>CreateTime</th>
                                <th colspan="2">Action</th>
                            </tr>
                            </thead>
                            <#-- body-->
                            <tbody>
                            <#list orderDTOPage.content as orderDTO> <#-- loop -->
                                <tr>
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.getOrderStatusEnum()}</td>
                                    <td>${orderDTO.getPayStatusEnum()}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.getOrderId()}">Detail</a></td>
                                    <td>
                                        <#if orderDTO.getOrderStatusEnum().message == "New Order">
                                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}">Cancel</a>
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#--上一页-->
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">Prev</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">Prev</a></li>
                            </#if>
                            <#--当前页-->
                            <#list 1..orderDTOPage.totalPages as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${currentPage}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#--下一页-->
                            <#if currentPage gte orderDTOPage.totalPages>
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