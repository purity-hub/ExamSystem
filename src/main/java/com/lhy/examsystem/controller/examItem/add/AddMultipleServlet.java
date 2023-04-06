package com.lhy.examsystem.controller.examItem.add;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.MultipleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddMultipleServlet", value = "/addMultiple")
public class AddMultipleServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        int examId = (int) session.getAttribute("examId");
        String MultipleId = request.getParameter("MultipleId");
        if(MultipleId == null || MultipleId.equals("")){
            //新增
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            String achoice = request.getParameter("achoice");
            String bchoice = request.getParameter("bchoice");
            String cchoice = request.getParameter("cchoice");
            String dchoice = request.getParameter("dchoice");
            ExamItemDao examItemDao = new ExamItemDao();
            MultipleChoice multipleChoice = new MultipleChoice();
            multipleChoice.setExamId(examId);
            multipleChoice.setQuestion(question);
            multipleChoice.setAnswer(answer);
            multipleChoice.setAChoice(achoice);
            multipleChoice.setBChoice(bchoice);
            multipleChoice.setCChoice(cchoice);
            multipleChoice.setDChoice(dchoice);
            try {
                examItemDao.AddMultiple(con, multipleChoice);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/selectExamItem").forward(request, response);
        }else{
            //修改
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            String achoice = request.getParameter("achoice");
            String bchoice = request.getParameter("bchoice");
            String cchoice = request.getParameter("cchoice");
            String dchoice = request.getParameter("dchoice");
            ExamItemDao examItemDao = new ExamItemDao();
            MultipleChoice multipleChoice = new MultipleChoice();
            multipleChoice.setId(Long.parseLong(MultipleId));
            multipleChoice.setExamId(examId);
            multipleChoice.setQuestion(question);
            multipleChoice.setAnswer(answer);
            multipleChoice.setAChoice(achoice);
            multipleChoice.setBChoice(bchoice);
            multipleChoice.setCChoice(cchoice);
            multipleChoice.setDChoice(dchoice);
            try {
                examItemDao.UpdateMultiple(con, multipleChoice);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/selectExamItem").forward(request, response);
        }

    }
}
