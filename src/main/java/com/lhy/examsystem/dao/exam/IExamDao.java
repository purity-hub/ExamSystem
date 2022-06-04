package com.lhy.examsystem.dao.exam;

import com.lhy.examsystem.model.Exam;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IExamDao {
    public boolean addExam(Connection con,Exam exam);
    public boolean deleteExam(Connection con,int id) throws SQLException;
    public boolean updateExam(Connection con,Exam exam) throws SQLException;
    public Exam getExam(Connection con,int id) throws SQLException;

    public List<Exam> getExamList(Connection con,String username) throws SQLException;

    public List<String> getExamNameList(Connection con) throws SQLException;

    int getExamIdByName(Connection con, String examName) throws SQLException;
}
