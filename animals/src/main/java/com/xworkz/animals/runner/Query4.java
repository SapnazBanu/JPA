package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import com.xworkz.animals.DTO.TDTO;

public class Query4 {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

        try {
           
            Query query = eM.createNamedQuery("findByNameStartsWithSOrN");
            query.setParameter("prefix1", "S%");  
            query.setParameter("prefix2", "N%");  
         
            List<String> emails = query.getResultList();
            
            System.out.println("Emails where name starts with 'S' or 'N':");
            for (String email : emails) {
                System.out.println("Email: " + email);
            }

            eT.begin();
            eT.commit();
        } catch (Exception e) {
            if (eT.isActive()) {
                eT.rollback();
            }
            e.printStackTrace();
        } finally {
            eM.close();
            eMF.close();
        }
    }
}
