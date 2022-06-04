package com.lhy.examsystem.dao.exam;

import com.lhy.examsystem.model.Exam;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao implements IExamDao {

    @Override
    public boolean addExam(Connection con,Exam exam) {
        String sql = "insert into exam(name,start_time,end_time,single_total,single_score,multiple_total,multiple_score,judgment_total,judgment_score,short_total,short_score,total_score,state,exam_time,miaoshu,create_by) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,exam.getName());
            preparedStatement.setTimestamp(2,exam.getStartTime());
            preparedStatement.setTimestamp(3,exam.getEndTime());
            preparedStatement.setInt(4, (int) exam.getSingleTotal());
            preparedStatement.setInt(5, (int) exam.getSingleScore());
            preparedStatement.setInt(6, (int) exam.getMultipleTotal());
            preparedStatement.setInt(7, (int) exam.getMultipleScore());
            preparedStatement.setInt(8, (int) exam.getJudgmentTotal());
            preparedStatement.setInt(9, (int) exam.getJudgmentScore());
            preparedStatement.setInt(10, (int) exam.getShortTotal());
            preparedStatement.setInt(11, (int) exam.getShortScore());
            preparedStatement.setInt(12, (int) exam.getTotalScore());
            preparedStatement.setString(13,exam.getState());
            preparedStatement.setInt(14,exam.getExamTime());
            preparedStatement.setString(15,exam.getMiaoshu());
            preparedStatement.setString(16,exam.getCreateBy());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteExam(Connection con,int id) throws SQLException {
        String sql = "delete from exam where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int i = preparedStatement.executeUpdate();
        if(i>0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateExam(Connection con,Exam exam) throws SQLException {
        String sql = "update exam set name = ?,start_time = ?,end_time = ?,single_total = ?,single_score = ?,multiple_total = ?,multiple_score = ?,judgment_total = ?,judgment_score = ?,short_total = ?,short_score = ?,total_score = ?,state = ?,exam_time = ?,miaoshu = ?,create_by = ? where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,exam.getName());
        preparedStatement.setTimestamp(2,exam.getStartTime());
        preparedStatement.setTimestamp(3,exam.getEndTime());
        preparedStatement.setInt(4, (int) exam.getSingleTotal());
        preparedStatement.setInt(5, (int) exam.getSingleScore());
        preparedStatement.setInt(6, (int) exam.getMultipleTotal());
        preparedStatement.setInt(7, (int) exam.getMultipleScore());
        preparedStatement.setInt(8, (int) exam.getJudgmentTotal());
        preparedStatement.setInt(9, (int) exam.getJudgmentScore());
        preparedStatement.setInt(10, (int) exam.getShortTotal());
        preparedStatement.setInt(11, (int) exam.getShortScore());
        preparedStatement.setInt(12, (int) exam.getTotalScore());
        preparedStatement.setString(13,exam.getState());
        preparedStatement.setInt(14,exam.getExamTime());
        preparedStatement.setString(15,exam.getMiaoshu());
        preparedStatement.setString(16,exam.getCreateBy());
        preparedStatement.setInt(17, (int) exam.getId());
        int i = preparedStatement.executeUpdate();
        if(i>0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Exam getExam(Connection con,int id) throws SQLException {
        String sql = "select * from exam where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Exam exam = new Exam();
        while (resultSet.next()){
            exam.setId(resultSet.getInt("id"));
            exam.setName(resultSet.getString("name"));//试卷名称
            exam.setStartTime(resultSet.getTimestamp("start_time"));//开始时间
            exam.setEndTime(resultSet.getTimestamp("end_time"));//结束时间
            exam.setSingleTotal(resultSet.getInt("single_total"));//单选题总数
            exam.setSingleScore(resultSet.getInt("single_score"));//单选题分数
            exam.setMultipleTotal(resultSet.getInt("multiple_total"));//多选题总数
            exam.setMultipleScore(resultSet.getInt("multiple_score"));//多选题分数
            exam.setJudgmentTotal(resultSet.getInt("judgment_total"));//判断题总数
            exam.setJudgmentScore(resultSet.getInt("judgment_score"));//判断题分数
            exam.setShortTotal(resultSet.getInt("short_total"));//简答题总数
            exam.setShortScore(resultSet.getInt("short_score"));//简答题分数
            exam.setTotalScore(resultSet.getInt("total_score"));//总分
            exam.setState(resultSet.getString("state"));//状态
            exam.setExamTime(resultSet.getInt("exam_time"));//考试时间
        }
        return exam;
    }

    @Override
    public List<Exam> getExamList(Connection con,String username) throws SQLException {
        String sql = "select * from exam where create_by = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Exam> examList = new ArrayList<>();
        while (resultSet.next()){
            Exam exam = new Exam();
            exam.setId(resultSet.getInt("id"));
            exam.setName(resultSet.getString("name"));//试卷名称
            exam.setStartTime(resultSet.getTimestamp("start_time"));//开始时间
            exam.setEndTime(resultSet.getTimestamp("end_time"));//结束时间
            exam.setSingleTotal(resultSet.getInt("single_total"));//单选题总数
            exam.setSingleScore(resultSet.getInt("single_score"));//单选题分数
            exam.setMultipleTotal(resultSet.getInt("multiple_total"));//多选题总数
            exam.setMultipleScore(resultSet.getInt("multiple_score"));//多选题分数
            exam.setJudgmentTotal(resultSet.getInt("judgment_total"));//判断题总数
            exam.setJudgmentScore(resultSet.getInt("judgment_score"));//判断题分数
            exam.setShortTotal(resultSet.getInt("short_total"));//简答题总数
            exam.setShortScore(resultSet.getInt("short_score"));//简答题分数
            exam.setCreateBy(resultSet.getString("create_by"));//创建人
            exam.setMiaoshu(resultSet.getString("miaoshu"));//试卷描述
            exam.setTotalScore(resultSet.getInt("total_score"));//总分
            exam.setState(resultSet.getString("state"));//状态
            examList.add(exam);
        }
        return examList;
    }

    @Override
    public List<String> getExamNameList(Connection con) throws SQLException {
        String sql = "select name from exam";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> examNameList = new ArrayList<>();
        while (resultSet.next()){
            examNameList.add(resultSet.getString("name"));
        }
        return examNameList;
    }

    @Override
    public int getExamIdByName(Connection con, String examName) throws SQLException {
        String sql = "select id from exam where name = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,examName);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }

    public List<String> getExamNameList(Connection con,String username) throws SQLException {
        String sql = "select name from exam where create_by = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> examNameList = new ArrayList<>();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            examNameList.add(name);
        }
        return examNameList;
    }

    public int getExamId(Connection con,String name,String username) throws SQLException {
        String sql = "select id from exam where name = ? and create_by = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }
}
