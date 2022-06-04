<%@ page import="com.lhy.examsystem.model.User" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/2
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h1>用户信息展示</h1>
        <%
            User user = (User) request.getAttribute("user");
            String userGender = "";
            String userRole = "";
            if(user.getGender()==1) {
                userGender = "男";
            }else {
                userGender = "女";
            }
            if(Objects.equals(user.getUserRole(), "admin")){
                userRole = "管理员";
            } else if (Objects.equals(user.getUserRole(), "teacher")) {
                userRole = "教师";
            } else if(Objects.equals(user.getUserRole(), "student")) {
                userRole = "学生";
            } else {
                userRole = "未知";
            }
        %>
<div>
    <p class="fs-3">用户名: ${user.account}</p> <br>
    <p class="fs-3">密码: ${user.password}</p> <br>
    <p class="fs-3">用户类型: <%=userRole%></p> <br>
    <p class="fs-3">姓名: ${user.name}</p> <br>
    <p class="fs-3">性别: <%=userGender%></p> <br>
    <p class="fs-3">年龄: ${user.age}</p> <br>
    <p class="fs-3">联系电话: ${user.phone}</p> <br>
</div>
</body>
</html>
