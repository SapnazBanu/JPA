package com.xworkz.paper.runner;

import java.beans.PersistenceDelegate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.paper.DTO.PaperDTO;

public class PaperRunner {
	public static void main(String[] args) {
		EntityManagerFactory eMF=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM=eMF.createEntityManager();
		EntityTransaction eT=eM.getTransaction();
		
		try
		{
			eT.begin();
			PaperDTO dto=new PaperDTO();
		    dto.setId(3);
		    dto.setBrand("Natraja");
		    dto.setColor("Pink");
		    dto.setPrice(10);
		    dto.setLocation("Bengaluru");
		    eM.persist(dto);
		    eT.commit();
            System.out.println("Paper data saved successfully!");
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}

			
	