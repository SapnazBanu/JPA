package com.xworkz.UserCard.Runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.UserCard.Entity.EmployeeCard;

public class findAll {
	public static void main(String[] args) {
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
	}
}
