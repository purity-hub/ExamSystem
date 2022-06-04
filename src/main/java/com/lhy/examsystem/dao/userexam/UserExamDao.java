package com.lhy.examsystem.dao.userexam;

import com.lhy.examsystem.model.UserExam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserExamDao implements IUserExamDao {

    @Override
    public List<UserExam1> queryUserExam(Connection con, int examId) throws SQLException {
        String sql = "select user_exam.id id,exam.name examName,user.account account,mark from user_exam,user,exam where user_exam.user_id=user.id and user_exam.exam_id=exam.id and exam.id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, examId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserExam1> userExam1s = new ArrayList<>();
        while (resultSet.next()) {
            UserExam1 userExam1 = new UserExam1();
            userExam1.setId(resultSet.getInt("id"));
            userExam1.setExamId(resultSet.getString("examName"));//考试名称
            userExam1.setUserId(resultSet.getString("account"));//用户账号
            userExam1.setMark(resultSet.getInt("mark"));//分数
            userExam1s.add(userExam1);
        }
        return userExam1s;
    }

    @Override
    public List<UserExam1> queryUserExam1(Connection con, int userId) throws SQLException {
        String sql = "select user_exam.id id,exam.name examName,user.account account,mark from user_exam,user,exam where user_exam.user_id=user.id and user_exam.exam_id=exam.id and user.id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserExam1> userExam1s = new ArrayList<>();
        while (resultSet.next()) {
            UserExam1 userExam1 = new UserExam1();
            userExam1.setId(resultSet.getInt("id"));
            userExam1.setExamId(resultSet.getString("examName"));//考试名称
            userExam1.setUserId(resultSet.getString("account"));//用户账号
            userExam1.setMark(resultSet.getInt("mark"));//分数
            userExam1s.add(userExam1);
        }
        return userExam1s;
    }
}
