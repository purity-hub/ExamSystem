<%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
<%
    int result = (int) request.getAttribute("result");
%>
<h1>您的成绩是<%=result%>分</h1>
<h6>重复提交不记录分数</h6>
</body>
</html>
