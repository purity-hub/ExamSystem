package com.lhy.examsystem.dao.examcourse;

import com.lhy.examsystem.model.ExamCourse;
import com.lhy.examsystem.model.ExamCourse1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IExamCourseDao {
    public List<ExamCourse> getExamCourse(Connection con, int  id) throws SQLException;

    public void addExamCourse(Connection con, ExamCourse1 examCourse) throws SQLException;

    public void updateExamCourse(Connection con, ExamCourse1 examCourse) throws SQLException;

    public int getExamCourseCount(Connection con, int examId,int courseId) throws SQLException;
}
