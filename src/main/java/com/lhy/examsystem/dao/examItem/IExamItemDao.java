package com.lhy.examsystem.dao.examItem;

import com.lhy.examsystem.model.Judgment;
import com.lhy.examsystem.model.MultipleChoice;
import com.lhy.examsystem.model.ShortAnswer;
import com.lhy.examsystem.model.SingleChoice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IExamItemDao {
    public List<SingleChoice> QuerySingle(Connection con,int examId) throws SQLException;

    public List<MultipleChoice> QueryMultiple(Connection con,int examId) throws SQLException;

    public List<Judgment> QueryJudgment(Connection con,int examId) throws SQLException;

    public List<ShortAnswer> QueryShort(Connection con,int examId) throws SQLException;

    public int AddSingle(Connection con,SingleChoice singleChoice) throws SQLException;

    public int AddMultiple(Connection con,MultipleChoice multipleChoice) throws SQLException;

    public int AddJudgment(Connection con,Judgment judgment) throws SQLException;

    public int AddShort(Connection con,ShortAnswer shortAnswer) throws SQLException;

    public int DeleteSingle(Connection con,int id) throws SQLException;

    public int DeleteMultiple(Connection con,int id) throws SQLException;

    public int DeleteJudgment(Connection con,int id) throws SQLException;

    public int DeleteShort(Connection con,int id) throws SQLException;

    public int UpdateSingle(Connection con,SingleChoice singleChoice) throws SQLException;

    public int UpdateMultiple(Connection con,MultipleChoice multipleChoice) throws SQLException;

    public int UpdateJudgment(Connection con,Judgment judgment) throws SQLException;

    public int UpdateShort(Connection con,ShortAnswer shortAnswer) throws SQLException;
}
