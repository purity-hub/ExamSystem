package com.lhy.examsystem.controller.myexaming;

import com.lhy.examsystem.dao.myeximing.MyExamingDao;
import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.Exam;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyExamingServlet", value = "/myexaming")
public class MyExamingServlet extends HttpServlet {
    private Connection con;

    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        UserDao userDao = new UserDao();
        MyExamingDao myExamingDao = new MyExamingDao();
        List<Exam> examingList = new ArrayList<>();
        try {
            int userId = userDao.getUserIdByAccount(con, username);
            examingList = myExamingDao.getExamingList(con, userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("examingList", examingList);
        request.getRequestDispatcher("myexaming.jsp").forward(request, response);
    }
}
