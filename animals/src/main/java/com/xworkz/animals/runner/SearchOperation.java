package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.animals.DTO.PetDTO;
import com.xworkz.animals.DTO.WildDTO;

public class SearchOperation {
	public static void main(String[] args) {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager em = eMF.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Integer wildId = 1;
		Integer petId = 1;

		try {
			WildDTO wildDto = em.find(WildDTO.class, wildId);
			if (wildDto != null) {
				System.out.println("Wild Animal Found: " + wildDto.getName());
			} else {
				System.out.println("No Wild Animal found with ID: " + wildId);
			}

			PetDTO petDto = em.find(PetDTO.class, petId);
			if (petDto != null) {
				System.out.println("Pet Found: " + petDto.getName());
			} else {
				System.out.println("No Pet found with ID: " + petId);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			em.close();
			eMF.close();
		}
	}
}
