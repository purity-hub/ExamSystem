<%@ page import="com.lhy.examsystem.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.Exam" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/3
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <title>课程信息管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%--添加--%>
<div class="modal fade" id="addCourse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加课程</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addCourse" method="post">
                    <div class="form-group">
                        <label for="courseName" class="col-sm-2 control-label">课程名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="courseName" name="courseName" placeholder="课程名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseType" class="col-sm-2 control-label">课程类型</label>
                        <div class="col-sm-10">
                            <select id="courseType" name="courseType">
                                <option value="0">请选择</option>
                                <option value="必修课">必修课</option>
                                <option value="选修课">选修课</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseCredit" class="col-sm-2 control-label">课程学分</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="courseCredit" name="courseCredit" placeholder="课程学分">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseTime" class="col-sm-2 control-label">课程学时</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="courseTime" name="courseTime" placeholder="课程学时">
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
<%--更新--%>
<div class="modal fade" id="updateCourse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">编辑课程</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>updateCourse" method="post">
                    <div class="form-group">
                        <label for="courseName" class="col-sm-2 control-label">课程名称</label>
                        <div class="col-sm-10">
                            <input type="hidden" class="form-control" id="courseId" name="courseId">
                            <input type="text" class="form-control" id="courseName1" name="courseName" placeholder="课程名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseType" class="col-sm-2 control-label">课程类型</label>
                        <div class="col-sm-10">
                            <select id="courseType1" name="courseType">
                                <option value="0">请选择</option>
                                <option value="必修课">必修课</option>
                                <option value="选修课">选修课</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseCredit" class="col-sm-2 control-label">课程学分</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="courseCredit1" name="courseCredit" placeholder="课程学分">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseTime" class="col-sm-2 control-label">课程学时</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="courseTime1" name="courseTime" placeholder="课程学时">
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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">课程信息管理</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="addCourseButton">添加</button>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>课程编号</th>
                                    <th>课程名称</th>
                                    <th>课程类型</th>
                                    <th>课程学分</th>
                                    <th>课程学时</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                  List<Course> courseList = (List<Course>)request.getAttribute("courses")!=null?(List<Course>)request.getAttribute("courses"):new ArrayList<>();
                                %>
                                <%for(Course course:courseList){%>
                                <tr>
                                  <td><%=course.getId()%></td>
                                  <td><%=course.getName()%></td>
                                  <td><%=course.getType()%></td>
                                  <td><%=course.getCredit()%></td>
                                  <td><%=course.getTime()%></td>
                                <td>
                                  <a href="javascript:void(0)" onclick="editCourse(<%=course.getId()%>)">编辑</a>
                                    <a href="javascript:void(0)" onclick="assign(<%=course.getId()%>)">分配考试</a>
                                  <a href="javascript:void(0)" onclick="deleteCourse(<%=course.getId()%>)">删除</a>
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
<%--提示框更新成功--%>
<div class="modal fade" id="successInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel3">提示</h4>
            </div>
            <div class="modal-body">
                <p>更新成功！</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeInfo()">关闭</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="assignInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel0">分配考试</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addExamCourse" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">试卷</label>
                        <div class="col-sm-10">
                            <input type="hidden" value="" name="courseIdchanged" id="courseIdchanged">
                            <select class="form-control" name="examCourse">
                                <option value="0">请选择试卷</option>
                                <%
                                    List<Exam> examList = (List<Exam>) request.getSession().getAttribute("examList")!=null?
                                            (List<Exam>) request.getSession().getAttribute("examList"):new ArrayList<Exam>();
                                %>
                                <%for(Exam exam:examList){%>
                                <option value="<%=exam.getId()%>"><%=exam.getName()%></option>
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
    $('#addCourseButton').click(function() {
        $('#addCourse').modal('show');
    });
    function editCourse(courseId) {
        $('#updateCourse').modal('show');
        //将当前选择的课程信息传递到模态框中
        $.ajax({
            url: '<%=basePath%>coursebyId',
            data: {
                courseId: courseId
            },
            success: function (data) {
                var course = data.split(",");
                //将数据填充到模态框中
                $('#courseId').val(course[0]);
                $('#courseName1').val(course[1]);
                $('#courseType1').val(course[3]);
                $('#courseCredit1').val(course[4]);
                $('#courseTime1').val(course[5]);
            }
        });
    }
    function deleteCourse(courseId) {
        $.ajax({
            url: '<%=basePath%>deleteCourse',
            data: {
                courseId: courseId
            },
            success: function (data) {
                $('#successInfo').modal('show');
            }
        });
    }
    function closeInfo() {
        $('#successInfo').modal('hide');
        window.location.reload();
    }
    function assign(id) {
        $('#courseIdchanged').val(id);
        $('#assignInfo').modal('show');
    }
</script>
</html>
