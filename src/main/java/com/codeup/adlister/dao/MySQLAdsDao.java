package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.Config;


public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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

    @Override
    public List<Ad> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            //Statement stmt = connection.createStatement();
            String sql = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

//    private String createInsertQuery(Ad ad) {
////        return "INSERT INTO ads(user_id, title, description) VALUES "
////            + "(" + ad.getUserId() + ", "
////            + "'" + ad.getTitle() +"', "
////            + "'" + ad.getDescription() + "')";
//
//
//        try {
//            String sql = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, ad.getUserId());
//            stmt.setString(2, ad.getTitle());
//            stmt.setString(3, ad.getDescription());
//
//            System.out.println(stmt.toString());
//            return stmt.toString();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return "";
//        }
//
//    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

//    public static void main(String args[]){
//        Config config = new Config();
//        List<Ad> ads = new MySQLAdsDao(config).all();
//        for(Ad ad: ads){
//            System.out.println(ad);
//        }
//
////        Ad test = new Ad(1,"My Title", "desc'); DROP TABLE users");
////        Long testLong = new MySQLAdsDao(config).insert(test);
////        System.out.println(testLong);
//    }
}
