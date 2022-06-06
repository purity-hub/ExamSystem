<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lhy.examsystem.model.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %><%--
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
<%
    long current_time=System.currentTimeMillis();//系统时间
    Timestamp end_time=exam.getEndTime();//考试结束时间
    long left_time=end_time.getTime()-current_time;
    int left_second=(int) (left_time/1000);
    //将秒数转换为小时、分钟、秒
    int hour=left_second/3600;
    int minute=(left_second-hour*3600)/60;
    int second=left_second-hour*3600-minute*60;
    String time_left=hour+":"+minute+":"+second;
%>
<head>
    <title><%=exam.getName()%>考试</title>
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
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
<div class="float-right">
    <p id="time">倒计时:<%=time_left%></p>
</div>
<br>
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
        <button type="submit" class="btn btn-primary" id="submit">提交</button>
    </div>
</form>
<style>
    .float-right {
        position: fixed;
        right: 0;
        top: 0;
        z-index: 10;
    }
</style>
<script>
    //倒计时实时改变时间
    var timerCount= window.setTimeout("changeTime()",1000);
    function changeTime() {
        //获取剩余的时间是服务器端的时间
        var time = $("#time").text();
        var timeArray = time.split(":");
        var hour = timeArray[0];
        var minute = timeArray[1];
        var second = timeArray[2];
        second--;
        if (second < 0) {
            second = 59;
            minute--;
        }
        if (minute < 0) {
            minute = 59;
            hour--;
        }
        if (hour < 0) {
            hour = 0;
            minute = 0;
            second = 0;
        }
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minute < 10) {
            minute = "0" + minute;
        }
        if (second < 10) {
            second = "0" + second;
        }
        var newTime = hour + ":" + minute + ":" + second;
        document.getElementById("time").innerHTML=newTime;
        if(hour===0&&minute===0&&second===0){
            window.clearTimeout(timerCount);
            $("#submit").click();
        }else{
            timerCount=window.setTimeout("changeTime()",1000);
        }
    }
</script>
</body>
</html>
