package com.lhy.examsystem.controller.examItem.edit;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.ShortAnswer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "EditShortServlet", value = "/EditShortServlet")
public class EditShortServlet extends HttpServlet {

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
        int examId = request.getParameter("examId") == null ? 0 : Integer.parseInt(request.getParameter("examId"));
        String ShortId = request.getParameter("ShortId");
        if(ShortId == null || ShortId.equals("")){
            //添加
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            ExamItemDao examItemDao = new ExamItemDao();
            ShortAnswer shortAnswer = new ShortAnswer();
            shortAnswer.setId(id);
            shortAnswer.setExamId(examId);
            shortAnswer.setQuestion(question);
            shortAnswer.setAnswer(answer);
            try {
                examItemDao.UpdateShort(con, shortAnswer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            //修改
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            ExamItemDao examItemDao = new ExamItemDao();
            ShortAnswer shortAnswer = new ShortAnswer();
            shortAnswer.setId(id);
            shortAnswer.setExamId(examId);
            shortAnswer.setQuestion(question);
            shortAnswer.setAnswer(answer);

        }

    }
}
