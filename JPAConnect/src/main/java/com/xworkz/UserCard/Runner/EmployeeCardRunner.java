package com.xworkz.UserCard.Runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.xworkz.UserCard.Entity.EmployeeCard;

public class EmployeeCardRunner {

	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		List<EmployeeCard> employeeCard = new ArrayList<>();

		
		employeeCard.add(new EmployeeCard("Sapnaz", "sapnaz@gmail.com", 8660286768L, true, 'A', (short) 4, (byte) 2, 5.0f, 38.0, LocalDate.of(2024, 12, 20)));
		employeeCard.add(new EmployeeCard("Ravi", "ravi@gmail.com", 9940286721L, false, 'B', (short) 5, (byte) 3, 6.5f, 42.0, LocalDate.of(2024, 12, 21)));
		employeeCard.add(new EmployeeCard("Priya", "priya@gmail.com", 9170845643L, true, 'C', (short) 3, (byte) 1, 7.2f, 36.5, LocalDate.of(2024, 12, 22)));
		employeeCard.add(new EmployeeCard("Mohan", "mohan@gmail.com", 9345678901L, true, 'A', (short) 6, (byte) 4, 8.0f, 40.0, LocalDate.of(2024, 12, 23)));
		employeeCard.add(new EmployeeCard("Anita", "anita@gmail.com", 9023456789L, false, 'B', (short) 2, (byte) 2, 4.5f, 35.0, LocalDate.of(2024, 12, 24)));
		employeeCard.add(new EmployeeCard("Kiran", "kiran@gmail.com", 9098765432L, true, 'C', (short) 7, (byte) 3, 6.0f, 41.0, LocalDate.of(2024, 12, 25)));
		employeeCard.add(new EmployeeCard("Amit", "amit@gmail.com", 9912345670L, false, 'A', (short) 4, (byte) 1, 5.5f, 37.0, LocalDate.of(2024, 12, 26)));
		employeeCard.add(new EmployeeCard("Nisha", "nisha@gmail.com", 9156784321L, true, 'B', (short) 3, (byte) 2, 7.8f, 39.0, LocalDate.of(2024, 12, 27)));
		employeeCard.add(new EmployeeCard("Vinay", "vinay@gmail.com", 9008765432L, false, 'C', (short) 6, (byte) 4, 6.3f, 43.0, LocalDate.of(2024, 12, 28)));
		employeeCard.add(new EmployeeCard("Deepa", "deepa@gmail.com", 8887654321L, true, 'A', (short) 5, (byte) 3, 6.7f, 38.5, LocalDate.of(2024, 12, 29)));
		employeeCard.add(new EmployeeCard("Suresh", "suresh@gmail.com", 9801234567L, false, 'B', (short) 2, (byte) 1, 5.2f, 34.0, LocalDate.of(2024, 12, 30)));

		try {
			eT.begin();
			for (EmployeeCard card : employeeCard) {
				eM.persist(card);
				System.out.println(card);
			}
			eT.commit();

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
