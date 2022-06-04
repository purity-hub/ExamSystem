package com.lhy.examsystem.controller.course;

import com.lhy.examsystem.dao.course.CourseDao;
import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.Course;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddCourseServlet", value = "/addCourse")
public class AddCourseServlet extends HttpServlet {
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
        String name = request.getParameter("courseName");
        String type = request.getParameter("courseType");
        String credit = request.getParameter("courseCredit");
        String time = request.getParameter("courseTime");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        UserDao userDao = new UserDao();
        CourseDao courseDao = new CourseDao();
        Course course = new Course();
        course.setName(name);
        course.setType(type);
        course.setCredit(Long.parseLong(credit));
        course.setTime(Long.parseLong(time));
        int teacherId = 0;
        boolean b = false;
        try {
            teacherId = userDao.getUserIdByAccount(con, username);
            course.setTeacherId(teacherId);
            b = courseDao.addCourse(con, course);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (b) {
            request.getRequestDispatcher("/courseList").forward(request, response);
        }
    }
}
