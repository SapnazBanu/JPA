package com.workz.student.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;
import com.xworkz.student.DTO.StudentDTO;

public class StudentRunner1 {
	public static void main(String[] args) {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		try {

			eT.begin();

			List<Integer> idsToDelete = Arrays.asList(1, 3, 5, 7, 9);

			for (Integer id : idsToDelete) {
				StudentDTO student = eM.find(StudentDTO.class, id);
				if (student != null) {
					eM.remove(student); 
					System.out.println("Deleted Student with ID: " + id);
				} else {
					System.out.println("No Student found with ID: " + id);
				}
			}

			eT.commit();
			System.out.println("Selected student rows deleted successfully!");
		} catch (Exception e) {
			if (eT != null && eT.isActive()) {
				eT.rollback(); 
			}
			e.printStackTrace();
		} finally {

			if (eM != null) {
				eM.close();
			}
			if (eMF != null) {
				eMF.close();
			}
		}
	}
}
