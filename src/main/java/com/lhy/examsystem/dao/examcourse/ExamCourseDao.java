package com.lhy.examsystem.dao.examcourse;

import com.lhy.examsystem.model.ExamCourse;
import com.lhy.examsystem.model.ExamCourse1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamCourseDao implements IExamCourseDao {

    @Override
    public List<ExamCourse> getExamCourse(Connection con, int id) throws SQLException {
        String sql = "select exam.name examName,course.name courseName from exam_course,exam,course where exam_course.exam_id=exam.id and exam_course.course_id=course.id and course.id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<ExamCourse> examCourses = new ArrayList<>();
        while (resultSet.next()) {
            ExamCourse examCourse = new ExamCourse();
            examCourse.setExamId(resultSet.getString("examName"));
            examCourse.setCourseId(resultSet.getString("courseName"));
            examCourses.add(examCourse);
        }
        return examCourses;
    }

    @Override
    public void addExamCourse(Connection con, ExamCourse1 examCourse) throws SQLException {
        String sql = "insert into exam_course(exam_id,course_id) values(?,?)";
        if(getExamCourseCount(con,examCourse.getExamId(),examCourse.getCourseId())==0){
            //不存在该课程考试
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, examCourse.getExamId());
            preparedStatement.setInt(2, examCourse.getCourseId());
            preparedStatement.executeUpdate();
        } else {
            //存在该课程考试，实际上什么都不做，下面语句可以删除
            updateExamCourse(con,examCourse);
        }
    }

    @Override
    public void updateExamCourse(Connection con, ExamCourse1 examCourse) throws SQLException {
        String sql = "update exam_course set exam_id=?,course_id=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, examCourse.getExamId());
        preparedStatement.setInt(2, examCourse.getCourseId());
        preparedStatement.setInt(3, (int) examCourse.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public int getExamCourseCount(Connection con, int examId,int courseId) throws SQLException {
        String sql = "select ifnull(count(*),0) from exam_course where exam_id=? and course_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, examId);
        preparedStatement.setInt(2, courseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
