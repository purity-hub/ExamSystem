package com.lhy.examsystem.dao.user;

import com.lhy.examsystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean login(Connection con,String account, String password) throws SQLException {
        String sql = "select * from user where account = ? and password = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,account);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            return true;
        }
        return false;
    }

    @Override
    public boolean register(Connection con, User user) throws SQLException {
        String sql = "insert into user(account,password,user_role,create_time,name,gender,age,phone) values(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,user.getAccount());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getUserRole());
        preparedStatement.setTimestamp(4,user.getCreateTime());
        preparedStatement.setString(5,user.getName());
        preparedStatement.setInt(6,user.getGender());
        preparedStatement.setInt(7,user.getAge());
        preparedStatement.setString(8,user.getPhone());
        int i = preparedStatement.executeUpdate();
        if (i > 0){
            return true;
        } else {
            return false;
        }
    }
/**查询用户通过账户名*/
    @Override
    public User getUserByAccount(Connection con, String account) throws SQLException {
        String sql = "select * from user where account = ?";
        User user = new User();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,account);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setAccount(resultSet.getString("account"));
            user.setPassword(resultSet.getString("password"));
            user.setUserRole(resultSet.getString("user_role"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setName(resultSet.getString("name"));
            user.setGender(resultSet.getInt("gender"));
            user.setAge(resultSet.getInt("age"));
            user.setPhone(resultSet.getString("phone"));
        }
        return user;
    }

    /**查询用户所属类别*/
    @Override
    public String getUserRole(Connection con, String account) throws SQLException {
        String UserRole = "";
        String sql = "select user_role from user where account = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,account);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            UserRole = resultSet.getString("user_role");
        }
        return UserRole;
    }

    @Override
    public int getUserIdByAccount(Connection con, String account) throws SQLException {
        String sql = "select id from user where account = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,account);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }

    @Override
    public List<User> getUserByCourse(Connection con,int courseId) throws SQLException {
        String sql = "select * from user,course,user_course where user.id = user_course.user_id and course.id = user_course.course_id and course.id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,courseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setAccount(resultSet.getString("account"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setGender(resultSet.getInt("gender"));
            user.setAge(resultSet.getInt("age"));
            user.setPhone(resultSet.getString("phone"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAll(Connection con) throws SQLException {
        String sql = "select * from user";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setAccount(resultSet.getString("account"));
            user.setPassword(resultSet.getString("password"));
            user.setUserRole(resultSet.getString("user_role"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setName(resultSet.getString("name"));
            user.setGender(resultSet.getInt("gender"));
            user.setAge(resultSet.getInt("age"));
            user.setPhone(resultSet.getString("phone"));
            userList.add(user);
        }
        return userList;
    }


}
