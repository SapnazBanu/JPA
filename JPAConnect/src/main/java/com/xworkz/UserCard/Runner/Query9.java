package com.xworkz.UserCard.Runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.time.LocalDate;
import java.util.Date;

public class Query9 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createNamedQuery("User.countByEmailAndDate");
            query.setParameter("email", "amit@gmail.com");
            query.setParameter("joiningDate", LocalDate.of(2024,12,26)); 

            Long count = (Long) query.getSingleResult();
            System.out.println("Count of users with the specified email and joining date: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}







