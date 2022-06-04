<%@ page import="com.lhy.examsystem.model.Exam" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试列表</title>
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
                    <h3 class="panel-title">考试列表</h3>
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
                                    <th>考试编号</th>
                                    <th>考试名称</th>
                                    <th>所属课程</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>考试时长</th>
                                    <th>总分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    List<Exam> examList = (List<Exam>)request.getAttribute("examingList")!=null?(List<Exam>)request.getAttribute("examingList"):new ArrayList<Exam>();
                                %>
                                <%for(Exam exam:examList){%>
                                <tr>
                                    <td><%=exam.getId()%></td>
                                    <td><%=exam.getName()%></td>
                                    <td><%=exam.getCourseName()%></td>
                                    <td><%=exam.getStartTime()%></td>
                                    <td><%=exam.getEndTime()%></td>
                                    <td><%=exam.getExamTime()%></td>
                                    <td><%=exam.getTotalScore()%></td>
                                    <td>
                                        <a href="<%=basePath%>startexam?id=<%=exam.getId()%>">进入考试</a>
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
