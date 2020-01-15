package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import config.Config;

public class MySQLUserDao implements Users {
    private Connection connection;

    public MySQLUserDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getURL(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public User findByUsername(String username){
        String sql = "SELECT * FROM users WHERE username = ?";
        User user;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            user = new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Long insert(User user){
        String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2,user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            return  rs.getLong(1);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0L;
    }

//    public static void main(String args[]){
//        Config config = new Config();
//
//        User test = new MySQLUserDao(config).findByUsername("vtinsey9");
//        System.out.println(test);
//
//        long test2 = new MySQLUserDao(config).insert(new User("eddy", "eddy@codeup.com", "MySuperSecurePassword"));
//        System.out.println(test2);
//    }
}
