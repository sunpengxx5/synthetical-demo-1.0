<%--
  Created by IntelliJ IDEA.
  User: SUNPENG
  Date: 2018/8/1
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
    <head>
        <script src="<%=path%>/js/jquery-3.3.1.min.js"></script>
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
                font-size:18px;
            }
            li {
                float:left;
                width:45%
            }

            li a, .dropbtn {
                display: inline-block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover, .dropdown:hover .dropbtn {
                background-color: #111;
            }

            .dropdown {
                display: inline-block;
                float: right;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #f1f1f1}

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .rushToBuyBtStyle{
                color:red;
                font-size:16px;
                width:100px;
            }
            .btStyle{
                font-size:16px;
                width:80px;
            }

            .head_div{
                position:absolute;
                width:100%;
                height:100%;
                background-color:black;
            }

        .rushToBuyBtStyle{
            color:red;
            font-size:16px;
            width:100px;
        }
        .btStyle{
            font-size:16px;
            width:80px;
        }

        .title-style{
            color:white;
            text-decoration:none;
        }
    </style>
</head>
<body>
    <ul>
        <li><a class="active" href="mall">主页</a></li>
        <li><a>水果店</a></li>
        <div class="dropdown" >
            <a id="loginBt" class="dropbtn">请登录</a>
            <div class="dropdown-content">
                <form method="post">
                    <a href="userDetail?userId=${sessionScope.userId}" id="personInfoHref" target="_blank" style="display:none">个人信息</a>
                    <a href="orders?userId=${sessionScope.userId}" id="orderInfoHref"target="_blank" style="display:none">您的订单</a>
                    <a href="pendingPaymentOrders?userId=${sessionScope.userId}" id="pendingPaymentHref"target="_blank" style="display:none">未支付订单</a>
                    <a onclick="signOut()" id="exitHref" target="" style="display:none">退出</a>
                    <a href="sign" id="signHref" target="_blank">登录/注册</a>
                </form>
            </div>
        </div>
    </ul>
    <br>
    <br>
</body>
    <script type="text/javascript">
        var userId="${sessionScope.userId}".toString();
        if(userId != "" ){
            $('#personInfoHref').show();
            $('#orderInfoHref').show();
            $('#pendingPaymentHref').show();
            $('#exitHref').show();
            $('#signHref').hide();
            $('#loginBt').text("用户信息");
        }
        function signOut(){
            $.ajax({
                type: 'get',
                url: 'signOut',
                data: '',
                success: function (data) {
                    if (data == "SignOutSuccess") {
                        window.location.href = "mall";
                    } else {
                        alert("提示：退出失败！");
                    }
                }
            })
        }
    </script>
</html>
