package com.lhy.examsystem.controller.exam;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.model.Exam;
import com.lhy.examsystem.util.TimeUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "UpdateExamServlet", value = "/updateExam")
public class UpdateExamServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examId = request.getParameter("examId");
        String examName = request.getParameter("examName");
        String startTime = request.getParameter("startTime");
        startTime = startTime.replace("T", " ");//开始时间
        startTime = startTime + ":00";
        int examTime = request.getParameter("examTime")!=null?Integer.parseInt(request.getParameter("examTime")):0;
        TimeUtil timeUtil = new TimeUtil();
        String endTime = timeUtil.AddTime(startTime, examTime);
        int singleTotal = request.getParameter("singleTotal")!=null?Integer.parseInt(request.getParameter("singleTotal")):0;
        int singleScore = request.getParameter("singleScore")!=null?Integer.parseInt(request.getParameter("singleScore")):0;
        int multiTotal = request.getParameter("multiTotal")!=null?Integer.parseInt(request.getParameter("multiTotal")):0;
        int multiScore = request.getParameter("multiScore")!=null?Integer.parseInt(request.getParameter("multiScore")):0;
        int judgmentTotal1 = request.getParameter("judgmentTotal1")!=null?Integer.parseInt(request.getParameter("judgmentTotal1")):0;
        int judgmentScore1 = request.getParameter("judgmentScore1")!=null?Integer.parseInt(request.getParameter("judgmentScore1")):0;
        int shortTotal1 = request.getParameter("shortTotal1")!=null?Integer.parseInt(request.getParameter("shortTotal1")):0;
        int shortScore1 = request.getParameter("shortScore1")!=null?Integer.parseInt(request.getParameter("shortScore1")):0;
        String examDesc = request.getParameter("examDesc");
        Exam exam = new Exam();
        exam.setId(Integer.parseInt(examId));
        exam.setName(examName);
        exam.setStartTime(Timestamp.valueOf(startTime));
        exam.setExamTime(Integer.parseInt(String.valueOf(examTime)));
        exam.setEndTime(Timestamp.valueOf(endTime));
        exam.setSingleTotal(singleTotal);
        exam.setSingleScore(singleScore);
        exam.setMultipleTotal(multiTotal);
        exam.setMultipleScore(multiScore);
        exam.setJudgmentTotal(judgmentTotal1);
        exam.setJudgmentScore(judgmentScore1);
        exam.setShortTotal(shortTotal1);
        exam.setShortScore(shortScore1);
        exam.setMiaoshu(examDesc);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        exam.setCreateBy(username);
        int total = singleTotal*singleScore + multiTotal*multiScore + judgmentTotal1*judgmentScore1 + shortTotal1*shortScore1;
        exam.setTotalScore(total);
        try {
            new ExamDao().updateExam(con,exam);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/ExamServlet").forward(request, response);
    }
}
