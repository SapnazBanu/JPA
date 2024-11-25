package com.xworkz.stove.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.stove.DTO.StoveDTO1;

public class StoveRunner2 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {
			eT.begin();
			StoveDTO1 dto = new StoveDTO1();
			dto.setStoveId(3);
			dto.setElectricStove(true);
			dto.setStoveBrand("Pooja");
			dto.setStovePrice(2000);
			dto.setTotalBurners(2);
			eM.merge(dto);
			eT.commit();
			System.out.println("Stove data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}