package com.lhy.examsystem.controller.usercourse;

import com.lhy.examsystem.dao.usercourse.UserCourseDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DeleteUserCourseServlet", value = "/deleteUserCourse")
public class DeleteUserCourseServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        int courseId = (int) session.getAttribute("courseId");
        UserCourseDao userCourseDao = new UserCourseDao();
        try {
            userCourseDao.deleteUserCourse(con, id,courseId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/selectCoursePeople").forward(request,response);
    }
}
