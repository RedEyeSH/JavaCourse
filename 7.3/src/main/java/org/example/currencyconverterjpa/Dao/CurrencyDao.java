//package org.example.currencyconverterjpa.Dao;
//
//import org.example.currencyconverterjpa.Datasource.MariaDbJpaConnection;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CurrencyDao {
//    public List<String> getAllCurrencyAbbreviations() {
//        List<String> currencyAbbreviations = new ArrayList<>();
//        String query = "SELECT abbreviation FROM currency";
//
//        try (Connection conn = MariaDbJpaConnection.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                currencyAbbreviations.add(rs.getString("abbreviation"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return currencyAbbreviations;
//    }
//
//    public double getExchangeRate(String abbreviation) {
//        String query = "SELECT exchange_rate FROM currency WHERE abbreviation = ?";
//        try (Connection conn = MariaDbJpaConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//
//            stmt.setString(1, abbreviation);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return rs.getDouble("exchange_rate");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return 0;
//    }
//}

//package org.example.currencyconverterjpa.Dao;
//
//import jakarta.persistence.*;
//import org.example.currencyconverterjpa.Entity.Currency;
//
//import java.util.List;
//
//public class CurrencyDao {
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CurrencyPU");
//
//    public CurrencyDao() {}
//
//    public Currency getCurrency(String abbreviation) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :abbr", Currency.class);
//            query.setParameter("abbr", abbreviation);
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<Currency> getAllCurrencies() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
//        } finally {
//            em.close();
//        }
//    }
//
//    public void insertCurrency(Currency currency) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            em.persist(currency);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }
//}

package org.example.currencyconverterjpa.Dao;

import jakarta.persistence.*;
import org.example.currencyconverterjpa.Entity.Currency;
import org.example.currencyconverterjpa.Datasource.MariaDbJpaConnection;

import java.util.List;

public class CurrencyDao {

    public Currency getCurrency(String abbreviation) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :abbr", Currency.class);
            query.setParameter("abbr", abbreviation);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Currency> getAllCurrencies() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
    }

    public void insertCurrency(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(currency);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }
}
