<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
    <meta charset="utf-8">
    <script type="text/javascript">
        $(function(){
            $("#choosePic").on("change", function(){
                $("#filename").text(this.files[0].name);
                var imgFile = this.files[0];
                var fr = new FileReader();
                fr.readAsDataURL(imgFile);
                //onload作用：文件读取成功完成时触发
                fr.onload = function(){
                    $("#demo1").attr("src",fr.result);
                };
            });
            $("#up").on("click", function(){
                var formData = new FormData();
                //var picFile = $("input[id=choosePic]")[0].files[0];//JQuery对象转换成DOM对象
                var password = $("#password").val();
                var re_password = $("#re_password").val();
                var picSrc = $("#demo1").attr("src");
                formData.append("picSrc",picSrc);
                if(password == re_password)
                    formData.append("password",password);
                else
                    alert("两次输入的密码不正确！");

                //alert(formData.get("picFile"));
                $.ajax({
                    //async:false,//false同步请求，当前请求未完成将会锁死浏览器
                    url: "changeInfo",
                    type:"POST",
                    data:formData,
                    //cache:false,//文件上传，不要缓存之前的文件
                    //不处理数据为查询字符串
                    processData:false,
                    //不使用默认的"application/x-www-form-urlencoded"
                    contentType:false,
                    dataType:"text",
                    success:function(data){
                        console.log(data);
                        alert(data);
                        //var picSrc = $("#demo1").attr("src");
                        $("#picture").attr("src",picSrc);
                    }
                });
            });
        });
    </script>
</head>
<body>


<div style="margin-top: 10%;margin-left: 30%;">
    用户名：<span id="username">${user.username}</span><br><br>
    <%--<input type="text" id="username" name="username" value="${user.username}" style="cursor:not-allowed" class="layui-input"></br>--%>
    密码：<input type="password" id="password" name="password" class="layui-input" placeholder="请输入密码"></br>
    重复输入密码：<input type="password" id="re_password" name="re_password" class="layui-input" placeholder="请再次输入密码"></br>

    <div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
        <button type="button" class="layui-btn">上传图片</button>
        <input type="file" id="choosePic" style="position:absolute;top:0;left:0;font-size:34px; opacity:0" accept=".png,.jpeg,.jpg,.gif">
    </div><span id="filename">未上传文件</span><br>
    <img class="layui-upload-img" id="demo1" src="${user.img}" style="border-radius: 30px;width:60px;height:60px;">
    <p id="demoText"></p>
    <button type="button" class="layui-btn" id="up">确定</button>
</div>
</body>
</html>