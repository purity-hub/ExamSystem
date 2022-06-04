package com.lhy.examsystem.dao.course;

import com.lhy.examsystem.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements ICourseDao {

    @Override
    public boolean addCourse(Connection con, Course course) throws SQLException {
        String sql = "insert into course(name,teacher_id,type,credit,time) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, course.getName());
        preparedStatement.setInt(2, (int) course.getTeacherId());
        preparedStatement.setString(3, course.getType());
        preparedStatement.setInt(4, (int) course.getCredit());
        preparedStatement.setInt(5, (int) course.getTime());
        int result = preparedStatement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean deleteCourse(Connection con, int courseId) throws SQLException {
        String sql = "delete from course where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, courseId);
        int i = preparedStatement.executeUpdate();
        return i>0;
    }

    @Override
    public boolean updateCourse(Connection con, Course course) throws SQLException {
        String sql = "update course set name = ?,teacher_id = ?,type = ?,credit = ?,time = ? where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, course.getName());
        preparedStatement.setInt(2, (int) course.getTeacherId());
        preparedStatement.setString(3, course.getType());
        preparedStatement.setInt(4, (int) course.getCredit());
        preparedStatement.setInt(5, (int) course.getTime());
        preparedStatement.setInt(6, (int) course.getId());
        int i = preparedStatement.executeUpdate();
        return i>0;
    }

    @Override
    public List<Course> queryCourse(Connection con, int teacherId) throws SQLException {
        String sql = "select * from course where teacher_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, teacherId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Course> courses = new ArrayList<>();
        while (resultSet.next()) {
            Course course = new Course();
            course.setId(resultSet.getInt("id"));
            course.setName(resultSet.getString("name"));
            course.setTeacherId(resultSet.getInt("teacher_id"));
            course.setType(resultSet.getString("type"));
            course.setCredit(resultSet.getInt("credit"));
            course.setTime(resultSet.getInt("time"));
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<String> queryCourseName(Connection con, int teacherId) throws SQLException {
        String sql = "select name from course where teacher_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, teacherId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> courseNames = new ArrayList<>();
        while (resultSet.next()) {
            courseNames.add(resultSet.getString("name"));
        }
        return courseNames;
    }

    public Course queryCourseById(Connection con, int courseId) throws SQLException {
        String sql = "select * from course where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, courseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Course course = new Course();
        while (resultSet.next()) {
            course.setId(resultSet.getInt("id"));
            course.setName(resultSet.getString("name"));
            course.setTeacherId(resultSet.getInt("teacher_id"));
            course.setType(resultSet.getString("type"));
            course.setCredit(resultSet.getInt("credit"));
            course.setTime(resultSet.getInt("time"));
        }
        return course;
    }

    @Override
    public int getId(Connection con, int teacherId, String name) throws SQLException {
        String sql = "select id from course where teacher_id = ? and name = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,teacherId);
        preparedStatement.setString(2,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }
}
