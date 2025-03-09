//package org.example.currencyconverterjpa.Datasource;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class MariaDbJpaConnection {
//    private static final String URL = "jdbc:mariadb://localhost:3307/currencydb";
//    private static final String USER = "root";
//    private static final String PASSWORD = "Metropolia05";
//
//    private static Connection connection;
//
//    private MariaDbJpaConnection() {}
//
//    public static Connection getConnection() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            try {
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                System.out.println("Database connected successfully.");
//            } catch (SQLException e) {
//                System.err.println("Failed to connect to database.");
//                e.printStackTrace();
//                throw e;
//            }
//        }
//        return connection;
//    }
//}

package org.example.currencyconverterjpa.Datasource;

import jakarta.persistence.*;

public class MariaDbJpaConnection {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {
        if (em==null) {
            if (emf==null) {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}