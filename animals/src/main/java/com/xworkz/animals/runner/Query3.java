package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import com.xworkz.animals.DTO.TDTO;

public class Query3 {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

        try {
            Query query = eM.createNamedQuery("findByAgeGreaterThan");
            query.setParameter("age", 15);
            
            List<Object[]> results = query.getResultList();
            
            System.out.println("Name and Phone where age > 15:");
            for (Object[] result : results) {
                String name = (String) result[0]; 
                String ph = (String) result[1];  
                System.out.println("Name: " + name + ", Phone: " + ph);
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

