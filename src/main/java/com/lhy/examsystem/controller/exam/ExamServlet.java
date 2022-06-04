package com.lhy.examsystem.controller.exam;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.model.Exam;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExamServlet", value = "/ExamServlet")
public class ExamServlet extends HttpServlet {
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
        String username = (String) session.getAttribute("username");
        ExamDao examDao = new ExamDao();
        List<Exam> exams = new ArrayList<>();
        try {
            exams = examDao.getExamList(con, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("exams", exams);
        request.getRequestDispatcher("exam.jsp").forward(request, response);
    }
}
