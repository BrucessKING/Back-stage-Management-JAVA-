<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/css/layui.css">
    <title>登录界面</title>
    <style>
        .title {
            text-align: center;
            font-size: 28px;
            margin: 40px auto 20px auto;
        }
        .lable{
            padding-left:40px;
        }
        tr {
            height:40px;
        }
    </style>
</head>
<body>
<div class="title">登录</div>
<form action="./auth" method="POST" >
    <table align="center">
        <tr>
            <td class="lable">用户名：</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td class="lable">密码：</td>
            <td><input type="password" name="password" /></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center">
                <button type="submit" class="layui-btn">确定</button>
                <button type="reset" class="layui-btn">重置</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
