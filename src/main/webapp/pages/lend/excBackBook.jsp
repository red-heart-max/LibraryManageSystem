<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <title>异常还书</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <input type="hidden" name="id"  value="${id}"/>
    <input type="hidden" name="bookId"  value="${bid}"/>
    <div class="layui-form-item">
        <label class="layui-form-label required">异常类型</label>
        <div class="layui-input-block">
            <select name="backType" id="backType" lay-verify="required">
                <option value="">请选择</option>
<%--                <option value="0">正常还书</option>--%>
                <option value="1">延迟还书</option>
                <option value="2">破损还书</option>
                <option value="3">丢失</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">异常备注</label>
        <div class="layui-input-block">
            <textarea name="exceptRemarks" class="layui-textarea" > </textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认还书</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
</body>
<script>
    layui.use(['table','form'],function (){
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        form.on('submit(saveBtn)', function (data) {
            var lendBook = data.field;//form单中的数据信息
            console.log(lendBook)
            $.ajax({
                url:"excBackBook",
                type:"POST",
                data:lendBook,
                success:function(result){
                    if(result.code==200){//如果成功
                        layer.msg('还书成功',{
                            icon:6,
                            time:500
                        },function(){
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                        layer.msg("还书失败");
                    }
                }
            })



            return false;
        })

    })
</script>
</html>
