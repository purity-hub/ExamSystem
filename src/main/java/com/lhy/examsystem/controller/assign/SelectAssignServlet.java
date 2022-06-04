package com.lhy.examsystem.controller.assign;

import com.lhy.examsystem.dao.course.CourseDao;
import com.lhy.examsystem.dao.examcourse.ExamCourseDao;
import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.ExamCourse;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectAssignServlet", value = "/selectAssign")
public class SelectAssignServlet extends HttpServlet {
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
        String courseName = request.getParameter("courseName");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        UserDao userDao = new UserDao();
        CourseDao courseDao = new CourseDao();
        int teacherId = 0;
        int courseId = 0;
        ExamCourse examCourse = new ExamCourse();
        ExamCourseDao examCourseDao = new ExamCourseDao();
        List<ExamCourse> examCourseList = new ArrayList<>();
        try {
            teacherId = userDao.getUserIdByAccount(con, username);
            courseId = courseDao.getId(con,teacherId,courseName);
            examCourseList = examCourseDao.getExamCourse(con, courseId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("examCourseList", examCourseList);
        request.getRequestDispatcher("assign.jsp").forward(request, response);
    }
}
