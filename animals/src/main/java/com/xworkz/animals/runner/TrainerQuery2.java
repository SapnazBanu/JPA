package com.xworkz.animals.runner;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.animals.DTO.TrainerDTO;

public class TrainerQuery2 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		
		try {
			eT.begin();

			List<TrainerDTO> results = eM
					.createQuery("SELECT t FROM TrainerDTO t WHERE t.age > :ageLimit", TrainerDTO.class)
					.setParameter("ageLimit", 15).getResultList();

			eT.commit();
			if (results.isEmpty()) {
				System.out.println("No trainers found with age greater than 15.");
			} else {
				for (TrainerDTO result : results) {
					System.out.println("Name: " + result.getName() + ", Phone: " + result.getPhoneNo());
				}
			}

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
