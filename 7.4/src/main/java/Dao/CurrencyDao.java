package Dao;

import jakarta.persistence.*;
import Datasource.MariaDbJpaConnection;
import Entity.Currency;

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
