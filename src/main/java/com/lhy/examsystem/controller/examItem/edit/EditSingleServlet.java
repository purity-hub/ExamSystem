package com.lhy.examsystem.controller.examItem.edit;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.SingleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "EditSingleServlet", value = "/EditSingleServlet")
public class EditSingleServlet extends HttpServlet {

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
        SingleChoice singleChoice = new SingleChoice();
        singleChoice.setId(id);
        singleChoice.setExamId(examId);
        singleChoice.setQuestion(question);
        singleChoice.setAChoice(aChoice);
        singleChoice.setBChoice(bChoice);
        singleChoice.setCChoice(cChoice);
        singleChoice.setDChoice(dChoice);
        singleChoice.setAnswer(answer);
        try {
            examItemDao.UpdateSingle(con, singleChoice);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/selectExamItem").forward(request, response);
    }
}
