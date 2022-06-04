package com.lhy.examsystem.dao.user;

import com.lhy.examsystem.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public boolean login(Connection con, String account, String password) throws SQLException;

    public boolean register(Connection con,  User user) throws SQLException;

    public User getUserByAccount(Connection con, String account) throws SQLException;

    public String getUserRole(Connection con, String account) throws SQLException;

    public int getUserIdByAccount(Connection con, String account) throws SQLException;

    public List<User> getUserByCourse(Connection con,int courseId) throws SQLException;

    public List<User> findAll(Connection con) throws SQLException;

}
