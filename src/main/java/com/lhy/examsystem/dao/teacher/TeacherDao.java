package com.lhy.examsystem.dao.teacher;

import com.lhy.examsystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao implements ITeacherDao {

    @Override
    public List<User> getTeacherList(Connection con) throws SQLException {
        String sql = "select * from user where user_role = 'teacher'";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> teacherList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setAccount(resultSet.getString("account"));
            user.setPassword(resultSet.getString("password"));
            user.setUserRole(resultSet.getString("user_role"));
            user.setName(resultSet.getString("name"));
            user.setGender(resultSet.getInt("gender"));
            user.setAge(resultSet.getInt("age"));
            user.setPhone(resultSet.getString("phone"));
            teacherList.add(user);
        }
        return teacherList;
    }
}
