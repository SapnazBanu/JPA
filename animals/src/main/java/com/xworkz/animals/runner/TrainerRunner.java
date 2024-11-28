package com.xworkz.animals.runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.animals.DTO.TrainerDTO;


public class TrainerRunner {
    public static void main(String[] args) {
       
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

       
        List<TrainerDTO> trainers = new ArrayList<>();

        trainers.add(new TrainerDTO("Rajesh Kumar", "rajesh.kumar@example.com", "9876543210", 32, "Java Development", 8));
        trainers.add(new TrainerDTO("Anita Sharma", "anita.sharma@example.com", "9123456789", 28, "Python Development", 5));
        trainers.add(new TrainerDTO("Suresh Reddy", "suresh.reddy@example.com", "9876512345", 35, "Data Science", 10));
        trainers.add(new TrainerDTO("Priya Singh", "priya.singh@example.com", "9123459876", 30, "Web Development", 6));
        trainers.add(new TrainerDTO("Amit Verma", "amit.verma@example.com", "9988776655", 45, "DevOps Engineering", 20));
        trainers.add(new TrainerDTO("Neha Gupta", "neha.gupta@example.com", "7766554433", 29, "UI/UX Design", 4));
        trainers.add(new TrainerDTO("Vijay Patel", "vijay.patel@example.com", "9988112233", 40, "Cloud Computing", 15));
        trainers.add(new TrainerDTO("Ritu Mehra", "ritu.mehra@example.com", "8877665544", 27, "Mobile Development", 3));
        trainers.add(new TrainerDTO("Arjun Rao", "arjun.rao@example.com", "8899001122", 38, "AI and ML", 12));
        trainers.add(new TrainerDTO("Pooja Nair", "pooja.nair@example.com", "2233445566", 26, "Database Administration", 2));

        
        for (TrainerDTO trainer : trainers) {
            System.out.println(trainer);
        }

        try {
          
            eT.begin();

            for (TrainerDTO trainer : trainers) {
                eM.persist(trainer);
            }

           
            eT.commit();
            System.out.println("Trainer data saved successfully!");

        } catch (Exception e) {
            if (eT.isActive()) {
                eT.rollback(); 
                System.out.println("Transaction rolled back due to an error!");
            }
            e.printStackTrace();
        } finally {
           
            eM.close();
            eMF.close(); 
        }
    }
}
