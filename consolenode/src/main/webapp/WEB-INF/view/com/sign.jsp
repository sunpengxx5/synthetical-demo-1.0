<%--
  Created by IntelliJ IDEA.
  User: SUNPENG
  Date: 2018/8/1
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录/注册</title>
    <style type="text/css">
        .loginBtStyle{
            font-size:15px;
            width:75px;
        }
        .loginFloatLeft{
            margin-left: 50px;
        }
    </style>
</head>
<body>
    <jsp:include page="commonHeaderBanner.jsp"/>
    <h1 style="color:black" align="center">登录/注册</h1>
    <div style="width:100%;text-align:center" align="center">
        <div align="left">
            <form id="loginForm" name="loginForm">
                <table border="0" align="center">
                    <tr>
                        <td>账号：</td>
                        <td><input type="text" id="userName" name="username" required="required"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" id="userPwd" name="password" required="required">
                        </td>
                    </tr>
                </table>
                <br>
            </form>
        </div>
        <div align="center" class="loginFloatLeft">
            <input id="signInBt" type="button"  value="登录" class="loginBtStyle"/>
            <input id="signUpBt" type="button" value="注册" class="loginBtStyle" />
        </div>
    </div>
    <script type="text/javascript">
        $('#signInBt').on('click',function () {
            var userName = $('#userName').val();
            var userPwd = $('#userPwd').val();
            if(userName == "" || userPwd == ""){
                alert("提示：账号或密码不能为空！")
            }else{
                $.ajax({
                    type:'post',
                    url:'signIn',
                    data:$('#loginForm').serialize(),
                    success:function (data) {
                        if(data=="success"){
                            window.location.href="mall";
                        }else{
                            alert("提示：登陆失败，请检查输入信息是否正确！");
                        }
                    }
                });
            }
        });

        $('#signUpBt').on('click',function () {
            var userName = $('#userName').val();
            var userPwd = $('#userPwd').val();
            if(userName == "" || userPwd == ""){
                alert("提示：账号或密码不能为空！")
            }else {
                $.ajax({
                    type: 'post',
                    url: 'signUp',
                    data: $('#loginForm').serialize(),
                    success: function (data) {
                        if (data == "success") {
                            window.location.href = "mall";
                        } else {
                            alert("注册失败，已存在同名用户！");
                        }
                    }
                });
            }
        });
    </script>
</body>
</html>
