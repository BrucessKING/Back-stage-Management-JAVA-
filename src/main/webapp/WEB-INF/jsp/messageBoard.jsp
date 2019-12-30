<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新
  Date: 2019/12/29
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>留言板</title>
    <script type="text/javascript">
        var myDate = new Date();
        var year=myDate.getFullYear();        //获取当前年
        var month=myDate.getMonth()+1;   //获取当前月
        var day=myDate.getDate();            //获取当前日
        var now_time = year+'-'+month+'-'+day;
        //alert(now_time);
        $(function() {
            $("#sub").on("click", function () {
                var formData = new FormData();
                var nickname = $("input[name=nickname]").val();
                var content = $("textarea[name=content]").val();
                var email = $("input[name=email]").val();
                formData.append("nickname", nickname);
                formData.append("content", content);
                formData.append("email", email);
                formData.append("now_time", now_time);
                if (nickname == "" || content == "" || email == "")
                    alert("不能为空！");
                else {
                    $.ajax({
                        //async:false,//false为同步请求，当前请求未完成可能会锁死浏览器
                        url: "addMessage",
                        type: "POST",
                        processData: false,
                        contentType: false,
                        data: formData,
                        dataType: "text",
                        success: function (data) {
                            console.log(data);
                            alert("success");
                            $('a[href="messageBoard"]').click();//刷新页面
                        }
                    });
                }
            });
        });
        $(function() {
            $("a[id=del]").on("click", function (e) {
                e.preventDefault();
                var formData = new FormData();
                var floor = $("#del").attr("href");
                formData.append("floor", floor);
                $.ajax({
                    //async:false,//false为同步请求，当前请求未完成可能会锁死浏览器
                    url: "delMessage",
                    type: "POST",
                    processData: false,
                    contentType: false,
                    data: formData,
                    dataType: "text",
                    success: function (data) {
                        console.log(data);
                        alert(data);
                        $('a[href="messageBoard"]').click();//刷新页面
                    }
                });
            });
        });
    </script>
    <style type="text/css">
        .d{
            margin-top: 2%;
            margin-left: 5%;
            margin-right: 5%;
            background-color: rgb(218,244,205);
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<c:forEach items="${messageBoards}" var="message">
<div class="d" style="margin-top:1%">
    <div style="background-color: rgb(55,162,113);">
        <p style="text-align: right;">${message.floor}楼 </p>
    </div>
    <p>${message.content}</p>
    <a href=""><pre style="text-align: right;">留言者：${message.author}</pre></a>
    <a href="">留言时间： <fmt:formatDate value="${message.messageDate}" pattern="yyyy-MM-dd" /> </a>
    <a id="del" name="del" style="color:red;" href="${message.floor}">删除</a>
</div>
</c:forEach>
    <div class="d">
    <form>
        <input type="text" name="nickname" placeholder="留言者昵称"><br />
        <input type="text" name="email" placeholder="留言者邮箱"><br />
        <textarea name="content" rows="5" cols="50" placeholder="留言内容"></textarea><br />
        <input type="button" name="button" id="sub" value="提交">
    </form>
</div>
</body>
</html>
