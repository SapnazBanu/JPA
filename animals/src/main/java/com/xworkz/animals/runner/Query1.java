package com.xworkz.animals.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.animals.DTO.TDTO;

public class Query1 {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		Query query1 = eM.createNamedQuery("findByName");
		Object obj1 = query1.getSingleResult();
		TDTO dto1 = (TDTO) obj1;
		System.out.println("Value1 : " + dto1.getName());
		System.out.println("--------------");

		Query query2 = eM.createNamedQuery("findById");
		Object obj2 = query2.getSingleResult();
		TDTO dto2 = (TDTO) obj2;
		System.out.println("Value2 : " + dto2.getEmail() + dto2.getId());
		System.out.println("---------------");

		Query query3 = eM.createNamedQuery("findByAgeAndPhoneNo");
		Object obj3 = query3.getSingleResult();
		TDTO dto3 = (TDTO) obj3;
		System.out.println("Value3 : " + dto3.getName());
		System.out.println("----------------");

		Query query4 = eM.createNamedQuery("findBySpecialization");
		query4.setParameter("specialization", "Database Administration");
		Object result = query4.getSingleResult();
		System.out.println("value 4:" + result);
		System.out.println("---------------");

		Query query5 = eM.createNamedQuery("findByExperienceYear");
		Object obj5 = query5.getSingleResult();
		TDTO dto5 = (TDTO) obj5;
		System.out.println("Value5 : " + dto5.toString());
		System.out.println("---------------");
		try {
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
