package com.lhy.examsystem.controller.teacher;

import com.lhy.examsystem.dao.teacher.TeacherDao;
import com.lhy.examsystem.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TeacherListServlet", value = "/TeacherListServlet")
public class TeacherListServlet extends HttpServlet {

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
        TeacherDao teacherDao = new TeacherDao();
        try {
            List<User> teachersList = teacherDao.getTeacherList(con);
            request.setAttribute("teachersList", teachersList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("teachers.jsp").forward(request, response);
    }
}
