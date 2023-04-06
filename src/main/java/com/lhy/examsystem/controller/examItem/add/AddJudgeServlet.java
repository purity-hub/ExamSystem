package com.lhy.examsystem.controller.examItem.add;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.Judgment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddJudgeServlet", value = "/addJudge")
public class AddJudgeServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        int examId = (int) session.getAttribute("examId");
        String JudgeId = request.getParameter("JudgeId");
        if(JudgeId == null || JudgeId.equals("")){
            //新增
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            ExamItemDao examItemDao = new ExamItemDao();
            Judgment judgment = new Judgment();
            judgment.setExamId(examId);
            judgment.setQuestion(question);
            judgment.setAnswer(answer);
            try {
                examItemDao.AddJudgment(con, judgment);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/selectExamItem").forward(request, response);
        }else{
            //修改
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            ExamItemDao examItemDao = new ExamItemDao();
            Judgment judgment = new Judgment();
            judgment.setId(Integer.parseInt(JudgeId));
            judgment.setExamId(examId);
            judgment.setQuestion(question);
            judgment.setAnswer(answer);
            try {
                examItemDao.UpdateJudgment(con, judgment);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/selectExamItem").forward(request, response);
        }

    }
}
