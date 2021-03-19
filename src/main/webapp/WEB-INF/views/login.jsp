<%--
  Created by IntelliJ IDEA.
  User: lsf
  Date: 3/17/21
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">x-admin2.0-管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input name="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
</div>

<script>
    $(function () {
        layui.use('form', function () {
            let form = layui.form
            form.on('submit(login)', function (data) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/admin/admin?m=login2',
                    type: 'POST',
                    data: data.field,
                    dataType: 'json',
                    success: function (res) {
                        if (res['code'] === 200) {
                            layer.msg(res.message, {icon: 1, time: 1500}, () => {
                                location.href = '${pageContext.request.contextPath}/admin/index?m=mainView'
                            })
                        } else {
                            layer.msg(res.message, {icon: 2, time: 2000})
                        }
                    },
                    error: function () {
                        layer.msg("服务器故障!")
                    }
                })
            })
        })
    })
</script>


<!-- 底部结束 -->

</body>
</html>
