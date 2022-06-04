package com.lhy.examsystem.dao.myeximing;

import com.lhy.examsystem.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyExamingDao implements IMyExamingDao{

    @Override
    public List<Exam> getExamingList(Connection con ,int userId) throws SQLException {
        String sql = "select exam.id id, course.name CourseName,exam.name ExamName,start_time,end_time,exam_time,total_score from user,course,user_course,exam,exam_course where user.id=user_course.user_id and user_course.course_id=course.id and exam_course.exam_id=exam.id and exam_course.course_id=course.id and user.id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Exam> exams = new ArrayList<>();
        while (resultSet.next()){
            Exam exam = new Exam();
            exam.setId(resultSet.getInt("id"));
            exam.setName(resultSet.getString("ExamName"));
            exam.setCourseName(resultSet.getString("CourseName"));
            exam.setStartTime(resultSet.getTimestamp("start_time"));
            exam.setEndTime(resultSet.getTimestamp("end_time"));
            exam.setExamTime(resultSet.getInt("exam_time"));
            exam.setTotalScore(resultSet.getInt("total_score"));
            exams.add(exam);
        }
        return exams;
    }

    @Override
    public List<SingleChoice> getSingleChoiceList(Connection con, int examId) throws SQLException {
        String sql = "select * from single_choice where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<SingleChoice> singleChoices = new ArrayList<>();
        while (resultSet.next()){
            SingleChoice singleChoice = new SingleChoice();
            singleChoice.setId(resultSet.getInt("id"));
            singleChoice.setExamId(resultSet.getInt("exam_id"));
            singleChoice.setQuestion(resultSet.getString("question"));
            singleChoice.setAChoice(resultSet.getString("a_choice"));
            singleChoice.setBChoice(resultSet.getString("b_choice"));
            singleChoice.setCChoice(resultSet.getString("c_choice"));
            singleChoice.setDChoice(resultSet.getString("d_choice"));
            singleChoice.setAnswer(resultSet.getString("answer"));
            singleChoices.add(singleChoice);
        }
        return singleChoices;
    }

    @Override
    public List<MultipleChoice> getMultipleChoiceList(Connection con, int examId) throws SQLException {
        String sql = "select * from multiple_choice where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<MultipleChoice> multipleChoices = new ArrayList<>();
        while (resultSet.next()){
            MultipleChoice multipleChoice = new MultipleChoice();
            multipleChoice.setId(resultSet.getInt("id"));
            multipleChoice.setExamId(resultSet.getInt("exam_id"));
            multipleChoice.setQuestion(resultSet.getString("question"));
            multipleChoice.setAChoice(resultSet.getString("a_choice"));
            multipleChoice.setBChoice(resultSet.getString("b_choice"));
            multipleChoice.setCChoice(resultSet.getString("c_choice"));
            multipleChoice.setDChoice(resultSet.getString("d_choice"));
            multipleChoice.setAnswer(resultSet.getString("answer"));
            multipleChoices.add(multipleChoice);
        }
        return multipleChoices;
    }

    @Override
    public List<Judgment> getJudgmentList(Connection con, int examId) throws SQLException {
        String sql = "select * from judgment where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Judgment> judgments = new ArrayList<>();
        while (resultSet.next()){
            Judgment judgment = new Judgment();
            judgment.setId(resultSet.getInt("id"));
            judgment.setExamId(resultSet.getInt("exam_id"));
            judgment.setQuestion(resultSet.getString("question"));
            judgment.setAnswer(resultSet.getString("answer"));
            judgments.add(judgment);
        }
        return judgments;
    }

    @Override
    public List<ShortAnswer> getShortAnswerList(Connection con, int examId) throws SQLException {
        String sql = "select * from short_answer where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ShortAnswer> shortAnswers = new ArrayList<>();
        while (resultSet.next()){
            ShortAnswer shortAnswer = new ShortAnswer();
            shortAnswer.setId(resultSet.getInt("id"));
            shortAnswer.setExamId(resultSet.getInt("exam_id"));
            shortAnswer.setQuestion(resultSet.getString("question"));
            shortAnswer.setAnswer(resultSet.getString("answer"));
            shortAnswers.add(shortAnswer);
        }
        return shortAnswers;
    }

    @Override
    public List<Integer> getSingleChoiceIdList(Connection con, int examId) throws SQLException {
        String sql = "select id from single_choice where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> singleChoiceIds = new ArrayList<>();
        while (resultSet.next()){
            singleChoiceIds.add(resultSet.getInt("id"));
        }
        return singleChoiceIds;
    }

    @Override
    public List<Integer> getMultipleChoiceIdList(Connection con, int examId) throws SQLException {
        String sql = "select id from multiple_choice where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> multipleChoiceIds = new ArrayList<>();
        while (resultSet.next()){
            multipleChoiceIds.add(resultSet.getInt("id"));
        }
        return multipleChoiceIds;
    }

    @Override
    public List<Integer> getJudgmentIdList(Connection con, int examId) throws SQLException {
        String sql = "select id from judgment where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> judgmentIds = new ArrayList<>();
        while (resultSet.next()){
            judgmentIds.add(resultSet.getInt("id"));
        }
        return judgmentIds;
    }

    @Override
    public List<Integer> getShortAnswerIdList(Connection con, int examId) throws SQLException {
        String sql = "select id from short_answer where exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> shortAnswerIds = new ArrayList<>();
        while (resultSet.next()){
            shortAnswerIds.add(resultSet.getInt("id"));
        }
        return shortAnswerIds;
    }

    @Override
    public String getSingleChoiceAnswer(Connection con, int singleChoiceId) throws SQLException {
        String sql = "select answer from single_choice where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,singleChoiceId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String answer = null;
        while (resultSet.next()){
            answer = resultSet.getString("answer");
        }
        return answer;
    }

    @Override
    public String getMultipleChoiceAnswer(Connection con, int multipleChoiceId) throws SQLException {
        String sql = "select answer from multiple_choice where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,multipleChoiceId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String answer = null;
        while (resultSet.next()){
            answer = resultSet.getString("answer");
        }
        return answer;
    }

    @Override
    public String getJudgmentAnswer(Connection con, int judgmentId) throws SQLException {
        String sql = "select answer from judgment where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,judgmentId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String answer = null;
        while (resultSet.next()){
            answer = resultSet.getString("answer");
        }
        return answer;
    }

    @Override
    public String getShortAnswerAnswer(Connection con, int shortAnswerId) throws SQLException {
        String sql = "select answer from short_answer where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,shortAnswerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String answer = null;
        while (resultSet.next()){
            answer = resultSet.getString("answer");
        }
        return answer;
    }

    @Override
    public int getSingleChoiceScore(Connection con, int singleChoiceId) throws SQLException {
        String sql = "select single_score from exam where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,singleChoiceId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int score = 0;
        while (resultSet.next()){
            score = resultSet.getInt("single_score");
        }
        return score;
    }

    @Override
    public int getMultipleChoiceScore(Connection con, int multipleChoiceId) throws SQLException {
        String sql = "select multiple_score from exam where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,multipleChoiceId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int score = 0;
        while (resultSet.next()){
            score = resultSet.getInt("multiple_score");
        }
        return score;
    }

    @Override
    public int getJudgmentScore(Connection con, int judgmentId) throws SQLException {
        String sql = "select judgment_score from exam where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,judgmentId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int score = 0;
        while (resultSet.next()){
            score = resultSet.getInt("judgment_score");
        }
        return score;
    }

    @Override
    public int getShortAnswerScore(Connection con, int shortAnswerId) throws SQLException {
        String sql = "select short_score from exam where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,shortAnswerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int score = 0;
        while (resultSet.next()){
            score = resultSet.getInt("short_score");
        }
        return score;
    }

    @Override
    public void insertMark(Connection con, UserExam userExam) throws SQLException {
        String sql = "insert into user_exam(user_id,exam_id,mark) values(?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) userExam.getUserId());
        preparedStatement.setInt(2, (int) userExam.getExamId());
        preparedStatement.setInt(3, (int) userExam.getMark());
        preparedStatement.executeUpdate();
    }

    @Override
    public int getCount(Connection con, UserExam userExam) throws SQLException {
        String sql = "select ifnull(count(*),0) from user_exam where user_id = ? and exam_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) userExam.getUserId());
        preparedStatement.setInt(2, (int) userExam.getExamId());
        ResultSet resultSet = preparedStatement.executeQuery();
        int count = 0;
        while (resultSet.next()){
            count = resultSet.getInt(1);
        }
        return count;
    }
}
