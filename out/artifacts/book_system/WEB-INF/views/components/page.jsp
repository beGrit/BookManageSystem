<%--
  Created by IntelliJ IDEA.
  User: lsf
  Date: 4/10/21
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layPage快速使用</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
</head>
<body>
<!--表格-->
<table id="pageContent" class="layui-table" lay-filter="tableList">

</table>
<%--<div id="pageBar"></div>--%>
<script>
    function init() {
        // 初始化渲染
        /*$.ajax({
            url: 'http://localhost:8999/book_system/admin/api/book?m=pageBook&pageIndex=1&pageSize=5',
            type: 'GET',
        }).done(function (json) {
            // 初始化渲染表内容
            layui.use('table', () => {
                const table = layui.table
                let checkStatus = table.checkStatus('bookTable')
                console.log("bookTable", typeof checkStatus)
                console.log(checkStatus.data)
                table.render({
                    id: "bookTable",
                    elem: '#pageContent',
                    height: '312',
                    page: true,
                    cols: [[ // 表头 theade
                        {field: 'bno', title: 'ID', width: 80, fixed: 'left'},
                        {field: 'bname', title: '书籍名', width: 200},
                        {field: 'author', title: '书籍作者',},
                        {field: 'price', title: '单品价格',},
                        {field: 'publish', title: '出版社'},
                        {field: 'bookNumber', title: '书籍数量'},
                    ]],
                    data: json.data.pageContentInfo.data,
                    limit: json.data.pageContentInfo.pageSize,
                })
            })
            /!*
            layui.use('laypage', function () {
                var laypage = layui.laypage;
                //执行一个laypage实例
                laypage.render({
                    elem: 'pageBar', //注意，这里的 test1 是 ID，不用加 # 号
                    count: json.data.pageBar.totalRecords, //数据总数，从服务端得到
                    limit: json.data.pageContentInfo.pageSize,
                    curr: json.data.pageBar.curPageIndex,
                });
            })
            *!/
        })*/
    }

    layui.use('table', () => {
        const table = layui.table
        // let checkStatus = table.checkStatus('bookTable')
        // console.log("bookTable", typeof checkStatus)
        // console.log(checkStatus.data)
        table.render({
            id: "bookTable",
            elem: '#pageContent',
            height: '312',
            page: true,
            cols: [[ // 表头 theade
                {field: 'bno', title: 'ID', width: 80, fixed: 'left'},
                {field: 'bname', title: '书籍名', width: 200},
                {field: 'author', title: '书籍作者',},
                {field: 'price', title: '单品价格',},
                {field: 'publish', title: '出版社'},
                {field: 'bookNumber', title: '书籍数量'},
            ]],

            // 数据获取
            url: 'http://localhost:8999/book_system/admin/api/book?m=pageBook',
            request: {
                pageName: 'pageIndex',
                limitName: 'pageSize',
            },
            parseData: function (res) {
                return {
                    'code': res.code,
                    'msg': res.msg,
                    'count': res.pageBar.totalRecords,
                    'data': res.pageContentInfo.data,
                }
            },

            // 渲染后函数回调
            done: function (res, curr, count) {
                console.log('done:', res, count)
            }
        })
    })
    // init()
    let selector = document.querySelector('#test1')
    console.log(r)
</script>
</body>
</html>

