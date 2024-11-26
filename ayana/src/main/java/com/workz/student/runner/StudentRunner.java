package com.workz.student.runner;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.xworkz.student.DTO.StudentDTO;

public class StudentRunner {
	public static void main(String[] args) {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		List<StudentDTO> students = new ArrayList<>();

		students.add(new StudentDTO(1, "Alice", 20, "A", "Mathematics"));
		students.add(new StudentDTO(2, "Bob", 22, "B", "Physics"));
		students.add(new StudentDTO(3, "Charlie", 19, "A", "Chemistry"));
		students.add(new StudentDTO(4, "Diana", 21, "C", "Biology"));
		students.add(new StudentDTO(5, "Ethan", 23, "B", "Computer Science"));
		students.add(new StudentDTO(6, "Fiona", 20, "A", "Mathematics"));
		students.add(new StudentDTO(7, "George", 22, "C", "Physics"));
		students.add(new StudentDTO(8, "Hannah", 19, "B", "English"));
		students.add(new StudentDTO(9, "Ian", 21, "A", "History"));
		students.add(new StudentDTO(10, "Julia", 22, "A", "Economics"));

		for (StudentDTO student : students) {
			System.out.println(student);
		}

		try {
			eT.begin();

			for (StudentDTO student : students) {
				eM.persist(student);
			}
			eT.commit();
			System.out.println("Students data saved successfully!");
		} catch (Exception e) {
			eT.rollback();
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}
