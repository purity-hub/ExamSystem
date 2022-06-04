package com.lhy.examsystem.controller.userexam;

import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.dao.userexam.UserExamDao;
import com.lhy.examsystem.model.UserExam1;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentScoreServlet", value = "/studentScore")
public class StudentScoreServlet extends HttpServlet {
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
        UserExamDao userExamDao = new UserExamDao();
        UserDao userDao = new UserDao();
        List<UserExam1> userExam1s = new ArrayList<>();
        try {
            int userIdByAccount = userDao.getUserIdByAccount(con, username);
            userExam1s = userExamDao.queryUserExam1(con, userIdByAccount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("userExam1s", userExam1s);
        request.getRequestDispatcher("studentScore.jsp").forward(request, response);
    }
}
