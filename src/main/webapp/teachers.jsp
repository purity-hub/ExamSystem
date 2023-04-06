<%@ page import="com.lhy.examsystem.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.Exam" %>
<%@ page import="com.lhy.examsystem.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
  <title>学生信息管理</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
  <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">学生信息管理</h3>
        </div>
        <div class="panel-body">
          <div class="row">
            <div class="col-md-12">
              <div class="pull-right">

              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <table class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>用户名</th>
                  <th>密码</th>
                  <th>姓名</th>
                  <th>性别</th>
                  <th>年龄</th>
                  <th>电话</th>
                </tr>
                </thead>
                <tbody>
                <%--遍历课程信息--%>
                <%
                  List<User> teachersList = (List<User>)request.getAttribute("teachersList")!=null?(List<User>)request.getAttribute("teachersList"):new ArrayList<>();
                %>
                <%for(User user:teachersList){%>
                <tr>
                  <td><%=user.getAccount()%></td>
                  <td><%=user.getPassword()%></td>
                  <td><%=user.getName()%></td>
                  <td><%=user.getGender()%></td>
                  <td><%=user.getAge()%></td>
                  <td><%=user.getPhone()%></td>
                </tr>
                <%}%>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
<script>

</script>
</html>
