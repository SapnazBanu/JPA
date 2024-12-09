package com.xworkz.UserCard.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.UserCard.Entity.EmployeeCard;

public class UserCardRepoImpl implements UserCardRepo{

	@Override
	public boolean Save(EmployeeCard card) {
		System.out.println("emoployeeCard:"+card);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
			try {
				et.begin();
				em.persist(card);
				et.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (et.isActive()) {
					et.rollback();
				}
			} finally {
				em.close();
				emf.close();
			}
		
		return false;
	}
}
	


