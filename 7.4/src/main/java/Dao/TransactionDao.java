package Dao;

import Entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TransactionDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");

    public void saveTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
        em.close();
    }
}
