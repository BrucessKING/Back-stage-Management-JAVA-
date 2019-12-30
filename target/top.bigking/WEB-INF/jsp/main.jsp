<%--
  Created by IntelliJ IDEA.
  User: 小新
  Date: 2019/12/20
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href="static/css/layui.css">
    <script type="text/javascript" src="static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#div0 a").on("click", function(event){
                var hrefSrc = this.getAttribute("href");
                //alert(hrefSrc);
                event.preventDefault();
                $('#div1').load(hrefSrc);
            });
        });
    </script>
</head>
<body>

<div id="div0" style="width:200px;height:650px;float:left;background-color: rgb(62,66,79);">

        <img class="layui-upload-img" id="picture" src="${user.img}" style="border-radius: 30px;width:60px;height:60px;">
    <span style="color:#FFFFFF;"> ${user.username}</span>
    <ul style="list-style: none;" class="layui-nav layui-nav-tree layui-inline">
        <li class="layui-nav-item"><a href="myInfo">修改信息</a></li>
        <li class="layui-nav-item"><a href="search">查询</a></li>
        <li class="layui-nav-item"><a href="messageBoard">留言板</a></li>
        <li class="layui-nav-item"><a href="logout">注销</a></li>
    </ul>
</div>
<div id="div1" style="width:900px;height:600px;float:left;">

</div>
</body>
</html>
