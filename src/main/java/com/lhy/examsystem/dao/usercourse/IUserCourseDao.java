package com.lhy.examsystem.dao.usercourse;

import java.sql.Connection;
import java.sql.SQLException;

public interface IUserCourseDao {
    public void deleteUserCourse(Connection con,int userId,int courseId) throws SQLException;

    public void addUserCourse(Connection con,int userId,int courseId) throws SQLException;
}
