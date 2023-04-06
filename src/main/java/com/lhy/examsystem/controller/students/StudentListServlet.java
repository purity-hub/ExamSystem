package com.lhy.examsystem.controller.students;

import com.lhy.examsystem.dao.students.StudentsDao;
import com.lhy.examsystem.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentListServlet", value = "/StudentListServlet")
public class StudentListServlet extends HttpServlet {

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
        StudentsDao studentsDao = new StudentsDao();
        try {
            List<User> studentsList = studentsDao.getStudentsList(con);
            request.setAttribute("studentsList", studentsList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
}
