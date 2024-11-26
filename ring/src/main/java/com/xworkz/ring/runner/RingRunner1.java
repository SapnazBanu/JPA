package com.xworkz.ring.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.ring.DTO.RingDTO;

public class RingRunner1 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		
		RingDTO dto1=new RingDTO(1,"gold","Wedding",28,"gold");
		RingDTO dto2=new RingDTO(2,"silver","Wedding",20,"white");
		RingDTO dto3=new RingDTO(3,"rosegold","engagement",22,"pink");
		RingDTO dto4=new RingDTO(4,"diamond","Wedding",28,"gold");
		RingDTO dto5=new RingDTO(5,"gold","Wedding",22,"pink");
		RingDTO dto6=new RingDTO(6,"silver","Wedding",18,"green");
		RingDTO dto7=new RingDTO(7,"gold","Wedding",24,"red");
		RingDTO dto8=new RingDTO(8,"gold","Wedding",26,"blue");
		RingDTO dto9=new RingDTO(9,"silver","Wedding",23,"yellow");
		RingDTO dto10=new RingDTO(10,"diamond","engagement",19,"brown");

		try {
			eT.begin();			
			eM.persist(dto1);
			eM.persist(dto2);
			eM.persist(dto3);
			eM.persist(dto4);
			eM.persist(dto5);
			eM.persist(dto6);
			eM.persist(dto7);
			eM.persist(dto8);
			eM.persist(dto9);
			eM.persist(dto10);
			
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


