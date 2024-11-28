package com.xworkz.animals.runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.animals.DTO.WildDTO;

public class WildRunner {
    public static void main(String[] args) {

        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = eMF.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

        List<WildDTO> wildAnimals = new ArrayList<>();

        wildAnimals.add(new WildDTO("Tiger", "Panthera tigris", "Forest", "Carnivore", 5, 220, "Endangered", "Asia", "2024-11-01"));
        wildAnimals.add(new WildDTO("Elephant", "Elephas maximus", "Savanna", "Herbivore", 10, 400.0, "Vulnerable", "Africa", "2024-10-15"));
        wildAnimals.add(new WildDTO("Panda", "Ailuropoda melanoleuca", "Bamboo Forest", "Herbivore", 7, 100.0, "Endangered", "China", "2024-09-20"));
        wildAnimals.add(new WildDTO("Cheetah", "Acinonyx jubatus", "Grassland", "Carnivore", 4, 72.3, "Vulnerable", "Africa", "2024-08-05"));
        wildAnimals.add(new WildDTO("Koala", "Phascolarctos cinereus", "Eucalyptus Forest", "Herbivore", 3, 15.0, "Vulnerable", "Australia", "2024-07-15"));
        wildAnimals.add(new WildDTO("Penguin", "Aptenodytes forsteri", "Ice Caps", "Carnivore", 2, 30.2, "Least Concern", "Antarctica", "2024-06-10"));
        wildAnimals.add(new WildDTO("Wolf", "Canis lupus", "Forest", "Carnivore", 6, 45.0, "Least Concern", "North America", "2024-05-25"));
        wildAnimals.add(new WildDTO("Jaguar", "Panthera onca", "Rainforest", "Carnivore", 8, 95.0, "Near Threatened", "South America", "2024-04-10"));
        wildAnimals.add(new WildDTO("Kangaroo", "Macropus", "Outback", "Herbivore", 3, 85.5, "Least Concern", "Australia", "2024-03-15"));
        wildAnimals.add(new WildDTO("Polar Bear", "Ursus maritimus", "Arctic", "Carnivore", 12, 450.0, "Vulnerable", "Arctic Circle", "2024-02-05"));

        for (WildDTO animal : wildAnimals) {
            System.out.println(animal);
        }

        try {
            eT.begin();

            for (WildDTO animal : wildAnimals) {
                eM.persist(animal);
            }

            eT.commit(); 
            System.out.println("Wild animals data saved successfully!");

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
