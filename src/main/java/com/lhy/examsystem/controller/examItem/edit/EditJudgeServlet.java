package com.lhy.examsystem.controller.examItem.edit;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.Judgment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "EditJudgeServlet", value = "/EditJudgeServlet")
public class EditJudgeServlet extends HttpServlet {

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
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        int examId = request.getParameter("examId") == null ? 0 : Integer.parseInt(request.getParameter("examId"));
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        ExamItemDao examItemDao = new ExamItemDao();
        Judgment judgment = new Judgment();
        judgment.setId(id);
        judgment.setExamId(examId);
        judgment.setQuestion(question);
        judgment.setAnswer(answer);
        try {
            examItemDao.UpdateJudgment(con, judgment);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
