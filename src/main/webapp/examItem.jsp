<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>题库管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--添加单选题--%>
<div class="modal fade" id="addSingle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加单选题</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addSingle" method="post">
                    <div class="form-group">
                        <label for="question" class="col-sm-2 control-label">问题</label>
                        <div class="col-sm-10">
                            <input type="hidden" name="SingleId" id="SingleId">
                            <input type="text" class="form-control" id="question" name="question" placeholder="问题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="achoice" class="col-sm-2 control-label">选项A</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="achoice" name="achoice" placeholder="选项A">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bchoice" class="col-sm-2 control-label">选项B</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bchoice" name="bchoice" placeholder="选项B">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cchoice" class="col-sm-2 control-label">选项C</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cchoice" name="cchoice" placeholder="选项C">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dchoice" class="col-sm-2 control-label">选项D</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="dchoice" name="dchoice" placeholder="选项D">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer" class="col-sm-2 control-label">答案</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="answer" name="answer" placeholder="答案">
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
<%--添加多选题--%>
<div class="modal fade" id="addMultiple" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">添加多选题</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addMultiple" method="post">
                    <div class="form-group">
                        <label for="question" class="col-sm-2 control-label">问题</label>
                        <div class="col-sm-10">
                            <input type="hidden" name="MultipleId" id="MultipleId">
                            <input type="text" class="form-control" id="question1" name="question" placeholder="问题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="achoice" class="col-sm-2 control-label">选项A</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="achoice1" name="achoice" placeholder="选项A">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bchoice" class="col-sm-2 control-label">选项B</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bchoice1" name="bchoice" placeholder="选项B">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cchoice" class="col-sm-2 control-label">选项C</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cchoice1" name="cchoice" placeholder="选项C">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dchoice" class="col-sm-2 control-label">选项D</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="dchoice1" name="dchoice" placeholder="选项D">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer" class="col-sm-2 control-label">答案</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="answer1" name="answer" placeholder="答案">
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
<%--添加判断题--%>
<div class="modal fade" id="addJudgement" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2">添加判断题</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addJudge" method="post">
                    <div class="form-group">
                        <label for="answer" class="col-sm-2 control-label">问题</label>
                        <div class="col-sm-10">
                            <input type="hidden" name="JudgeId" id="JudgeId">
                            <input type="text" class="form-control" id="question2" name="question" placeholder="问题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="question" class="col-sm-2 control-label">选项</label>
                        <div class="col-sm-10">
                            <input type="radio" class="form-control" id="question21" name="answer" value="对">对
                            <input type="radio" class="form-control" id="question22" name="answer" value="错">错
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
<%--添加简答题--%>
<div class="modal fade" id="addShort" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel3">添加简答题</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="<%=basePath%>addShort" method="post">
                    <div class="form-group">
                        <label for="question" class="col-sm-2 control-label">问题</label>
                        <div class="col-sm-10">
                            <input type="hidden" name="ShortId" id="ShortId">
                            <textarea class="form-control" id="question3" name="question" placeholder="题目"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer" class="col-sm-2 control-label">答案</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="answer3" name="answer" placeholder="答案"></textarea>
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

