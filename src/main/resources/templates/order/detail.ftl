<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--side bar-->
    <#include "../common/nav.ftl">

    <#--main content-->
    <div class="container">
        <div class="row clearfix">
            <#--表头-->
            <div class="col-md-4 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Order Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderDTO.getOrderId()}</td>
                        <td>${orderDTO.getOrderAmount()}</td>
                    </tr>
                    </tr>
                    </tbody>
                </table>
            </div>

            <#--Order detail data-->
            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderDTO.getOrderDetailList() as detail>
                        <tr>
                            <td>${detail.productId}</td>
                            <td>${detail.productName}</td>
                            <td>${detail.productPrice}</td>
                            <td>${detail.productQuantity}</td>
                            <td>${detail.productPrice * detail.productQuantity}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>

            <#--Button-->
            <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().message == ("New Order")>
                    <a href="/sell/seller/order/finish?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-primary">Finish Order</a>
                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-danger">Cancel Order</a>
                </#if>
                <a href="/sell/seller/order/list" type="button" class="btn btn-default btn-warning">Back</a>

            </div>
        </div>
    </div>
</div>

</body>
</html>