package com.lhy.examsystem.dao.students;

import com.lhy.examsystem.model.Students;
import com.lhy.examsystem.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IStudentsDao {
    public List<User> getStudentsList(Connection con) throws SQLException;
}
