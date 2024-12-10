package com.xworkz.UserCard.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.UserCard.Entity.EmployeeCard;

public class UserCardRepoImpl implements UserCardRepo {

	@Override
	public boolean Save(EmployeeCard card) {
		System.out.println("emoployeeCard:" + card);
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

	@Override
	public List<EmployeeCard> findAll() {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		List<EmployeeCard> employeeCard = new ArrayList<>();

		Query query = eM.createNamedQuery("findAll");
		List<EmployeeCard> list = query.getResultList();
		list.forEach(s -> System.out.println(s));

		try {
			eT.begin();
			eT.commit();
			System.out.println("Data fetched");
		} catch (Exception e) {
			if (eT.isActive()) {
				eT.rollback();
				System.out.println("Transaction rolled back due to an error!");
			}
			e.printStackTrace();
		} finally {

			eM.close();
			eMF.close();
		}
		return list;

	}

	@Override
	public String getNameAndEmailById(int id) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		try {
			Query query = eM.createNamedQuery("getById");
			query.setParameter("id", id);

			Object[] result = (Object[]) query.getSingleResult();
			String name = (String) result[0];
			String email = (String) result[1];
			return "Name: " + name + ", Email: " + email;
		} catch (Exception e) {
			System.out.println("No record found for ID: " + id);
			return null;
		} finally {
			eM.close();
		}
	}

	@Override
	public long getCountByWeight(double weight) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		try {
			Query query = eM.createNamedQuery("getCountByWeight");
			query.setParameter("weight", weight);
			return (long) query.getSingleResult();
		} finally {
			eM.close();
		}
	}

	@Override
	public EmployeeCard getSingleAll(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("getSingleAll");
		query.setParameter("id", id);

		EmployeeCard employeeCard = null;

		try {
			employeeCard = (EmployeeCard) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return employeeCard;
	}
}
