package com.lhy.examsystem.controller.assign;

import com.lhy.examsystem.dao.course.CourseDao;
import com.lhy.examsystem.dao.user.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AssignServlet", value = "/assign")
public class AssignServlet extends HttpServlet {
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
        UserDao userDao = new UserDao();
        CourseDao courseDao = new CourseDao();
        int userId = 0;
        List<String> strings = new ArrayList<>();
        try {
            userId = userDao.getUserIdByAccount(con, username);
            strings = courseDao.queryCourseName(con, userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("courseName", strings);
        request.getRequestDispatcher("assign.jsp").forward(request, response);
    }
}
