<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.ExamCourse" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分配考试</title>
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
<h1>已分配考试</h1>
<form action="<%=basePath%>selectAssign" method="post">
    <table border="1" width="100%">
        <tr>
            <td>请选择课程</td>
            <td>
                <select name="courseName">
                    <option value="0">选择课程名字</option>
                    <%--遍历试题类型--%>
                    <%
                        List<String> courseNameList = (List<String>) request.getAttribute("courseName")!=null?(List<String>) request.getAttribute("courseName"):new ArrayList<String>();
                    %>
                    <%
                        for(String courseName : courseNameList){
                    %>
                    <option value="<%=courseName%>"><%=courseName%></option>
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
                    <h3 class="panel-title">分配考试</h3>
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
                                    <th>试卷名称</th>
                                    <th>课程名称</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<ExamCourse> examCourseList = (List<ExamCourse>)request.getAttribute("examCourseList")!=null?(List<ExamCourse>)request.getAttribute("examCourseList"): new ArrayList<>();
                                %>
                                <%for(ExamCourse examCourse:examCourseList){%>
                                <tr>
                                    <td><%=examCourse.getExamId()%></td>
                                    <td><%=examCourse.getCourseId()%></td>
                                    <td>
                                        <a href="javascript:void(0)" onclick="editSingle(<%=examCourse.getId()%>)">编辑</a>
                                        <a href="<%=basePath%>deleteExamCourse?id=<%=examCourse.getId()%>" onclick="deleteSingle(<%=examCourse.getId()%>)">删除</a>
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
