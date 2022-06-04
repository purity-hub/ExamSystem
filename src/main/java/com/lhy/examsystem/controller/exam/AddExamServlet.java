package com.lhy.examsystem.controller.exam;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.model.Exam;
import com.lhy.examsystem.util.TimeUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

@WebServlet(name = "AddExamServlet", value = "/addExam")
public class AddExamServlet extends HttpServlet {
    private Connection con;

    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examName = request.getParameter("examName");
        String startTime = request.getParameter("startTime");
        startTime = startTime.replace("T", " ");//开始时间
        startTime = startTime + ":00";
        String examTime = request.getParameter("examTime");//考试时间
        TimeUtil timeUtil = new TimeUtil();
        String endTime = timeUtil.AddTime(startTime, Integer.parseInt(examTime));
        int singleTotal = request.getParameter("singleTotal")!=null?Integer.parseInt(request.getParameter("singleTotal")):0;
        int singleScore = request.getParameter("singleScore")!=null?Integer.parseInt(request.getParameter("singleScore")):0;
        int multiTotal = request.getParameter("multiTotal")!=null?Integer.parseInt(request.getParameter("multiTotal")):0;
        int multiScore = request.getParameter("multiScore")!=null?Integer.parseInt(request.getParameter("multiScore")):0;
        int judgeTotal = request.getParameter("judgeTotal")!=null?Integer.parseInt(request.getParameter("judgeTotal")):0;
        int judgeScore = request.getParameter("judgeScore")!=null?Integer.parseInt(request.getParameter("judgeScore")):0;
        int fillTotal = request.getParameter("fillTotal")!=null?Integer.parseInt(request.getParameter("fillTotal")):0;
        int fillScore = request.getParameter("fillScore")!=null?Integer.parseInt(request.getParameter("fillScore")):0;
        String examDesc = request.getParameter("examDesc")!=null?request.getParameter("examDesc"):"";
        Exam exam = new Exam();
        exam.setName(examName);
        exam.setStartTime(Timestamp.valueOf(startTime));
        exam.setExamTime(Integer.parseInt(examTime));
        exam.setEndTime(Timestamp.valueOf(endTime));
        exam.setSingleTotal(singleTotal);
        exam.setSingleScore(singleScore);
        exam.setMultipleTotal(multiTotal);
        exam.setMultipleScore(multiScore);
        exam.setJudgmentTotal(judgeTotal);
        exam.setJudgmentScore(judgeScore);
        exam.setShortTotal(fillTotal);
        exam.setShortScore(fillScore);
        exam.setMiaoshu(examDesc);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        exam.setCreateBy(username);
        int total = singleTotal*singleScore + multiTotal*multiScore + judgeTotal*judgeScore + fillTotal*fillScore;
        exam.setTotalScore(total);
        ExamDao examDao = new ExamDao();
        boolean b = examDao.addExam(con, exam);
        request.getRequestDispatcher("/ExamServlet").forward(request, response);
    }
}
