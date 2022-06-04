package com.lhy.examsystem.dao.examItem;

import com.lhy.examsystem.model.Judgment;
import com.lhy.examsystem.model.MultipleChoice;
import com.lhy.examsystem.model.ShortAnswer;
import com.lhy.examsystem.model.SingleChoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamItemDao implements IExamItemDao {

    @Override
    public List<SingleChoice> QuerySingle(Connection con, int examId) throws SQLException {
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
            singleChoice.setAnswer(resultSet.getString("answer"));
            singleChoice.setAChoice(resultSet.getString("a_choice"));
            singleChoice.setBChoice(resultSet.getString("b_choice"));
            singleChoice.setCChoice(resultSet.getString("c_choice"));
            singleChoice.setDChoice(resultSet.getString("d_choice"));
            singleChoices.add(singleChoice);
        }
        return singleChoices;
    }

    @Override
    public List<MultipleChoice> QueryMultiple(Connection con, int examId) throws SQLException {
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
            multipleChoice.setAnswer(resultSet.getString("answer"));
            multipleChoice.setAChoice(resultSet.getString("a_choice"));
            multipleChoice.setBChoice(resultSet.getString("b_choice"));
            multipleChoice.setCChoice(resultSet.getString("c_choice"));
            multipleChoice.setDChoice(resultSet.getString("d_choice"));
            multipleChoices.add(multipleChoice);
        }
        return multipleChoices;
    }

    @Override
    public List<Judgment> QueryJudgment(Connection con, int examId) throws SQLException {
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
    public List<ShortAnswer> QueryShort(Connection con, int examId) throws SQLException {
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
    public int AddSingle(Connection con, SingleChoice singleChoice) throws SQLException {
        String sql = "insert into single_choice(exam_id,question,answer,a_choice,b_choice,c_choice,d_choice) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) singleChoice.getExamId());
        preparedStatement.setString(2,singleChoice.getQuestion());
        preparedStatement.setString(3,singleChoice.getAnswer());
        preparedStatement.setString(4,singleChoice.getAChoice());
        preparedStatement.setString(5,singleChoice.getBChoice());
        preparedStatement.setString(6,singleChoice.getCChoice());
        preparedStatement.setString(7,singleChoice.getDChoice());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int AddMultiple(Connection con, MultipleChoice multipleChoice) throws SQLException {
        String sql = "insert into multiple_choice(exam_id,question,answer,a_choice,b_choice,c_choice,d_choice) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) multipleChoice.getExamId());
        preparedStatement.setString(2,multipleChoice.getQuestion());
        preparedStatement.setString(3,multipleChoice.getAnswer());
        preparedStatement.setString(4,multipleChoice.getAChoice());
        preparedStatement.setString(5,multipleChoice.getBChoice());
        preparedStatement.setString(6,multipleChoice.getCChoice());
        preparedStatement.setString(7,multipleChoice.getDChoice());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int AddJudgment(Connection con, Judgment judgment) throws SQLException {
        String sql = "insert into judgment(exam_id,question,answer) values(?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) judgment.getExamId());
        preparedStatement.setString(2,judgment.getQuestion());
        preparedStatement.setString(3,judgment.getAnswer());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int AddShort(Connection con, ShortAnswer shortAnswer) throws SQLException {
        String sql = "insert into short_answer(exam_id,question,answer) values(?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) shortAnswer.getExamId());
        preparedStatement.setString(2,shortAnswer.getQuestion());
        preparedStatement.setString(3,shortAnswer.getAnswer());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int DeleteSingle(Connection con, int id) throws SQLException {
        String sql = "delete from single_choice where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int DeleteMultiple(Connection con, int id) throws SQLException {
        String sql = "delete from multiple_choice where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int DeleteJudgment(Connection con, int id) throws SQLException {
        String sql = "delete from judgment where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int DeleteShort(Connection con, int id) throws SQLException {
        String sql = "delete from short_answer where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int UpdateSingle(Connection con, SingleChoice singleChoice) throws SQLException {
        String sql = "update single_choice set exam_id=?,question=?,answer=?,a_choice=?,b_choice=?,c_choice=?,d_choice=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) singleChoice.getExamId());
        preparedStatement.setString(2,singleChoice.getQuestion());
        preparedStatement.setString(3,singleChoice.getAnswer());
        preparedStatement.setString(4,singleChoice.getAChoice());
        preparedStatement.setString(5,singleChoice.getBChoice());
        preparedStatement.setString(6,singleChoice.getCChoice());
        preparedStatement.setString(7,singleChoice.getDChoice());
        preparedStatement.setInt(8, (int) singleChoice.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int UpdateMultiple(Connection con, MultipleChoice multipleChoice) throws SQLException {
        String sql = "update multiple_choice set exam_id=?,question=?,answer=?,a_choice=?,b_choice=?,c_choice=?,d_choice=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) multipleChoice.getExamId());
        preparedStatement.setString(2,multipleChoice.getQuestion());
        preparedStatement.setString(3,multipleChoice.getAnswer());
        preparedStatement.setString(4,multipleChoice.getAChoice());
        preparedStatement.setString(5,multipleChoice.getBChoice());
        preparedStatement.setString(6,multipleChoice.getCChoice());
        preparedStatement.setString(7,multipleChoice.getDChoice());
        preparedStatement.setInt(8, (int) multipleChoice.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int UpdateJudgment(Connection con, Judgment judgment) throws SQLException {
        String sql = "update judgment set exam_id=?,question=?,answer=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) judgment.getExamId());
        preparedStatement.setString(2,judgment.getQuestion());
        preparedStatement.setString(3,judgment.getAnswer());
        preparedStatement.setInt(4, (int) judgment.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int UpdateShort(Connection con, ShortAnswer shortAnswer) throws SQLException {
        String sql = "update short_answer set exam_id=?,question=?,answer=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, (int) shortAnswer.getExamId());
        preparedStatement.setString(2,shortAnswer.getQuestion());
        preparedStatement.setString(3,shortAnswer.getAnswer());
        preparedStatement.setInt(4, (int) shortAnswer.getId());
        return preparedStatement.executeUpdate();
    }
}
