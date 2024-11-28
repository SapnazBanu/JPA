package com.xworkz.animals.runner;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TrainerQuery3 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {
			eT.begin();

			List<String> emails = eM
					.createQuery("SELECT t.email FROM TrainerDTO t WHERE t.name LIKE :sName OR t.name LIKE :nName",
							String.class)
					.setParameter("sName", "S%").setParameter("nName", "N%").getResultList();

			eT.commit();

			if (emails.isEmpty()) {
				System.out.println("No trainers found whose name starts with 'S' or 'N'.");
			} else {
				for (String email : emails) {
					System.out.println("Email: " + email);
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
