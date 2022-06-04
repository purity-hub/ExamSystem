package com.lhy.examsystem.dao.course;

import com.lhy.examsystem.model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ICourseDao {
    public boolean addCourse(Connection con,Course course) throws SQLException;
    public boolean deleteCourse(Connection con,int courseId) throws SQLException;
    public boolean updateCourse(Connection con,Course course) throws SQLException;
    public List<Course> queryCourse(Connection con, int teacherId) throws SQLException;

    public List<String> queryCourseName(Connection con, int teacherId) throws SQLException;

    public int getId(Connection con, int teacherId,String name) throws SQLException;
}
