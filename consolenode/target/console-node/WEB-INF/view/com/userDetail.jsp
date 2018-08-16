<%--
  Created by IntelliJ IDEA.
  User: SUNPENG
  Date: 2018/8/1
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String bpath = request.getContextPath();
%>
<html>
<head>
    <title>用户信息</title>
    <style type="text/css">
        .tdStyle{
            width:100px;
            font-size:20px;
            padding: 5px 5px 5px 5px;
        }
    </style>
</head>
<body>
    <jsp:include page="commonHeaderBanner.jsp"/>
    <div align="center">
        <table align="center">
            <tr>
                <td>
                    <img src="<%=bpath%>${user.userHeadPortraitPath}"  width="200" height="200">
                </td>
                <td width="50"></td>
                <td>
                    <table >
                        <tr>
                            <td class="tdStyle">
                                用户ID
                            </td>
                            <td class="tdStyle">
                                ${user.userId}
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle">
                                姓名
                            </td>
                            <td class="tdStyle">
                                ${user.userName}
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle">
                                性别
                            </td>
                            <td class="tdStyle">
                                ${user.userSex}
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle">
                                等级
                            </td>
                            <td class="tdStyle">
                                ${user.userLevel}
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle">
                                余额(￥)
                            </td>
                            <td class="tdStyle">
                                ${user.userBalance}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
