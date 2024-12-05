package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Query5{
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

        try {
           
            eT.begin();

           
            Query query = eM.createQuery("UPDATE TDTO t SET t.name = :newName, t.email = :newEmail WHERE t.ph = 9123459876");
            query.setParameter("newName", "UpdatedName");  
            query.setParameter("newEmail", "updatedemail@example.com"); 
            query.setParameter("emptyPh", "");  

           
            int updatedCount = query.executeUpdate();
            System.out.println("Number of records updated: " + updatedCount);

            
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
