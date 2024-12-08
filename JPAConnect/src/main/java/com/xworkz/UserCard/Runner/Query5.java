package com.xworkz.UserCard.Runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.UserCard.Entity.EmployeeCard;

public class Query5 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createNamedQuery("getAllbyName&Email");
		query.setParameter("name", "Suresh");
		query.setParameter("email", "suresh@gmail.com");

		List<EmployeeCard> li = query.getResultList();
		li.forEach(ref->System.out.println(ref));
	}

}