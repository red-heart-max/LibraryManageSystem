<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>借书</title>
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


<%--    <!---高级查询图书-->--%>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label required">图书名称</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input class="layui-input" name="name" id="name" autocomplete="off" data-type="reload">--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label required">借书卡号</label>
        <div class="layui-input-block">
            <input type="text" name="readerNumber" lay-verify="required" lay-reqtext="借书卡不能为空" placeholder="请输入借书卡" value="" class="layui-input">
        </div>
    </div>



    <div class="layui-form-item">
<%--        <label class="layui-form-label required">图书列表</label>--%>
        <div class="layui-input-block">
            <div class="demoTable">
                <div class="layui-form-item layui-form ">
                    图书编号：
                    <div class="layui-inline">
                        <input class="layui-input" name="isbn" id="isbn" autocomplete="off">
                    </div>
                    书名：
                    <div class="layui-inline">
                        <input class="layui-input" name="name" id="name" autocomplete="off">
                    </div>
                    图书分类：
                    <div class="layui-inline">
                        <select id="typeId" name="typeId" >
                            <option value="">请选择</option>
                        </select>
                    </div>
                    <button class="layui-btn" data-type="reload">搜索</button>
                </div>
            </div>
            <label class="layui-form-label required">图书列表</label>
            <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        </div>
    </div>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label required">借书卡号</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="text" name="readerNumber" lay-verify="required" lay-reqtext="借书卡不能为空" placeholder="请输入借书卡" value="" class="layui-input">--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认借书</button>
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

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/bookAll.do',//查询类型数据
            toolbar: '#toolbarDemo',
            cols: [[
                {type: "checkbox",fixed: 'left'},
                // {field: 'id', width: 100, title: 'ID', sort: true},
                {field: 'isbn', title: '图书编号',fixed: 'left'},
                {field: 'name', title: '图书名称',fixed: 'left'},
                {templet:'<div>{{d.type.name}}</div>',width:100,title:'图书类型'},
                {field: 'author', title: '作者',fixed: 'left'},
                {field: 'price',  title: '价格',fixed: 'left'},
                {field: 'language', title: '语言',fixed: 'left'},
                {field: 'introduction', title: '介绍',fixed: 'center'},
                // {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,  <!--默认显示15条-->
            page: true,
            skin: 'line',
            id:'testReload',
            response:{
                statusCode:200//规定成功的状态码，默认：0
            }
        });

        //动态获取图书类型的数据，即下拉菜单，跳出图书类型
        $.get("findAllList",{},function (data) {
            console.log(data)
            var list=data.data;
            console.log(list)
            var select=document.getElementById("typeId");
            if(list!=null|| list.size()>0){
                for(var obj in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[obj].id);
                    option.innerText=list[obj].name;
                    console.log(option)
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json")
        //搜索
        var $ = layui.$, active = {
            reload: function(){
                var name = $('#name').val();
                var isbn = $('#isbn').val();
                var typeId = $('#typeId').val();
                console.log(name)
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    },
                    where: {
                        name: name,
                        isbn:isbn,
                        typeId:typeId
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });
        /**
         * 获取选中记录的id信息
         */
        function getCheackId(data){
            var arr=new Array();
            for(var i=0;i<data.length;i++){
                arr.push(data[i].id);
            }
            //拼接id,变成一个字符串
            return arr.join(",");
        };

        form.on('submit(saveBtn)', function (data) {
            console.log(data)
            var datas=data.field;//form单中的数据信息
            var readerNumber=datas.readerNumber;
            var checkStatus=table.checkStatus('testReload').data;
            var idss=getCheackId(checkStatus);

            //向后台发送数据提交添加
            $.ajax({
                url:"${pageContext.request.contextPath}/addLendList",
                type:"POST",
                data:{readerNumber, idss},
                success:function(result){
                    if(result.code==200){//如果成功
                        layer.msg('借阅成功',{
                            icon:6,
                            time:500
                        },function(){
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                        layer.msg("借阅失败");
                    }
                }
            })
            return false;
        });

    })
</script>
</html>
