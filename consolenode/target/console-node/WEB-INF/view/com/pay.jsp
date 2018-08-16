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
    <title>付款</title>
    <style type="text/css">
        .tdStyle{
            width:100px;
            font-size:20px;
            padding: 5px 5px 5px 5px;
        }
        .payBtStyle{
            font-size:20px;
            color: red;
            font-weight:bold;
            width:200px;
        }
        .pay-div{
            margin-right:800px;
        }
    </style>
</head>
<body>
<jsp:include page="commonHeaderBanner.jsp"/>

<div align="center" class="pay-div">
    <H1>付款</H1>
</div>
<div align="center">
    <table align="center">
        <tr>
            <td>
                <img src="${goods.goodsPicturePath}"  width="400" height="400">
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
                            ${goods.goodsCount}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <p></p>
    <p></p>
    <p></p>
    <div align="center">
        <input id="paybt" type="button" value="确认付款" class="payBtStyle" onclick="pay()">
    </div>
</div>

<script type="text/javascript">
    function pay() {
        var userId='${sessionScope.userId}'.toString();
        if(userId != "" ){
            var goodsId='${goods.goodsId}'.toString();
            var goodsPrice='${goods.goodsPrice}'.toString();
            if(!(goodsId==''||goodsPrice=='')) {
                $.ajax({
                    type: 'post',
                    url: 'pay',
                    data: 'userId=' + userId + '&goodsId=' + goodsId + '&goodsPrice=' + goodsPrice,
                    success: function (data) {
                        if (data == "PaySuccess") {
                            window.location.href = "orders?userId=" + userId;
                        } else {
                            alert("提示：付款失败[可能原因：余额不足、库存不足]");
                        }
                    }
                })
            }else{
                console.error('Params exits empty,please check it!');
            }
        }else {
            alert("提示：请先登录！");
        }
    }
</script>
</body>
</html>
