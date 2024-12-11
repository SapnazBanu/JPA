package com.xworkz.acer.runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.acer.entity.AcerEntity;

public class AcerRunner {
    public static void main(String[] args) {
       
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();
        List<AcerEntity> acerEntities = new ArrayList<>();
        acerEntities.add(new AcerEntity("Laptop", "Lenovo-", 50000, true, 866028678L));
        acerEntities.add(new AcerEntity("Desktop", "Acer-", 45000, false, 8695325758L));
        acerEntities.add(new AcerEntity("Desktop", "HP-", 30000, true, 5698622856L));
        acerEntities.add(new AcerEntity("Laptop", "Acus-", 42000, false, 7856932514L));
        acerEntities.add(new AcerEntity("Laptop", "Victus-", 48000, true, 5698632654L));
        

        try {
            eT.begin();
            for (AcerEntity entity : acerEntities) {
                eM.persist(entity);
            }
            eT.commit();
            System.out.println("Acer data saved successfully!");

        } catch (Exception e) {
            if (eT.isActive()) {
                eT.rollback();
                System.out.println("Transaction rolled back due to an error!");
            }
            e.printStackTrace();
        } finally {
            if (eM != null) {
                eM.close();
            }
            if (eMF != null) {
                eMF.close();
            }
        }
    }
}


