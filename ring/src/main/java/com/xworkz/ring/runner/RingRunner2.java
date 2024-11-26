package com.xworkz.ring.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.ring.DTO.RingDTO;

public class RingRunner2 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		
		try {
			eT.begin();
			RingDTO ring=eM.find(RingDTO.class,5);
			eM.remove(ring);
			eT.commit();
			System.out.println("Ring data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}
