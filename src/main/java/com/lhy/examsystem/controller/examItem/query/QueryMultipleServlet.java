package com.lhy.examsystem.controller.examItem.query;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.MultipleChoice;
import com.lhy.examsystem.model.SingleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "QueryMultipleServlet", value = "/QueryMultiple")
public class QueryMultipleServlet extends HttpServlet {

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
        MultipleChoice multipleChoice = new MultipleChoice();
        try {
            multipleChoice = examItemDao.QueryMultipleById(con, Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().write(multipleChoice.toString());
    }
}
