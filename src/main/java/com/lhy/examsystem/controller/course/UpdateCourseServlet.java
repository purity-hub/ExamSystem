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

@WebServlet(name = "UpdateCourseServlet", value = "/updateCourse")
public class UpdateCourseServlet extends HttpServlet {

    private Connection con;

    @Override
    public void init(ServletConfig config) throws ServletException {
        con = (Connection) config.getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String courseType = request.getParameter("courseType");
        String courseCredit = request.getParameter("courseCredit");
        String courseTime = request.getParameter("courseTime");
        Course course = new Course();
        course.setId(Long.parseLong(courseId));
        course.setName(courseName);

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        course.setType(courseType);
        course.setCredit(Long.parseLong(courseCredit));
        course.setTime(Long.parseLong(courseTime));
        CourseDao courseDao = new CourseDao();
        UserDao userDao = new UserDao();
        boolean result = false;
        try {
            int userIdByAccount = userDao.getUserIdByAccount(con, username);
            course.setTeacherId(userIdByAccount);
            result = courseDao.updateCourse(con,course);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/courseList").forward(request, response);
    }
}