<form action="<%=basePath%>selectExamItem" method="post">
    <table border="1" width="100%">
        <tr>
            <td>请选择试题类型</td>
            <td>
                <select name="examName">
                    <option value="0">选择试题名字</option>
                    <%--遍历试题类型--%>
                    <%
                        List<String> examNameList = (List<String>) request.getAttribute("examNameList") != null ? (List<String>) request.getAttribute("examNameList") : Collections.emptyList();
                    %>
                    <%
                        for (String examName : examNameList) {
                    %>
                    <option value="<%=examName%>"><%=examName%>
                    </option>
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
                    <h3 class="panel-title">题库信息管理</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                                        id="addSingleButton">添加单选题
                                </button>
                            </div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>单选问题</th>
                                    <th>A</th>
                                    <th>B</th>
                                    <th>C</th>
                                    <th>D</th>
                                    <th>答案</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<SingleChoice> singleChoiceList = (List<SingleChoice>) request.getAttribute("singleChoices") != null ? (List<SingleChoice>) request.getAttribute("singleChoices") : new ArrayList<SingleChoice>();
                                %>
                                <%for (SingleChoice singleChoice : singleChoiceList) {%>
                                <tr>
                                    <td><%=singleChoice.getQuestion()%>
                                    </td>
                                    <td><%=singleChoice.getAChoice()%>
                                    </td>
                                    <td><%=singleChoice.getBChoice()%>
                                    </td>
                                    <td><%=singleChoice.getCChoice()%>
                                    </td>
                                    <td><%=singleChoice.getDChoice()%>
                                    </td>
                                    <td><%=singleChoice.getAnswer()%>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0)"
                                           onclick="editSingle(<%=singleChoice.getId()%>)">编辑</a>
                                        <a href="<%=basePath%>deleteSingle?id=<%=singleChoice.getId()%>"
                                           onclick="deleteSingle(<%=singleChoice.getId()%>)">删除</a>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                                        id="addMultipleButton">添加多选题
                                </button>
                            </div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>多选问题</th>
                                    <th>A</th>
                                    <th>B</th>
                                    <th>C</th>
                                    <th>D</th>
                                    <th>答案</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<MultipleChoice> multipleChoiceList = (List<MultipleChoice>) request.getAttribute("multipleChoices") != null ? (List<MultipleChoice>) request.getAttribute("multipleChoices") : new ArrayList<MultipleChoice>();
                                %>
                                <%for (MultipleChoice multipleChoice : multipleChoiceList) {%>
                                <tr>
                                    <td><%=multipleChoice.getQuestion()%>
                                    </td>
                                    <td><%=multipleChoice.getAChoice()%>
                                    </td>
                                    <td><%=multipleChoice.getBChoice()%>
                                    </td>
                                    <td><%=multipleChoice.getCChoice()%>
                                    </td>
                                    <td><%=multipleChoice.getDChoice()%>
                                    </td>
                                    <td><%=multipleChoice.getAnswer()%>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0)"
                                           onclick="editMultiple(<%=multipleChoice.getId()%>)">编辑</a>
                                        <a href="<%=basePath%>deleteMultiple?id=<%=multipleChoice.getId()%>"
                                           onclick="deleteMultiple(<%=multipleChoice.getId()%>)">删除</a>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                                        id="addJudgmentButton">添加判断题
                                </button>
                            </div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>判断问题</th>
                                    <th>答案</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<Judgment> judgmentList = (List<Judgment>) request.getAttribute("judgments") != null ? (List<Judgment>) request.getAttribute("judgments") : new ArrayList<Judgment>();
                                %>
                                <%for (Judgment judgment : judgmentList) {%>
                                <tr>
                                    <td><%=judgment.getQuestion()%>
                                    </td>
                                    <td><%=judgment.getAnswer()%>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0)"
                                           onclick="editJudgment(<%=judgment.getId()%>)">编辑</a>
                                        <a href="<%=basePath%>deleteJudgment?id=<%=judgment.getId()%>"
                                           onclick="deleteJudgment(<%=judgment.getId()%>)">删除</a>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                                        id="addShortButton">添加简答题
                                </button>
                            </div>
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>简答问题</th>
                                    <th>答案</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--遍历课程信息--%>
                                <%
                                    List<ShortAnswer> shortAnswerList = (List<ShortAnswer>) request.getAttribute("shortAnswers") != null ? (List<ShortAnswer>) request.getAttribute("shortAnswers") : new ArrayList<ShortAnswer>();
                                %>
                                <%for (ShortAnswer shortAnswer : shortAnswerList) {%>
                                <tr>
                                    <td><%=shortAnswer.getQuestion()%>
                                    </td>
                                    <td><%=shortAnswer.getAnswer()%>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0)"
                                           onclick="editShort(<%=shortAnswer.getId()%>)">编辑</a>
                                        <a href="<%=basePath%>deleteShort?id=<%=shortAnswer.getId()%>"
                                           onclick="deleteShort(<%=shortAnswer.getId()%>)">删除</a>
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
<script>
    $('#addSingleButton').click(function () {
        $('#addSingle').modal('show');
    });
    $('#addMultipleButton').click(function () {
        $('#addMultiple').modal('show');
    });
    $('#addJudgmentButton').click(function () {
        $('#addJudgement').modal('show');
    });
    $('#addShortButton').click(function () {
        $('#addShort').modal('show');
    });

    function editSingle(id) {
        $('#addSingle').modal('show');
        $.ajax({
            url: "<%=basePath%>QuerySingle",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                var single = data.split(",");
                $('#addSingle #SingleId').val(single[0]);
                $('#addSingle #question').val(single[2]);
                $('#addSingle #achoice').val(single[3]);
                $('#addSingle #bchoice').val(single[4]);
                $('#addSingle #cchoice').val(single[5]);
                $('#addSingle #dchoice').val(single[6]);
                $('#addSingle #answer').val(single[7]);
            }
        });
    }
    function editMultiple(id){
        $('#addMultiple').modal('show');
        $.ajax({
            url: "<%=basePath%>QueryMultiple",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                var multiple = data.split(",");
                $('#addMultiple #MultipleId').val(multiple[0]);
                $('#addMultiple #question1').val(multiple[2]);
                $('#addMultiple #achoice1').val(multiple[3]);
                $('#addMultiple #bchoice1').val(multiple[4]);
                $('#addMultiple #cchoice1').val(multiple[5]);
                $('#addMultiple #dchoice1').val(multiple[6]);
                $('#addMultiple #answer1').val(multiple[7]);
            }
        });
    }
    function editJudgment(id){
        $('#addJudgement').modal('show');
        $.ajax({
            url: "<%=basePath%>QueryJudgment",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                var judgment = data.split(",");
                $('#addJudgement #JudgeId').val(judgment[0]);
                $('#addJudgement #question2').val(judgment[2]);
                $('#addJudgement #answer2').val(judgment[3]);
            }
        });
    }
    function editShort(id){
        $('#addShort').modal('show');
        $.ajax({
            url: "<%=basePath%>QueryShort",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                var short = data.split(",");
                $('#addShort #ShortId').val(short[0]);
                $('#addShort #question3').val(short[2]);
                $('#addShort #answer3').val(short[3]);
            }
        });
    }
</script>
</body>
</html>
