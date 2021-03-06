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
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input class="layui-input" placeholder="开始日" name="start" id="start">
            <input class="layui-input" placeholder="截止日" name="end" id="end">
            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn"
                onclick="x_admin_show('Add_Book','${pageContext.request.contextPath}/admin/index?m=addBookView')"><i
                class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock>
    <%--分页内容PageContent--%>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
                    <i>
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>序列号</th>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>出版社</th>
            <th>库存量</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:if test="${!empty pageContent.data }">
            <c:forEach items="${pageContent.data}" var="book">
                <tr>
                    <td>
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i
                                class="layui-icon">&#xe605;</i>
                        </div>
                    </td>
                    <td>${book.bno}</td>
                    <td>${book.bname}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.publish}</td>
                    <td>${book.bookNumber}</td>
                    <td class="td-manage">
                        <a onclick="member_stop(this,'10001')" href="javascript:;" title="启用">
                            <i class="layui-icon">&#xe601;</i>
                        </a>
                        <a title="编辑" onclick="x_admin_show('编辑','adminUser-edit.html')" href="javascript:;">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <%--分页条PageBar--%>
    <div class="page">
        <div>
            <a class="prev"
               href="${pageContext.request.contextPath}/admin/book?m=bookList&pageIndex=${pageBar.prePageIndex}">&lt;&lt;</a>
            <c:forEach items="${pageBar.declaredIndexList}" var="index">
                <c:if test="${ index == pageBar.curPageIndex}">
                    <span class="current">${index}</span>
                </c:if>
                <c:if test="${ index != pageBar.curPageIndex}">
                    <a class="num"
                       href="${pageContext.request.contextPath}/admin/book?m=bookList&pageIndex=${index}">${index}</a>
                </c:if>
            </c:forEach>
            <a class="next"
               href="${pageContext.request.contextPath}/admin/book?m=bookList&pageIndex=${pageBar.nextPageIndex}">&gt;&gt;</a>
        </div>
    </div>
    <%--表格--%>
    <table id="demo" lay-filter="tableList">
    </table>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    layui.use('table', () => {
        let table = layui.table
/*        table.render({
            elem: '#demo',
            height: '312',
            url: '${pageContext.request.contextPath}/admin/book?m=bookList', // 数据接口,
            page: true,
            cols: [[ // 表头 theade
                {field: 'bno', title: 'ID', width: 80, sort: true, fixed: 'left'},
                {field: 'bname', title: '书籍名', width: 200},
                {field: 'author', title: '书籍作者',},
                {field: 'price', title: '单品价格',},
                {field: 'publish', title: '出版社'},
                {field: 'bookNumber', title: '书籍数量'},
            ]],
            parseData: (res) => {
            }
        })*/
    })

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {

            if ($(obj).attr('title') == '启用') {

                //发异步把用户状态进行更改
                $(obj).attr('title', '停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!', {icon: 5, time: 1000});

            } else {
                $(obj).attr('title', '启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!', {icon: 5, time: 1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

    function delAll(argument) {
        let data = tableCheck.getCheckedBooks();
        // json序列化
        layer.confirm(data + '确认要删除吗？', function (index) {
            //捉到所有被选中的，发异步进行删除
            $.ajax({
                url: 'http://localhost:8999/book_system/admin/api/book?m=deleteByIdList',
                type: 'POST',
                dataType : "json",
                data: "ids=" + data,
                success: (res) => {
                    if (res.code = 200) {

                    }
                }
            })
            layer.msg('删除成功', {icon: 1});

            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }

</script>
</body>
</html>