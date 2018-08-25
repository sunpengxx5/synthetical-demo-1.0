<%--
  Created by IntelliJ IDEA.
  User: SUNPENG
  Date: 2018/7/31
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>商品详情</title>
    <style type="text/css">
        .tdStyle{
            width:100px;
            font-size:20px;
            padding: 5px 5px 5px 5px;
        }
        .payBtFloatLeft{
            margin-left:400px;
        }

        .payBtStyle{
            font-size:20px;
            width:150px;
        }

        .goodsInfo{
            margin-right:800px;
        }

        .rushToBuyBt{
            font-size:20px;
            width:150px;
            color: red;
        }
        .goods-count-style{
            border: 0;
            font-size:17px;
            outline:none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="commonHeaderBanner.jsp"/>
<div align="center" class="goodsInfo">
    <H1>商品详情</H1>
</div>
<div align="center">
    <form id="payForm" action="payPage" method="post">
        <table align="center">
            <tr>
                <td>
                    <img src="obtainGoodsPicture?pictureName=${goods.goodsName}.jpg"  width="400" height="400">
                </td>
                <td>
                    <table >
                            <tr>
                                <td class="tdStyle">
                                    商品ID
                                </td>
                                <td>
                                    ${goods.goodsId}
                                </td>
                            </tr>
                            <tr>
                                <td class="tdStyle">
                                    名称
                                </td>
                                <td>
                                    ${goods.goodsName}
                                </td>
                            </tr>
                            <tr>
                                <td class="tdStyle">
                                    价格(￥)
                                </td>
                                <td>
                                    ${goods.goodsPrice}
                                </td>
                            </tr>
                            <tr>
                                <td class="tdStyle">
                                    简介
                                </td>
                                <td>
                                    ${goods.goodsDescribe}
                                </td>
                            </tr>
                            <tr>
                                <td class="tdStyle">
                                    库存数量
                                </td>
                                <td>
                                    <input id="goodsCountInput" class="goods-count-style" value="加载中..." readonly="value">
                                </td>
                            </tr>
                        </table>
                </td>
            </tr>
        </table>
        <input name="goodsId" value="${goods.goodsId}" type="hidden">
        <div align="center" class="payBtFloatLeft">
            <input id="payBt" type="submit" value="购买" class="payBtStyle" onclick="sign()">
            <input id="rushToBuyBt" type="button" value="抢购" class="rushToBuyBt" onclick="rushToBuy()" style="display:none">
        </div>
    </form>
</div>

<script type="text/javascript">
    var goodsType = "${goods.goodsType}".toString();
    if(goodsType == "RushToBuy"){
        $('#payBt').hide();
        $('#rushToBuyBt').show();
    }

    $(function () {
        $.ajax({
            type: 'get',
            url: 'goodsCount',
            data: 'goodsId=' + ${goods.goodsId}+'&goodsType=${goods.goodsType}',
            success: function (data) {
                if(data == -1){
                    $('#goodsCountInput').val("加载失败...");
                }else {
                    $('#goodsCountInput').val(data);
                }
            }
        });
    });


    function rushToBuy() {
        var userId = "${sessionScope.userId}".toString();
        if(userId == "") {
            alert("提示：请先登录！");
            window.location.href="sign";
        }else {
            $.ajax({
                type: 'post',
                url: 'rushToBuy',
                data: 'userId=' + userId + '&goodsId=' + ${goods.goodsId},
                success: function (data) {
                    if (data == "Success") {
                        window.location.href = "pendingPaymentOrders?userId=" + userId;
                    } else {
                        window.location.href = "rushToBuyFailed";
                    }
                }
            });
        }
    }

    function sign() {
        var userId = "${sessionScope.userId}".toString();
        if(userId == "") {
            $("#payForm").attr('action', 'sign');
            $("#payForm").attr('method', 'get');
            alert("提示：请先登录！");
        }
    }
</script>
</body>
</html>
