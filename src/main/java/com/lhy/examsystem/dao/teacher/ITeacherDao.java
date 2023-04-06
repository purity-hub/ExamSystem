package com.lhy.examsystem.dao.teacher;

import com.lhy.examsystem.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ITeacherDao {
    public List<User> getTeacherList(Connection con) throws SQLException;
}
