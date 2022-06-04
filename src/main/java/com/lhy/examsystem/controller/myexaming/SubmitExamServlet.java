package com.lhy.examsystem.controller.myexaming;

import com.lhy.examsystem.dao.myeximing.MyExamingDao;
import com.lhy.examsystem.dao.user.UserDao;
import com.lhy.examsystem.model.UserExam;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SubmitExamServlet", value = "/submitExam")
public class SubmitExamServlet extends HttpServlet {
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
        int result = 0;//总分
        MyExamingDao myExamingDao = new MyExamingDao();
        HttpSession session = request.getSession();
        int examId = (int) session.getAttribute("examId");
        List<Integer> singleChoiceIdList = new ArrayList<>();
        List<Integer> multipleChoiceIdList = new ArrayList<>();
        List<Integer> judgmentIdList = new ArrayList<>();
        List<Integer> shortAnswerIdList = new ArrayList<>();
        int singleChoiceScore = 0;
        int multipleChoiceScore = 0;
        int judgmentScore = 0;
        int shortAnswerScore = 0;
        try {
            singleChoiceScore = myExamingDao.getSingleChoiceScore(con, examId);
            multipleChoiceScore = myExamingDao.getMultipleChoiceScore(con, examId);
            judgmentScore = myExamingDao.getJudgmentScore(con, examId);
            shortAnswerScore = myExamingDao.getShortAnswerScore(con, examId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            singleChoiceIdList = myExamingDao.getSingleChoiceIdList(con, examId);
            multipleChoiceIdList = myExamingDao.getMultipleChoiceIdList(con, examId);
            judgmentIdList = myExamingDao.getJudgmentIdList(con, examId);
            shortAnswerIdList = myExamingDao.getShortAnswerIdList(con, examId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //单选题
        for(int i = 0; i < singleChoiceIdList.size(); i++) {
            int singleChoiceId = singleChoiceIdList.get(i);
            String singleChoiceAnswer = request.getParameter("singleChoice" + singleChoiceId)!=null?request.getParameter("singleChoice" + singleChoiceId):"";
            try {
                String singleChoiceAnswer1 = myExamingDao.getSingleChoiceAnswer(con, singleChoiceId);
                if(singleChoiceAnswer.equals(singleChoiceAnswer1)) {
                    result += singleChoiceScore;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //多选题
        for(int i = 0; i < multipleChoiceIdList.size(); i++) {
            int multipleChoiceId = multipleChoiceIdList.get(i);
            String[] multipleChoiceAnswer = request.getParameterValues("multipleChoice" + multipleChoiceId)!=null?request.getParameterValues("multipleChoice" + multipleChoiceId):new String[0];
            //将数组转换为字符串ABCD
            StringBuilder multipleChoiceAnswer1 = new StringBuilder();
            for(int j = 0; j < multipleChoiceAnswer.length; j++) {
                multipleChoiceAnswer1.append(multipleChoiceAnswer[j]);
            }
            try {
                String multipleChoiceAnswer2 = myExamingDao.getMultipleChoiceAnswer(con, multipleChoiceId)!=null?myExamingDao.getMultipleChoiceAnswer(con, multipleChoiceId):"";
                if(multipleChoiceAnswer1.toString().equals(multipleChoiceAnswer2)) {
                    result += multipleChoiceScore;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //判断题
        for(int i = 0; i < judgmentIdList.size(); i++) {
            int judgmentId = judgmentIdList.get(i);
            String judgmentAnswer = request.getParameter("judgment" + judgmentId)!=null?request.getParameter("judgment" + judgmentId):"";
            try {
                String judgmentAnswer1 = myExamingDao.getJudgmentAnswer(con, judgmentId);
                if(judgmentAnswer.equals(judgmentAnswer1)) {
                    result += judgmentScore;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //简答题
        for(int i = 0; i < shortAnswerIdList.size(); i++) {
            int shortAnswerId = shortAnswerIdList.get(i);
            String shortAnswerAnswer = request.getParameter("shortAnswer" + shortAnswerId)!=null?request.getParameter("shortAnswer" + shortAnswerId):"";
            try {
                String shortAnswerAnswer1 = myExamingDao.getShortAnswerAnswer(con, shortAnswerId);
                if(shortAnswerAnswer.equals(shortAnswerAnswer1)) {
                    result += shortAnswerScore;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        UserExam userExam = new UserExam();
        UserDao userDao = new UserDao();
        String username = (String) session.getAttribute("username");
        try {
            userExam.setUserId(userDao.getUserIdByAccount(con, username));
            userExam.setExamId(examId);
            userExam.setMark(result);
            if(myExamingDao.getCount(con, userExam) == 0) {
                //不存在数据，插入
                myExamingDao.insertMark(con, userExam);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
