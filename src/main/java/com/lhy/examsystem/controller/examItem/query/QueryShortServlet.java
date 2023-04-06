package com.lhy.examsystem.controller.examItem.query;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.ShortAnswer;
import com.lhy.examsystem.model.SingleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "QueryShortServlet", value = "/QueryShort")
public class QueryShortServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        ExamItemDao examItemDao = new ExamItemDao();
        ShortAnswer shortAnswer = new ShortAnswer();
        try {
            shortAnswer = examItemDao.QueryShortById(con, Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(shortAnswer.toString());
    }
}
