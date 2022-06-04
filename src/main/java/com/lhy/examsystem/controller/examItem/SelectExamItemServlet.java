package com.lhy.examsystem.controller.examItem;

import com.lhy.examsystem.dao.exam.ExamDao;
import com.lhy.examsystem.dao.examItem.ExamItemDao;
import com.lhy.examsystem.model.Judgment;
import com.lhy.examsystem.model.MultipleChoice;
import com.lhy.examsystem.model.ShortAnswer;
import com.lhy.examsystem.model.SingleChoice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectExamItemServlet", value = "/selectExamItem")
public class SelectExamItemServlet extends HttpServlet {
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
        ExamItemDao examItemDao = new ExamItemDao();
        String name = request.getParameter("examName");
        ExamDao examDao = new ExamDao();
        List<String> examNameList = new ArrayList<>();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try {
            int examId = examDao.getExamId(con, name,username);
            if(examId == 0){
                examId = session.getAttribute("examId") == null ? 0 : (int) session.getAttribute("examId");
            }
            //第一次操作时就设置了session属性
            session.setAttribute("examId",examId);
            List<SingleChoice> singleChoices = examItemDao.QuerySingle(con, examId);
            request.setAttribute("singleChoices", singleChoices);
            List<MultipleChoice> multipleChoices = examItemDao.QueryMultiple(con, examId);
            request.setAttribute("multipleChoices", multipleChoices);
            List<Judgment> judgments = examItemDao.QueryJudgment(con, examId);
            request.setAttribute("judgments", judgments);
            List<ShortAnswer> shortAnswers = examItemDao.QueryShort(con, examId);
            request.setAttribute("shortAnswers", shortAnswers);
            examNameList = examDao.getExamNameList(con,username);
            request.setAttribute("examNameList", examNameList);
            request.getRequestDispatcher("examItem.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
