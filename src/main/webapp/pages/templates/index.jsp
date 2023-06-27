<%--
  Created by IntelliJ IDEA.
  User: 王涛
  Date: 2023/6/8
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/pages/asserts/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/pages/asserts/css/signin.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/layui/css/layui.css">
</head>
<body class="text-center">
    <form class="form-signin" id="myForm">
        <img class="mb-5" src="${pageContext.request.contextPath}/pages/asserts/img/iflytek.png" alt="" width="272" height="72">
        <h1 class="h3 mb-3 font-weight-normal">刷脸登录</h1>
        <label class="sr-only">Username</label>
        <input type="text" class="form-control" id="userToken" required placeholder="UserToken"  autofocus="">
<%--        <input type="text" class="form-control" id="type" required placeholder="管理员:1  读者:2"  autofocus="">--%>
<%--        <form id="type">--%>
<%--            <input type="radio" value="0"  checked="checked" >管理员--%>
<%--            <br>--%>
<%--            <input type="radio" value="1"  checked="checked">读者--%>
<%--        </form>--%>
        <br>
        <select id="type" name="type" class="form-control" autofocus="">
            <option value="">请选择用户类型</option>
            <option value="1">管理员</option>
            <option value="2">读者</option>
        </select>
        <div class="checkbox mb-3"></div>

        <button class="btn btn-lg btn-primary btn-block" id="faceLoginPage" type="submit">刷脸登录</button>
        <button class="btn btn-lg btn-primary btn-block" id="faceRegistePage" >人脸注册</button>
        <p class="mt-5 mb-3 text-muted">© 2022-2023</p>
        <a class="btn btn-sm">中文</a>
        <a class="btn btn-sm">English</a>
    </form>
</body>
</html>
<script src="${pageContext.request.contextPath}/pages/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/asserts/getFace/js/jquery-3.4.1.min.js"></script>
<script>
    $(function(){
        let type=$("#type").val()
        console.log(type)
        let userToken=$("#type").val()
        console.log(userToken)
        $("#faceLoginPage").click(function(){
            console.log("111")
            let userToken =$("#userToken").val();
            console.log(userToken)

            let type=$("#type").val()
            console.log(type)

            if(userToken){
                $("#myForm").submit(function(){
                    return false;
                })
                console.log("222")
                console.log(userToken)
                console.log(type)
                localStorage.setItem("userToken",$("#userToken").val())
                localStorage.setItem("type",$("#type").val())

                window.location.href = "${pageContext.request.contextPath}/jumpGetFace"
            }
        })
        $("#faceRegistePage").click(function(){
            window.location.href = "${pageContext.request.contextPath}/jumpTakeFace"
        })
    })
</script>