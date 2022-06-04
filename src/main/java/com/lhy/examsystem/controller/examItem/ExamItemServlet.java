package com.lhy.examsystem.controller.examItem;

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

@WebServlet(name = "ExamItemServlet", value = "/examItem")
public class ExamItemServlet extends HttpServlet {
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
        List<String> examNameList = new ArrayList<>();
        try {
            examNameList = examDao.getExamNameList(con, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("examNameList", examNameList);
        request.getRequestDispatcher("examItem.jsp").forward(request, response);
    }
}
