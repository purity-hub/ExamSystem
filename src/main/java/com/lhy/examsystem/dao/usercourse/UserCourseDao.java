package com.lhy.examsystem.dao.usercourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCourseDao implements IUserCourseDao {

    @Override
    public void deleteUserCourse(Connection con, int userId,int courseId) throws SQLException {
        String sql = "delete from user_course where user_id = ? and course_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, courseId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void addUserCourse(Connection con, int userId, int courseId) throws SQLException {
        String sql = "insert into user_course(user_id,course_id) values(?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, courseId);
        preparedStatement.executeUpdate();
    }
}
