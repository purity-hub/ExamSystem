<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.User" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程人员分配</title>
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
<form action="<%=basePath%>selectCoursePeople" method="post">
    <table border="1" width="100%">
        <tr>
            <td>请选择试题类型</td>
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
                                    <th>用户编号</th>
                                    <th>用户名</th>
                                    <th>密码</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>联系电话</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<User> userList = (List<User>)request.getAttribute("userByCourse")!=null?(List<User>)request.getAttribute("userByCourse"):new ArrayList<User>();
                                %>
                                <%for(User user:userList){%>
                                <tr>
                                    <td><%=user.getId()%></td>
                                    <td><%=user.getAccount()%></td>
                                    <td><%=user.getPassword()%></td>
                                    <td><%=user.getName()%></td>
                                    <td><%=user.getGender()%></td>
                                    <td><%=user.getAge()%></td>
                                    <td><%=user.getPhone()%></td>
                                    <td>
                                        <a href="<%=basePath%>deleteUserCourse?id=<%=user.getId()%>">删除</a>
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
<div class="modal fade" id="UserCourseInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel0">分配考试</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addUserCourse" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">添加课程人员</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="userId">
                                <%--遍历课程信息--%>
                                <%
                                    List<User> allStudents = (List<User>) request.getSession().getAttribute("allStudents")!=null?(List<User>) request.getSession().getAttribute("allStudents"):new ArrayList<User>();
                                %>
                                <%for(User user:allStudents){%>
                                <option value="<%=user.getId()%>"><%=user.getName()%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $('#addStudentButton').click(function(){
        $('#UserCourseInfo').modal('show');
    });
</script>
</html>
