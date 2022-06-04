package com.lhy.examsystem.controller.examItem.add;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.ShortAnswer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddShortServlet", value = "/addShort")
public class AddShortServlet extends HttpServlet {
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
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        ExamItemDao examItemDao = new ExamItemDao();
        ShortAnswer shortAnswer = new ShortAnswer();
        shortAnswer.setExamId(examId);
        shortAnswer.setQuestion(question);
        shortAnswer.setAnswer(answer);
        try {
            examItemDao.AddShort(con, shortAnswer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/selectExamItem").forward(request, response);
    }
}
