package com.lhy.examsystem.controller.userInfo;

import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UserInfoServlet", value = "/UserInfo")
public class UserInfoServlet extends HttpServlet {
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
        User user = new User();
        String userRole = "";
        try {
            userRole = userDao.getUserRole(con, username);
            user = userDao.getUserByAccount(con, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("userInfo.jsp").forward(request, response);
    }
}
