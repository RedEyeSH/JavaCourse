package org.example.currencyconverter.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3307/Your_DB";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private static Connection connection;

    private MariaDbConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to connect to database.");
                e.printStackTrace();
                throw e;
            }
        }
        return connection;
    }
}
