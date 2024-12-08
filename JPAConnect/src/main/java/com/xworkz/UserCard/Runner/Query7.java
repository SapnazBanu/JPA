package com.xworkz.UserCard.Runner;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Query7 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			 et.begin();
	            Query query = em.createNamedQuery("update");
	            query.setParameter("name", "Viji");
	            query.setParameter("email", "sapnaz@gmail.com");
	            query.setParameter("phno", 8660286768L);
	            int rowsUpdated = query.executeUpdate();
	            System.out.println("Number of rows updated: " + rowsUpdated);
	            et.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (et.isActive())
				et.rollback();
			em.close();
			emf.close();
		}

	}

}