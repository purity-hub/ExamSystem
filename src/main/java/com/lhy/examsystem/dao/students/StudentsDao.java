package com.lhy.examsystem.dao.students;

import com.lhy.examsystem.model.Students;
import com.lhy.examsystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao implements IStudentsDao {

    @Override
    public List<User> getStudentsList(Connection con) throws SQLException {
        String sql = "select * from user where user_role = 'student'";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> studentsList = new ArrayList<>();
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
            studentsList.add(user);
        }
        return studentsList;
    }
}
