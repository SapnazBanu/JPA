package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TrainerQuery1 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try { 
			eT.begin();

			int updatedRows = eM.createQuery(
					"UPDATE TrainerDTO t SET t.name = :newName, t.email = :newEmail WHERE t.phoneNo = '8899001122' OR t.phoneNo IS NULL")
					.setParameter("newName", "Sapnaz Banu").setParameter("newEmail", "sapnaz@example.com")
					.executeUpdate();

			eT.commit();

			if (updatedRows > 0) {
				System.out.println("Number of trainers updated: " + updatedRows);
			} else {
				System.out.println("Number of trainers is not updated");
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
