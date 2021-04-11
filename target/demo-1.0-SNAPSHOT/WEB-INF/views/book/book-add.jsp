<%--
  Created by IntelliJ IDEA.
  User: lsf
  Date: 4/7/21
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>

    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="x-body">
    <form class="layui-form">
        <%--bno--%>
        <div class="layui-form-item">
            <label for="bno" class="layui-form-label">
                <span class="x-red">*</span>序列号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="bno" name="bno" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>书籍的唯一标识ID
            </div>
        </div>
        <%--bname--%>
        <div class="layui-form-item">
            <label for="bname" class="layui-form-label">
                <span class="x-red">*</span>书名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="bname" name="bname" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>书籍名称
            </div>
        </div>
        <%--author--%>
        <div class="layui-form-item">
            <label for="author" class="layui-form-label">
                <span class="x-red">*</span>作者
            </label>
            <div class="layui-input-inline">
                <input type="text" id="author" name="author" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>书籍的作者
            </div>
        </div>
        <%--price--%>
        <div class="layui-form-item">
            <label for="price" class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>书籍的作者
            </div>
        </div>
        <%--publish--%>
        <div class="layui-form-item">
            <label for="publish" class="layui-form-label">
                <span class="x-red">*</span>出版社
            </label>
            <div class="layui-input-inline">
                <input type="text" id="publish" name="publish" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>书籍的作者
            </div>
        </div>
        <%--bookNumber--%>
        <div class="layui-form-item">
            <label for="bookNumber" class="layui-form-label">
                <span class="x-red">*</span>库存量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="bookNumber" name="bookNumber" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>书籍的作者
            </div>
        </div>
        <%--Add Button--%>
        <div class="layui-form-item">
            <label <%--for="L_repass"--%> class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>
</div>

<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //自定义验证规则
        // 表单校验
        form.verify({
            // bno: (value) => {
            //
            // }
            // nikename: function (value) {
            //     if (value.length < 5) {
            //         return '昵称至少得5个字符啊';
            //     }
            // }
            // , pass: [/(.+){6,12}$/, '密码必须6到12位']
            // , repass: function (value) {
            //     if ($('#L_pass').val() != $('#L_repass').val()) {
            //         return '两次密码不一致';
            //     }
            // }
        });
        //监听提交
        form.on('submit(add)', function (data) {
            console.log(data);
            //发异步，把数据提交给servlet
            $.post('${pageContext.request.contextPath}/admin/book?m=addBook', data.field, (data, status, xhr) => {
                console.log("add book success")
            }, 'json')
            layer.alert("增加成功", {icon: 6}, function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });
    });
</script>

</body>