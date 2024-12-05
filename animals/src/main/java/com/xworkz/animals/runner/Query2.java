package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.xworkz.animals.DTO.TDTO;

public class Query2 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {

			Query query = eM.createNamedQuery("findAll");
			for (Object object : query.getResultList()) {
				TDTO tDTO = (TDTO) object;
				System.out.println("Values: " + tDTO.getAge() + ", " + tDTO.getEmail() + ", " + tDTO.getName());
			}

			eT.begin();
			eT.commit();
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
