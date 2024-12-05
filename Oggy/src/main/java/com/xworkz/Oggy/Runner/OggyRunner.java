package com.xworkz.Oggy.Runner;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.Oggy.Entity.Oggy;



public class OggyRunner {
    public static void main(String[] args) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

      
        List<Oggy> oggyList = new ArrayList<>();

        oggyList.add(new Oggy("Oggy", 25, 50.5, 'A', true, 300L, 5.7f, (byte) 3, (short) 95, "Pizza"));
        oggyList.add(new Oggy("Jack", 28, 70.2, 'B', false, 200L, 5.9f, (byte) 4, (short) 90, "Burger"));
        oggyList.add(new Oggy("Viji", 30, 65.2, 'C', false, 300L, 6.9f, (byte) 2, (short) 80, "Momos"));
        oggyList.add(new Oggy("Sapna", 26, 55.2, 'D', true, 150L, 3.9f, (byte) 4, (short) 60, "Kunafa"));

        for (Oggy oggy : oggyList) {
            System.out.println(oggy);
        }

        try {
            et.begin();
            for (Oggy oggy : oggyList) {
                em.persist(oggy);
            }
            et.commit();
            System.out.println("Oggy data saved successfully!");

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
                System.out.println("Transaction rolled back due to an error!");
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

