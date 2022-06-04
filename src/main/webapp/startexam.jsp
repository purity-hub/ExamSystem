<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.*" %><%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/4
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<%
    Exam exam = (Exam) request.getAttribute("exam");
%>
<head>
    <title><%=exam.getName()%>考试</title>
</head>
<body>
<h2><%=exam.getName()%></h2>
<h5>考试时间：<%=exam.getStartTime()%>-<%=exam.getEndTime()%></h5>
<h5>考试时长：<%=exam.getExamTime()%>分钟</h5>
<%
    List<SingleChoice> singleChoices = (List<SingleChoice>) request.getAttribute("singleChoices")!=null?(List<SingleChoice>) request.getAttribute("singleChoices"):new ArrayList<>();
    List<MultipleChoice> multipleChoices = (List<MultipleChoice>) request.getAttribute("multipleChoices")!=null?(List<MultipleChoice>) request.getAttribute("multipleChoices"):new ArrayList<>();
    List<Judgment> judgments = (List<Judgment>) request.getAttribute("judgments")!=null?(List<Judgment>) request.getAttribute("judgments"):new ArrayList<>();
    List<ShortAnswer> shortAnswers = (List<ShortAnswer>) request.getAttribute("shortAnswers")!=null?(List<ShortAnswer>) request.getAttribute("shortAnswers"):new ArrayList<>();
%>
<form class="form-horizontal" role="form" action="<%=basePath%>submitExam" method="post">
    <h3>单选题</h3>
    <%
        for (SingleChoice singleChoice : singleChoices) {
    %>
    <div class="form-group">
        <label class="col-sm-2 control-label"><%=singleChoice.getQuestion()%></label>
        <div class="col-sm-10">
            <label class="radio-inline">
                <input type="radio" name="singleChoice<%=singleChoice.getId()%>" value="A">A.<%=singleChoice.getAChoice()%>
            </label>
            <label class="radio-inline">
                <input type="radio" name="singleChoice<%=singleChoice.getId()%>" value="B">B.<%=singleChoice.getBChoice()%>
            </label>
            <label class="radio-inline">
                <input type="radio" name="singleChoice<%=singleChoice.getId()%>" value="C">C.<%=singleChoice.getCChoice()%>
            </label>
            <label class="radio-inline">
                <input type="radio" name="singleChoice<%=singleChoice.getId()%>" value="D">D.<%=singleChoice.getDChoice()%>
            </label>
        </div>
    </div>
    <br>
    <%
        }
    %>
    <h3>多选题</h3>
    <%
        for (MultipleChoice multipleChoice : multipleChoices) {
    %>
    <div class="form-group">
        <label class="col-sm-2 control-label"><%=multipleChoice.getQuestion()%></label>
        <div class="col-sm-10">
            <label class="checkbox-inline">
                <input type="checkbox" name="multipleChoice<%=multipleChoice.getId()%>" value="A">A.<%=multipleChoice.getAChoice()%>
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="multipleChoice<%=multipleChoice.getId()%>" value="B">B.<%=multipleChoice.getBChoice()%>
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="multipleChoice<%=multipleChoice.getId()%>" value="C">C.<%=multipleChoice.getCChoice()%>
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="multipleChoice<%=multipleChoice.getId()%>" value="D">D.<%=multipleChoice.getDChoice()%>
            </label>
        </div>
    </div>
    <br>
    <%
        }
    %>
    <h3>判断题</h3>
    <%
        for (Judgment judgment : judgments) {
    %>
    <div class="form-group">
        <label class="col-sm-2 control-label"><%=judgment.getQuestion()%></label>
        <div class="col-sm-10">
            <label class="radio-inline">
                <input type="radio" name="judgment<%=judgment.getId()%>" value="T">对
            </label>
            <label class="radio-inline">
                <input type="radio" name="judgment<%=judgment.getId()%>" value="F">错
            </label>
        </div>
    </div>
    <br>
    <%
        }
    %>
    <h3>简答题</h3>
    <%
        for (ShortAnswer shortAnswer : shortAnswers) {
    %>
    <div class="form-group">
        <label class="col-sm-2 control-label"><%=shortAnswer.getQuestion()%></label>
        <div class="col-sm-10">
            <textarea class="form-control" rows="3" name="shortAnswer<%=shortAnswer.getId()%>"></textarea>
        </div>
    </div>
    <br>
    <%
        }
    %>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">提交</button>
    </div>
</form>
</body>
</html>
