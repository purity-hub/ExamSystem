<%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试失败页面</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg")!=null?(String) request.getAttribute("msg"):"";
%>

<h1><%=msg%></h1>
</body>
</html>
