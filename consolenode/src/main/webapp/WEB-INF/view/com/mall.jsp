<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Demo Mall</title>
    <style type="text/css">
        .title{
            margin-right:1000px;
        }
        .rush-to-buy-ref-div{
            margin-right:100px;
        }
        .rush-to-buy-ref-color{
            color:red;
        }
    </style>
</head>
<body>
<jsp:include page="commonHeaderBanner.jsp"/>
<div align="center" class="title">
    <H1>抢购商品</H1>
</div>

<div align="right" class="rush-to-buy-ref-div">
    <a href="${rushToBuyScene}" class="rush-to-buy-ref-color"><h2>●商品限量抢购场景</h2></a>
</div>
<div align="center">
    <table align="center">
        <tr>
            <td>
                <form  id="rushToBuyFrom">
                    <img src="obtainGoodsPicture?pictureName=${rushToBuyGoods.goodsName}.jpg"  width="400" height="400">
                    <input type="hidden" name="goodsId" value="${rushToBuyGoods.goodsId}">
                    <input type="hidden" name="userId" value="${sessionScope.userId}">
                    <table align="center">
                        <tr>
                            <td>
                                <input type="button" class="rushToBuyBtStyle" value="商品详情" onclick="goodsDetail(${rushToBuyGoods.goodsId})">
                            </td>
                            <td>
                                <input type="button" class="rushToBuyBtStyle" value="抢购" onclick="rushToBuy(${rushToBuyGoods.goodsId})">
                            </td>
                        <tr/>
                    </table>
                </form >
            </td>
        </tr>
    </table>
</div>
<p/>
<p/>
<div align="center" class="title">
    <H1>普通商品</H1>
</div>
<table align="center">
    <c:forEach items="${goodsList }" var="goods" varStatus="status">
        <c:if test="${status.count%3==1}">
            <tr>
        </c:if>
        <td>
            <form id="buyFrom${goods.goodsId}" action="payPage" method="post">
                <img src="obtainGoodsPicture?pictureName=${goods.goodsName}.jpg"  width="300" height="300">
                <input type="hidden" name="goodsId" value="${goods.goodsId}">
                <table align="center">
                    <tr>
                        <td>
                            <input type="button" value="商品详情" class="btStyle" onclick="goodsDetail(${goods.goodsId})">
                        </td>
                        <td>
                            <input type="submit" class="btStyle" value="购买" onclick="validIsSignIn(${goods.goodsId})">
                        </td>
                    <tr/>
                </table>
            </form >
        </td>
        <c:if test="${status.last}">
            </tr>
        </c:if>
        <c:if test="${status.count%3==0}">
            </tr>
        </c:if>
    </c:forEach>
</table>
<script type="text/javascript">
    function goodsDetail(goodsId) {
        window.location.href="goodsDetail?goodsId="+goodsId;
    }

    function validIsSignIn(goodsId) {
        var userId = "${sessionScope.userId}".toString();
        var formName = "#buyFrom" + goodsId.toString();
        if(userId == "") {
            $(formName).attr('action', 'sign');
            $(formName).attr('method', 'get');
            alert("提示：请先登录！");
        }
    }

    function rushToBuy(goodsId) {
        var userId = "${sessionScope.userId}".toString();
        if(userId == "") {
            alert("提示：请先登录！");
            window.location.href="sign";
        }else {
            $.ajax({
                type: 'post',
                url: 'rushToBuy',
                data: 'userId=' + userId + '&goodsId=' + goodsId,
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
</script>

</body>
</html>