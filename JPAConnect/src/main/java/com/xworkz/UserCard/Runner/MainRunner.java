package com.xworkz.UserCard.Runner;

import java.time.LocalDate;
import com.xworkz.UserCard.Entity.EmployeeCard;
import com.xworkz.UserCard.Service.UserCardService;
import com.xworkz.UserCard.Service.UserCardServiceImpl;

import java.util.List;

public class MainRunner {
	public static void main(String[] args) {
//		EmployeeCard emoployeeCard = new EmployeeCard("Ani", "ani@gmail.com", 8792647552L, true, 'A', (short) 6,
//				(byte) 4, 8.0f, 35.0, LocalDate.of(2024, 12, 23));
//
//		UserCardService service = new UserCardServiceImpl();
//		service.save(emoployeeCard);

		UserCardService service = new UserCardServiceImpl();
		service.findAll();
		
		
		int searchId = 10;
		System.out.println("Fetching name and email for ID: " + searchId);
		String result = service.getNameAndEmailById(searchId);
		if (result != null) {
			System.out.println(result);
		} else {
			System.out.println("No record found for ID: " + searchId);
		}
		
		double weight = 40.0;
		long count = service.getCountByWeight(weight);
		System.out.println("Number of EmployeeCards with weight greater than " + weight + ": " + count);

		UserCardService userCardService = new UserCardServiceImpl();
        EmployeeCard employeeCard = userCardService.getSingleAll(1);
        if (employeeCard != null) {
            System.out.println(employeeCard); 
        } else {
            System.out.println("Employee with the given ID not found.");
        }
	}
}
