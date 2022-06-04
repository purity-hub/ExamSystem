package com.lhy.examsystem.controller.myexaming;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.dao.myeximing.MyExamingDao;
import com.lhy.examsystem.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StartExamServlet", value = "/startexam")
public class StartExamServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));//考试id
        HttpSession session = request.getSession();
        session.setAttribute("examId", id);
        ExamDao examDao = new ExamDao();
        Exam exam = new Exam();
        try {
            exam = examDao.getExam(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Timestamp startTime = exam.getStartTime();//开始考试时间
        Timestamp endTime = exam.getEndTime();//结束考试时间
        Timestamp now = new Timestamp(System.currentTimeMillis());//当前时间
        if (now.after(startTime) && now.before(endTime)) {
            request.setAttribute("exam", exam);
            MyExamingDao myExamingDao = new MyExamingDao();
            List<SingleChoice> singleChoices = new ArrayList<>();
            List<MultipleChoice> multipleChoices = new ArrayList<>();
            List<Judgment> judgments = new ArrayList<>();
            List<ShortAnswer> shortAnswers = new ArrayList<>();
            try {
                singleChoices = myExamingDao.getSingleChoiceList(con, id);//获取单选题
                multipleChoices = myExamingDao.getMultipleChoiceList(con, id);//获取多选题
                judgments = myExamingDao.getJudgmentList(con, id);//判断题
                shortAnswers = myExamingDao.getShortAnswerList(con, id);//获取简答题
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("singleChoices", singleChoices);
            request.setAttribute("multipleChoices", multipleChoices);
            request.setAttribute("judgments", judgments);
            request.setAttribute("shortAnswers", shortAnswers);
            request.getRequestDispatcher("startexam.jsp").forward(request, response);
        } else if(now.after(endTime)){
            request.setAttribute("msg", "考试已结束");
            request.getRequestDispatcher("examover.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "考试未开始");
            request.getRequestDispatcher("examover.jsp").forward(request, response);
        }
    }
}
