package com.xworkz.paint.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.paint.DTO.PaintDTO;

public class PaintRunner {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {
			eT.begin();
			PaintDTO dto = new PaintDTO();
			dto.setId(1);
			dto.setColor("peach");
			dto.setBrand("Asian Paints");
			dto.setPrice(250);
			dto.setQuantity(1000);

			eT.commit();
			System.out.println("Paint data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}
