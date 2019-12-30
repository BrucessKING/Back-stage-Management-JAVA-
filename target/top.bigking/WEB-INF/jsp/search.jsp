<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新
  Date: 2019/12/29
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>查询</title>
    <meta charset="utf-8">
    <script type="text/javascript">
        $(function(){
            $("a[id=del]").on("click", function(event){//不能使用$("#del")，否则选不中所有对象，$("#del")选不中所有对象
                var delHref = this.getAttribute("href");
                event.preventDefault();
                $.ajax({
                    url:delHref,
                    type:"GET",
                    success:function(){
                        alert("sucess");
                        $('a[href="search"]').click();
                    }
                });
            });
        });
    </script>
</head>
<body>
<div style='margin-left:5%;margin-top:1%'><h2>学生信息-共${count}人</h2>
    <table class='layui-table'>
        <thread>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thread>

        <tbody>
        <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gender}</td>
            <td><a class='layui-btn'>编辑(开发中)</a></td>
            <td><a id='del' class='layui-btn layui-btn-danger' href='delStudent?id=${student.id}'>删除</a></td>
        </tr>
        </c:forEach>
        </tbody>
</body>
</html>
