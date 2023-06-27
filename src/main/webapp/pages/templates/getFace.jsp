<%--
  Created by IntelliJ IDEA.
  User: 王涛
  Date: 2023/6/8
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
    <title>js调用摄像头拍照上传图片</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/layui/css/layui.css">

</head>
<style>
    .getface {
        position: absolute;
        top: 20%;
        left: 35%;

    }

    .tishi {
        font-size: 20px;

    }
</style>
<body>
<div class="input-group mb-xl-3" style="margin-bottom: 10px;margin-top:50px;text-align: center;">
<%--    <div class="input-group mb-xl-3" id="iflytekLogo"></div>--%>
    <div class="input-group mb-xl-3" style="margin-top: 10px;height: 30px;">
        <p id="flag" class="tishi"></p>
    </div>
    <div class="input-group mb-xl-3" style="margin-top: 10px;">
        <video id="video"   width="400px" height="400px" autoplay="autoplay"></video>
        <canvas id="canvas" width="400px" height="400px" style="display: none;"></canvas>
        <img id="imgTag" src="" alt="imgTag" style="display: none;">
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/pages/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/asserts/getFace/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/asserts/getFace/js/getFace.js"></script>
</html>