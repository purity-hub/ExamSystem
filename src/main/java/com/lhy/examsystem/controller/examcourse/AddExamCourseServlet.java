package com.lhy.examsystem.controller.examcourse;

import com.lhy.examsystem.dao.examcourse.ExamCourseDao;
import com.lhy.examsystem.model.ExamCourse;
import com.lhy.examsystem.model.ExamCourse1;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddExamCourseServlet", value = "/addExamCourse")
public class AddExamCourseServlet extends HttpServlet {
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
        String examCourse = request.getParameter("examCourse");//试卷id
        String courseIdchanged = request.getParameter("courseIdchanged");//课程id
        ExamCourseDao examCourseDao = new ExamCourseDao();
        ExamCourse1 examCourse1 = new ExamCourse1();
        examCourse1.setExamId(Integer.parseInt(examCourse));
        examCourse1.setCourseId(Integer.parseInt(courseIdchanged));
        try {
            examCourseDao.addExamCourse(con, examCourse1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/courseList").forward(request, response);
    }
}
