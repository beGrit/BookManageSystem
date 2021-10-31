<%--
  Created by IntelliJ IDEA.
  User: lsf
  Date: 4/14/21
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500 服务器异常</title>
</head>
<body>
${pageContext.getException().getMessage()}
</body>
</html>
