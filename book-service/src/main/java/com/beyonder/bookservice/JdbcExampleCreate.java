package com.beyonder.bookservice;

import java.sql.*;

public class JdbcExampleCreate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/book_db";
        String user = "root";
        String password = "12345678";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO book_entity (author, name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // set the values of the parameters in the prepared statement
            stmt.setString(1, "John");
            stmt.setString(2, "Joko");

            // execute the statement to insert the new record
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





