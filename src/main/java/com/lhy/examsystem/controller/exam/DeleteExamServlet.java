package com.lhy.examsystem.controller.exam;

import com.lhy.examsystem.dao.exam.ExamDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DeleteExamServlet", value = "/deleteExam")
public class DeleteExamServlet extends HttpServlet {
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
        String examId = request.getParameter("examId");
        ExamDao examDao = new ExamDao();
        try {
            examDao.deleteExam(con, Integer.parseInt(examId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/ExamServlet").forward(request, response);
    }
}
