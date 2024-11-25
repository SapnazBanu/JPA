package com.xworkz.apple.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.apple.DTO.AppleDTO;

public class AppleRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = emf.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {
			eT.begin();
			AppleDTO dto = new AppleDTO();
			dto.setId(5);
			dto.setColor("green");
			dto.setOrganic(true);
			dto.setPricePerKg(200);
			dto.setWeight(2);
			eM.persist(dto);
			eT.commit();
			System.out.println("Apple data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			eT.rollback();
		} finally {
			eM.close();
			emf.close();
		}
	}
}
