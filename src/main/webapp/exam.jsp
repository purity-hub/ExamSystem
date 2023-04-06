<%@ page import="com.lhy.examsystem.model.Exam" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/3
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>题库</title>
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
<%--添加试卷--%>
<div class="modal fade" id="addExamModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加试卷</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addExam" method="post">
                    <div class="form-group">
                        <label for="examName" class="col-sm-2 control-label">试卷名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="examName" name="examName" placeholder="请输入试卷名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examTime" class="col-sm-2 control-label">开始考试时间</label>
                        <div class="col-sm-10">
                            <input type="datetime-local" class="form-control" id="startTime" name="startTime" placeholder="请输入开考时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examTime" class="col-sm-2 control-label">考试时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="examTime" name="examTime" placeholder="请输入考试时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="singleTotal" class="col-sm-2 control-label">单选题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="singleTotal" name="singleTotal" placeholder="请输入单选题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="singleScore" class="col-sm-2 control-label">单选题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="singleScore" name="singleScore" placeholder="请输入单选题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="multiTotal" class="col-sm-2 control-label">多选题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="multiTotal" name="multiTotal" placeholder="请输入多选题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="multiScore" class="col-sm-2 control-label">多选题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="multiScore" name="multiScore" placeholder="请输入多选题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="judgeTotal" class="col-sm-2 control-label">判断题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="judgeTotal" name="judgeTotal" placeholder="请输入判断题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="judgeScore" class="col-sm-2 control-label">判断题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="judgeScore" name="judgeScore" placeholder="请输入判断题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fillTotal" class="col-sm-2 control-label">填空题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fillTotal" name="fillTotal" placeholder="请输入填空题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fillScore" class="col-sm-2 control-label">填空题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fillScore" name="fillScore" placeholder="请输入填空题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="totalScore" class="col-sm-2 control-label">计算总分</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="totalScore" name="totalScore" placeholder="请输入总分" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examDesc" class="col-sm-2 control-label">试卷描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" id="examDesc" name="examDesc" placeholder="请输入试卷描述"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateExamModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">编辑试卷</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>updateExam" method="post">
                    <div class="form-group">
                        <label for="examName" class="col-sm-2 control-label">试卷名称</label>
                        <div class="col-sm-10">
                            <input type="hidden" id="examId" name="examId">
                            <input type="text" class="form-control" id="examName1" name="examName" placeholder="请输入试卷名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examTime" class="col-sm-2 control-label">开始考试时间</label>
                        <div class="col-sm-10">
                            <input type="datetime-local" class="form-control" id="startTime1" name="startTime" placeholder="请输入开考时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examTime" class="col-sm-2 control-label">考试时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="examTime1" name="examTime" placeholder="请输入考试时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="singleTotal" class="col-sm-2 control-label">单选题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="singleTotal1" name="singleTotal" placeholder="请输入单选题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="singleScore" class="col-sm-2 control-label">单选题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="singleScore1" name="singleScore" placeholder="请输入单选题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="multiTotal" class="col-sm-2 control-label">多选题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="multiTotal1" name="multiTotal" placeholder="请输入多选题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="multiScore" class="col-sm-2 control-label">多选题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="multiScore1" name="multiScore" placeholder="请输入多选题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="judgeTotal" class="col-sm-2 control-label">判断题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="judgmentTotal1" name="judgmentTotal1" placeholder="请输入判断题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="judgeScore" class="col-sm-2 control-label">判断题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="judgmentScore1" name="judgmentScore1" placeholder="请输入判断题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fillTotal" class="col-sm-2 control-label">填空题个数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="shortTotal1" name="shortTotal1" placeholder="请输入填空题个数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fillScore" class="col-sm-2 control-label">填空题分数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="shortScore1" name="shortScore1" placeholder="请输入填空题分数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="totalScore1" class="col-sm-2 control-label">计算总分</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="totalScore1" name="totalScore1" placeholder="请输入总分" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examDesc" class="col-sm-2 control-label">试卷描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" id="examDesc1" name="examDesc" placeholder="请输入试卷描述"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<h1>题库</h1>
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
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="addExamButton">添加</button>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>试卷编号</th>
                                    <th>试卷名称</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>单选题总数</th>
                                    <th>单选题分数</th>
                                    <th>多选题总数</th>
                                    <th>多选题分数</th>
                                    <th>判断题总数</th>
                                    <th>判断题分数</th>
                                    <th>简答题总数</th>
                                    <th>简答题分数</th>
                                    <th>总分</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<Exam> examList = (List<Exam>)request.getAttribute("exams");
                                %>
                                <%for(Exam exam:examList){%>
                                <tr>
                                    <td><%=exam.getId()%></td>
                                    <td><%=exam.getName()%></td>
                                    <td><%=exam.getStartTime()%></td>
                                    <td><%=exam.getEndTime()%></td>
                                    <td><%=exam.getSingleTotal()%></td>
                                    <td><%=exam.getSingleScore()%></td>
                                    <td><%=exam.getMultipleTotal()%></td>
                                    <td><%=exam.getMultipleScore()%></td>
                                    <td><%=exam.getJudgmentTotal()%></td>
                                    <td><%=exam.getJudgmentScore()%></td>
                                    <td><%=exam.getShortTotal()%></td>
                                    <td><%=exam.getShortScore()%></td>
                                    <td><%=exam.getTotalScore()%></td>
                                    <td>
                                        <a href="javascript:void(0)" onclick="editExam(<%=exam.getId()%>)">编辑</a>
                                        <a href="javascript:void(0)" onclick="deleteExam(<%=exam.getId()%>)">删除</a>
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
<script>
    $('#addExamButton').click(function () {
        $('#addExamModal').modal('show');
    });
    function editExam(examId){
        $('#updateExamModal').modal('show');
        $.ajax({
            url: '<%=basePath%>exambyId',
            type:"post",
            data:{
                examId:examId
            },
            success:function (data) {
                //response.getWriter().write(exam.toString());
                var exam = data.split(",");
                $('#examId').val(exam[0]);
                $('#examName1').val(exam[1]);//试卷名称
                //yyyy-MM-ddThh:mm
                var i = exam[8].substring(0,exam[8].length-11)+"T"+exam[8].substring(exam[8].length-10,exam[8].length-5);
                $('#startTime1').val(i);//开始时间
                $('#examTime1').val(exam[17]);//考试时间
                $('#singleTotal1').val(exam[3]);//单选题总数
                $('#singleScore1').val(exam[11]);//单选题分数
                $('#multiTotal1').val(exam[4]);//多选题总数
                $('#multiScore1').val(exam[12]);//多选题分数
                $('#judgmentTotal1').val(exam[5]);//判断题总数
                $('#judgmentScore1').val(exam[14]);//判断题分数
                $('#shortTotal1').val(exam[6]);//简答题总数
                $('#shortScore1').val(exam[13]);//简答题分数
            }
        });
    }
    function computeTotal(){
        var singleTotal = $('#singleTotal1').val();
        var singleScore = $('#singleScore1').val();
        var multiTotal = $('#multiTotal1').val();
        var multiScore = $('#multiScore1').val();
        var judgmentTotal = $('#judgmentTotal1').val();
        var judgmentScore = $('#judgmentScore1').val();
        var shortTotal = $('#shortTotal1').val();
        var shortScore = $('#shortScore1').val();
        var totalScore = parseInt(singleTotal)*parseInt(singleScore)+parseInt(multiTotal)*parseInt(multiScore)+parseInt(judgmentTotal)*parseInt(judgmentScore)+parseInt(shortTotal)*parseInt(shortScore);
        $('#totalScore1').val(totalScore);
    }
    function deleteExam(examId){
        $.ajax({
            url: '<%=basePath%>deleteExam',
            type:"post",
            data:{
                examId:examId
            },
            success:function (data) {
                $('#successInfo').modal('show');
            }
        });
    }
    function closeInfo() {
        $('#successInfo').modal('hide');
        window.location.reload();
    }
</script>
</body>
</html>
