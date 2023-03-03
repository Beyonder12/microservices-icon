package com.beyonder.bookservice;

import java.sql.*;

public class JdbcExampleGet {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/book_db"; // JDBC connection URL
        String user = "root"; // database username
        String password = "12345678"; // database password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // create a Statement object to execute SQL queries
            Statement stmt = conn.createStatement();

            // execute a SELECT query and retrieve the results in a ResultSet object
            ResultSet rs = stmt.executeQuery("SELECT * FROM book_entity");

            // iterate over the results and print each row
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("author");
                String age = rs.getString("name");

                System.out.println("ID: " + id + ", Author: " + name + ", Name: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}