package com.xworkz.animals.runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.animals.DTO.PetDTO;

public class PetRunner {
    public static void main(String[] args) {
 
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

        List<PetDTO> pets = new ArrayList<>();

        pets.add(new PetDTO("Buddy", "Dog", "Labrador", 3, "John Doe", 30.5, "Golden", "MIC123456", true, "2024-11-01"));
        pets.add(new PetDTO("Whiskers", "Cat", "Siamese", 2, "Jane Smith", 4.2, "White", "MIC789012", false, "2024-10-15"));
        pets.add(new PetDTO("Max", "Dog", "Beagle", 4, "Alice Johnson", 25.0, "Brown", "MIC567890", true, "2024-08-20"));
        pets.add(new PetDTO("Bella", "Rabbit", "Dutch", 1, "Ethan Carter", 2.5, "Gray", "MIC345678", false, "2024-07-10"));
        pets.add(new PetDTO("Charlie", "Bird", "Parrot", 5, "Sophia Brown", 1.2, "Green", "MIC234567", true, "2024-06-05"));
        pets.add(new PetDTO("Rocky", "Dog", "Bulldog", 6, "George King", 40.0, "White", "MIC456789", true, "2024-09-18"));
        pets.add(new PetDTO("Shadow", "Cat", "Persian", 3, "Hannah Lee", 3.8, "Black", "MIC678901", false, "2024-05-15"));
        pets.add(new PetDTO("Milo", "Dog", "Golden Retriever", 2, "Ian Collins", 35.0, "Golden", "MIC890123", true, "2024-10-12"));
        pets.add(new PetDTO("Luna", "Cat", "Bengal", 1, "Julia White", 4.0, "Spotted", "MIC012345", false, "2024-03-22"));
        pets.add(new PetDTO("Coco", "Bird", "Cockatoo", 7, "Emma Green", 1.5, "Yellow", "MIC101112", true, "2024-01-05"));

        for (PetDTO pet : pets) {
            System.out.println(pet);
        }

        try {
            eT.begin();

            for (PetDTO pet : pets) {
                eM.persist(pet); 
            }

            eT.commit(); 
            System.out.println("Pets data saved successfully!");

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
