package com.lhy.examsystem.controller.coursepeople;

import com.lhy.examsystem.dao.course.CourseDao;
import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectCoursePeopleServlet", value = "/selectCoursePeople")
public class SelectCoursePeopleServlet extends HttpServlet {
    private Connection con;

    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        String name = request.getParameter("courseName");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        UserDao userDao = new UserDao();
        int teacherId = 0;
        int courseId = 0;
        List<User> userByCourse = new ArrayList<>();
        List<User> all = new ArrayList<>();
        try {
            teacherId = userDao.getUserIdByAccount(con, username);
            courseId = courseDao.getId(con,teacherId,name);
            if(courseId==0){
                courseId = session.getAttribute("courseId")==null?0:Integer.parseInt(session.getAttribute("courseId").toString());
            }
            session.setAttribute("courseId",courseId);
            userByCourse = userDao.getUserByCourse(con, courseId);
            all = userDao.findAll(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("userByCourse", userByCourse);
        session.setAttribute("allStudents", all);//session中保存所有学生
        request.getRequestDispatcher("coursePeople.jsp").forward(request, response);
    }
}
