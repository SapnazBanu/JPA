package com.xworkz.fan.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.fan.DTO.FanDTO;

public class FanRunner {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {
			eT.begin();
			FanDTO dto = new FanDTO();
			dto.setId(5);
			dto.setBrand("Bajaj");
			dto.setPrice(1000);
			dto.setRemoteControlled(true);
			dto.setSpeed(500);
			eM.persist(dto);
			eT.commit();
			System.out.println("Fan data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}
