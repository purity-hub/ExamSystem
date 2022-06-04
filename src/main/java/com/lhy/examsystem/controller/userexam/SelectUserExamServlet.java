package com.lhy.examsystem.controller.userexam;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.dao.userexam.UserExamDao;
import com.lhy.examsystem.model.UserExam1;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectUserExamServlet", value = "/selectUserExam")
public class SelectUserExamServlet extends HttpServlet {
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
        UserExamDao userExamDao = new UserExamDao();
        String examName = request.getParameter("examName");
        ExamDao examDao = new ExamDao();
        int examId = 0;
        List<UserExam1> userExamList = new ArrayList<>();
        try {
            examId = examDao.getExamIdByName(con, examName);
            userExamList = userExamDao.queryUserExam(con, examId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("userExamList", userExamList);
        request.getRequestDispatcher("score.jsp").forward(request, response);
    }
}
