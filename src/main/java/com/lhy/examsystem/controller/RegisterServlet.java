package com.lhy.examsystem.controller;

import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
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
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        String userrole = request.getParameter("userrole");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age")!=null?request.getParameter("age"):"0");
//        Date date = new Date();//获得系统时间.
//        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        String nowTime = sdf.format(date);
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setUserRole(userrole);
        user.setName(name);
        user.setGender(Integer.parseInt(gender));
        user.setPhone(phone);
        user.setAge(age);
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        user.setCreateTime(nowTime);
        UserDao userDao = new UserDao();
        boolean result;
        try {
            result = userDao.register(con,user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(result){
            request.setAttribute("username",account);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/login").forward(request,response);
        }
    }
}
