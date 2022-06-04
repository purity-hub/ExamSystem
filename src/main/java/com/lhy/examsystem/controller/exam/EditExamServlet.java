package com.lhy.examsystem.controller.exam;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.model.Exam;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "EditExamServlet", value = "/exambyId")
public class EditExamServlet extends HttpServlet {

    private Connection con;

    @Override
    public void init(ServletConfig config) throws ServletException {
        con = (Connection) config.getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examId = request.getParameter("examId");
        ExamDao examDao = new ExamDao();
        Exam exam = new Exam();
        try {
            exam = examDao.getExam(con, Integer.parseInt(examId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(exam.toString());
    }
}
