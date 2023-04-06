package com.lhy.examsystem.controller.examItem.add;

import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.SingleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AddSingleServlet", value = "/addSingle")
public class AddSingleServlet extends HttpServlet {
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
        String SingleId = request.getParameter("SingleId");
        HttpSession session = request.getSession();
        int examId = (int) session.getAttribute("examId");
        if(SingleId == null || SingleId.equals("")){
            //添加
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            String achoice = request.getParameter("achoice");
            String bchoice = request.getParameter("bchoice");
            String cchoice = request.getParameter("cchoice");
            String dchoice = request.getParameter("dchoice");
            ExamItemDao examItemDao = new ExamItemDao();
            SingleChoice singleChoice = new SingleChoice();
            singleChoice.setExamId(examId);
            singleChoice.setQuestion(question);
            singleChoice.setAnswer(answer);
            singleChoice.setAChoice(achoice);
            singleChoice.setBChoice(bchoice);
            singleChoice.setCChoice(cchoice);
            singleChoice.setDChoice(dchoice);
            try {
                examItemDao.AddSingle(con, singleChoice);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/selectExamItem").forward(request, response);
        }else{
            //修改
            String question = request.getParameter("question");
            String aChoice = request.getParameter("achoice");
            String bChoice = request.getParameter("bchoice");
            String cChoice = request.getParameter("cchoice");
            String dChoice = request.getParameter("dchoice");
            String answer = request.getParameter("answer");
            ExamItemDao examItemDao = new ExamItemDao();
            SingleChoice singleChoice = new SingleChoice();
            singleChoice.setId(Long.parseLong(SingleId));
            singleChoice.setExamId(examId);
            singleChoice.setQuestion(question);
            singleChoice.setAChoice(aChoice);
            singleChoice.setBChoice(bChoice);
            singleChoice.setCChoice(cChoice);
            singleChoice.setDChoice(dChoice);
            singleChoice.setAnswer(answer);
            try {
                examItemDao.UpdateSingle(con, singleChoice);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/selectExamItem").forward(request, response);
        }


    }
}
