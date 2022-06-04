package com.lhy.examsystem.dao.userexam;

import com.lhy.examsystem.model.UserExam1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUserExamDao {
    List<UserExam1> queryUserExam(Connection con, int examId) throws SQLException;

    List<UserExam1> queryUserExam1(Connection con,int userId) throws SQLException;
}
