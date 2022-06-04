package com.lhy.examsystem.controller.usercourse;

import com.lhy.examsystem.dao.usercourse.UserCourseDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddUserCourseServlet", value = "/addUserCourse")
public class AddUserCourseServlet extends HttpServlet {
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
        int userId = Integer.parseInt(request.getParameter("userId"));//用户id
        HttpSession session = request.getSession();
        int courseId = (int) session.getAttribute("courseId");//课程id
        UserCourseDao userCourseDao = new UserCourseDao();
        try {
            userCourseDao.addUserCourse(con, userId, courseId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/selectCoursePeople").forward(request, response);
    }
}
