package com.xworkz.animals.runner;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TrainerQuery2 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {
			eT.begin();

			List<Object[]> results = eM
					.createQuery("SELECT t.name, t.phoneNo FROM TrainerDTO t WHERE t.age > :ageLimit", Object[].class)
					.setParameter("ageLimit", 15).getResultList();

			eT.commit();
			if (results.isEmpty()) {
				System.out.println("No trainers found with age greater than 15.");
			} else {
				for (Object[] result : results) {
					System.out.println("Name: " + result[0] + ", Phone: " + result[1]);
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
