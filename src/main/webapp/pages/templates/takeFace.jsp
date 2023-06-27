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
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>拍照</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/pages/asserts/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/pages/asserts/css/signin.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/layui/css/layui.css">
</head>

<body>
<div style="width: 400px;height: 600px;text-align: center;">
    <img class="mb-3" src="${pageContext.request.contextPath}/pages/asserts/img/iflytek.png" alt="" width="272" height="72">
<%--    <div class="input-group mb-xl-3" style="margin-bottom: 10px;">--%>
<%--        <div class="input-group-prepend">--%>
<%--            <span class="input-group-text" id="basic-addon1">账号:</span>--%>
<%--        </div>--%>
<%--        <input type="text" id="userToken" name="userToken" class="form-control" placeholder="UserToken"--%>
<%--               aria-label="Username" aria-describedby="basic-addon1" onblur="validateUserToken()">--%>
<%--        <div class="input-group-append" id="result"></div>--%>
<%--    </div>--%>
    <div class="input-group mb-xl-3">
        <button type="button" class="btn btn-primary" style="margin-left: 20px;" onclick="openMedia()">开启摄像头</button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px;" onclick="takePhoto()">拍照</button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px;" onclick="closeMedia()">关闭摄像头</button>
        <button type="button" id="uploadFace" class="btn btn-primary" style="margin-left: 10px;" onclick="uploadFace()">上传</button>
<%--        <button type="button" id="uploadFace" class="btn btn-primary" style="display:none;margin-left: 10px;" onclick="uploadFace()">上传</button>--%>
    </div>
    <div class="input-group mb-xl-3">
        <video style="display: none;border: 1px solid #007bff" class="src-video" width="400px" height="400px"
               autoplay="autoplay"></video>
        <canvas id="canvas" width="400px" height="400px" style="display: none;"></canvas>
        <img src="" alt="" class="photo">
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/asserts/getFace/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/pages/layui/layui.js"></script>
<script>
    let srcVideo = document.querySelector('video.src-video');
    let mediaStream;
    let photo = document.querySelector('img.photo');
    let canvasUrl;
    let resultMark =false;

    // 校验账号
    <%--function validateUserToken(){--%>
    <%--    $.ajax({--%>
    <%--        url: "${pageContext.request.contextPath}/face/validateUserToken",    //请求的url地址--%>
    <%--        async: true,//请求是否异步，默认为异步，这也是ajax重要特性--%>
    <%--        // contentType:"application/json",--%>
    <%--        data: {"userToken": $("#userToken").val()}, //参数值--%>
    <%--        type: "POST", //请求方式--%>
    <%--        success: function (data) {--%>
    <%--            if (data.code == 200) {--%>
    <%--                $("#result").html("<span class=\"input-group-text\" style='color:green;'>√</span>")--%>
    <%--                resultMark=true;--%>
    <%--                $("#uploadFace").show();--%>
    <%--            }else{--%>
    <%--                resultMark=false;--%>
    <%--                $("#result").html("<span class=\"input-group-text\" style='color:red;'>x</span>")--%>
    <%--                $("#uploadFace").hide();--%>
    <%--            }--%>
    <%--        }--%>
    <%--    })--%>
    <%--}--%>
    // 开启摄像头
    function openMedia() {
        photo.src = '';
        srcVideo.style.display = 'block';
        let constraints = {
            audio: false, //音频轨道
            video: {width: 500, height: 500}  //视频轨道
        }
        let mediaPromise = navigator.mediaDevices.getUserMedia(constraints);
        mediaPromise.then(function (stream) {
            /* 使用这个stream stream */
            mediaStream = stream;
            srcVideo.srcObject = stream;
            srcVideo.play();
        }).catch(function (err) {
            /* 处理error */
            alert(err);
        });
    };

    // 拍照
    function takePhoto() {
        let canvas = document.querySelector('#canvas');
        //获取 `canvas`元素，根据`srcVideo`中的数据进行图片绘制 `ctx.drawImage()`；
        let ctx = canvas.getContext('2d');
        ctx.drawImage(srcVideo, 0, 0, 400, 400);
        //将 `canvas`绘制的图片信息，展示在 `img`标签中；
        canvasUrl = canvas.toDataURL();
        photo.src = canvasUrl
        closeMedia();
    }

    // 关闭摄像头
    function closeMedia() {
        mediaStream.getTracks().forEach(track => {
            track.stop();
        });
        srcVideo.style.display = 'none';
    }


    function uploadFace() {
        if (canvasUrl) {
            console.log(canvasUrl)
            $.ajax({
                url: "${pageContext.request.contextPath}/saveFaceBase64",    //请求的url地址
                async: true,//请求是否异步，默认为异步，这也是ajax重要特性
                // contentType:"application/json",
                // data: {"userFaceBase64": canvasUrl, "userToken": userToken}, //参数值
                data: {"userFaceBase64": canvasUrl}, //参数值
                type: "POST", //请求方式
                success: function (data) {
                    if (data.code == 200) {
                        <%--layer.msg(data.msg, {icon: 1, time: 2000}, function () {--%>
                        <%--    window.location.href = "${pageContext.request.contextPath}/index"--%>
                        <%--});--%>
                        layer.msg(data.msg, {icon: 1, time: 2000},function (){
                            window.location.href = "${pageContext.request.contextPath}/jumpTakeFace"
                        });
                    }
                }
            })
        }
    }

</script>
</html>
