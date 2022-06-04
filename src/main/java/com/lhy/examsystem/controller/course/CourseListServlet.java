package com.lhy.examsystem.controller.course;

import com.lhy.examsystem.dao.course.CourseDao;
import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.Course;
import com.lhy.examsystem.model.Exam;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CourseServlet", value = "/courseList")
public class CourseListServlet extends HttpServlet {
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
        CourseDao courseDao = new CourseDao();
        UserDao userDao = new UserDao();
        String userRole = "";
        List<Course> courses = new ArrayList<>();
        try {
            userRole = userDao.getUserRole(con, username);
            if(userRole.equals("teacher") || userRole.equals("admin")) {
                int userIdByAccount = userDao.getUserIdByAccount(con, username);
                courses = courseDao.queryCourse(con, userIdByAccount);
            } else if (userRole.equals("student")){

            } else{

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("courses", courses);
        ExamDao examDao = new ExamDao();
        List<Exam> examList = new ArrayList<>();
        try {
            examList = examDao.getExamList(con, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("examList", examList);
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }
}
