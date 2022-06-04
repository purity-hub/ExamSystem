package com.lhy.examsystem.controller.course;

import com.lhy.examsystem.dao.course.CourseDao;
import com.lhy.examsystem.model.Course;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "QueryCourseServlet", value = "/coursebyId")
public class QueryCourseServlet extends HttpServlet {
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
        String courseId = request.getParameter("courseId");
        CourseDao courseDao = new CourseDao();
        Course course = new Course();
        try {
            course = courseDao.queryCourseById(con, Integer.parseInt(courseId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(course.toString());
    }
}
