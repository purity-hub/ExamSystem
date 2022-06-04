package com.lhy.examsystem.dao.myeximing;

import com.lhy.examsystem.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IMyExamingDao {
    public List<Exam> getExamingList(Connection con,int userId) throws SQLException;

    public List<SingleChoice> getSingleChoiceList(Connection con,int examId) throws SQLException;

    public List<MultipleChoice> getMultipleChoiceList(Connection con,int examId) throws SQLException;

    public List<Judgment> getJudgmentList(Connection con,int examId) throws SQLException;

    public List<ShortAnswer> getShortAnswerList(Connection con, int examId) throws SQLException;

    public List<Integer> getSingleChoiceIdList(Connection con,int examId) throws SQLException;

    public List<Integer> getMultipleChoiceIdList(Connection con,int examId) throws SQLException;

    public List<Integer> getJudgmentIdList(Connection con,int examId) throws SQLException;

    public List<Integer> getShortAnswerIdList(Connection con,int examId) throws SQLException;

    public String getSingleChoiceAnswer(Connection con,int singleChoiceId) throws SQLException;

    public String getMultipleChoiceAnswer(Connection con,int multipleChoiceId) throws SQLException;

    public String getJudgmentAnswer(Connection con,int judgmentId) throws SQLException;

    public String getShortAnswerAnswer(Connection con,int shortAnswerId) throws SQLException;

    public int getSingleChoiceScore(Connection con,int singleChoiceId) throws SQLException;

    public int getMultipleChoiceScore(Connection con,int multipleChoiceId) throws SQLException;

    public int getJudgmentScore(Connection con,int judgmentId) throws SQLException;

    public int getShortAnswerScore(Connection con,int shortAnswerId) throws SQLException;

    public void insertMark(Connection con,UserExam userExam) throws SQLException;

    public int getCount(Connection con,UserExam userExam) throws SQLException;
}
