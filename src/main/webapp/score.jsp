<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.Exam" %>
<%@ page import="com.lhy.examsystem.model.UserExam1" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩</title>
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
<form action="<%=basePath%>selectUserExam" method="post">
    <table border="1" width="100%">
        <tr>
            <td>请选择试题名称</td>
            <td>
                <select name="examName">
                    <option value="0">选择试卷名称</option>
                    <%--遍历试题类型--%>
                    <%
                        List<String> examNameList = (List<String>) request.getAttribute("examNameList")!=null?(List<String>) request.getAttribute("examNameList"):new ArrayList<String>();
                    %>
                    <%
                        for(String examName : examNameList){
                    %>
                    <option value="<%=examName%>"><%=examName%></option>
                    <%
                        }
                    %>
                    }
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="查询">
            </td>
        </tr>
    </table>
</form>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">课程人员信息管理</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="addStudentButton">添加学生</button>
                            </div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>考试名称</th>
                                    <th>用户名</th>
                                    <th>成绩</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<UserExam1> userExamList = (List<UserExam1>) request.getAttribute("userExamList")!=null?(List<UserExam1>) request.getAttribute("userExamList"):new ArrayList<UserExam1>();
                                %>
                                <%for(UserExam1 userExam1:userExamList){%>
                                <tr>
                                    <td><%=userExam1.getExamId()%></td>
                                    <td><%=userExam1.getUserId()%></td>
                                    <td><%=userExam1.getMark()%></td>
                                    <td>

                                        <a href="<%=basePath%>deleteUserExam?id=<%=userExam1.getId()%>">删除</a>
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
