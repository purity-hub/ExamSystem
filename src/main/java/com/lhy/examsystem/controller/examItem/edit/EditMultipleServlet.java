package com.lhy.examsystem.controller.examItem.edit;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.MultipleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "EditMultipleServlet", value = "/EditMultipleServlet")
public class EditMultipleServlet extends HttpServlet {

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
        String aChoice = request.getParameter("aChoice");
        String bChoice = request.getParameter("bChoice");
        String cChoice = request.getParameter("cChoice");
        String dChoice = request.getParameter("dChoice");
        String answer = request.getParameter("answer");
        ExamItemDao examItemDao = new ExamItemDao();
        MultipleChoice multipleChoice = new MultipleChoice();
        multipleChoice.setId(id);
        multipleChoice.setExamId(examId);
        multipleChoice.setQuestion(question);
        multipleChoice.setAChoice(aChoice);
        multipleChoice.setBChoice(bChoice);
        multipleChoice.setCChoice(cChoice);
        multipleChoice.setDChoice(dChoice);
        multipleChoice.setAnswer(answer);
        try {
            examItemDao.UpdateMultiple(con, multipleChoice);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
