package com.example.demo.jdbc;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://8.129.27.209:3306/test?characterEncoding=utf-8",
                    "root", "12345678");

            String sql = "select * from user where username = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "tom");
            resultSet = preparedStatement.executeQuery();

            User user = new User();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String birthday = resultSet.getString("birthday");

                user.setId(id);
                user.setUsername(username);
                user.setBirthday(birthday);


            }

            System.out.println(user);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement!=null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
