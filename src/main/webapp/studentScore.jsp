<%@ page import="com.lhy.examsystem.model.UserExam1" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">个人成绩</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>考试名称</th>
                                    <th>用户名</th>
                                    <th>成绩</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<UserExam1> userExamList = (List<UserExam1>) request.getAttribute("userExam1s")!=null?(List<UserExam1>) request.getAttribute("userExam1s"):new ArrayList<UserExam1>();
                                %>
                                <%for(UserExam1 userExam1:userExamList){%>
                                <tr>
                                    <td><%=userExam1.getExamId()%></td>
                                    <td><%=userExam1.getUserId()%></td>
                                    <td><%=userExam1.getMark()%></td>
                                    <td>
                                    </td>
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
</html>
