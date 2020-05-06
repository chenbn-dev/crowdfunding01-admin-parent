<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/5/6
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>出错误了</h1>

    <%-- 从请求域取出Exception对象，再进一步访问message属性就能够显示错误消息 --%>
    ${requestScope.exception.message}
</body>
</html>
