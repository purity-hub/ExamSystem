package com.lhy.examsystem.controller.userexam;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.dao.userexam.UserExamDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryscoreServlet", value = "/queryscore")
public class QueryscoreServlet extends HttpServlet {
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
        UserExamDao userExamDao = new UserExamDao();
        ExamDao examDao = new ExamDao();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<String> examNameList = new ArrayList<>();
        try {
            examNameList = examDao.getExamNameList(con, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("examNameList", examNameList);
        request.getRequestDispatcher("score.jsp").forward(request, response);
    }
}
