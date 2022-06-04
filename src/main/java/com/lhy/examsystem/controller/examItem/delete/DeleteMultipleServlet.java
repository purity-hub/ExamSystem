package com.lhy.examsystem.controller.examItem.delete;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DeleteMultipleServlet", value = "/deleteMultiple")
public class DeleteMultipleServlet extends HttpServlet {
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
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        ExamItemDao examItemDao = new ExamItemDao();
        try {
            examItemDao.DeleteMultiple(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/selectExamItem").forward(request, response);
    }
}
