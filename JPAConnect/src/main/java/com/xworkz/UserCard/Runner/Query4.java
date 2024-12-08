package com.xworkz.UserCard.Runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.UserCard.Entity.EmployeeCard;

public class Query4 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createNamedQuery("getSingleAll");
		query.setParameter("id", 9);
		List<EmployeeCard> str = (List<EmployeeCard>)query.getResultList();
		str.forEach(ref->System.out.println(ref));
	}

}