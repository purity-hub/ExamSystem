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

@WebServlet(name = "ExamNameListServlet", value = "/ExamNameListServlet")
public class ExamNameListServlet extends HttpServlet {
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
        ExamDao examDao = new ExamDao();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<Exam> examList = new ArrayList<>();
        try {
            examList = examDao.getExamList(con, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("examList", examList);
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }
}
