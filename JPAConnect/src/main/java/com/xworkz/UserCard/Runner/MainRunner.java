package com.xworkz.UserCard.Runner;

import java.time.LocalDate;

import com.xworkz.UserCard.Entity.EmployeeCard;
import com.xworkz.UserCard.Service.UserCardService;
import com.xworkz.UserCard.Service.UserCardServiceImpl;

public class MainRunner {
	public static void main(String[] args) {
		EmployeeCard emoployeeCard = new EmployeeCard("Ani", "ani@gmail.com", 8792647552L, true, 'A', (short) 6,
				(byte) 4, 8.0f, 35.0, LocalDate.of(2024, 12, 23));

		UserCardService service = new UserCardServiceImpl();
		service.save(emoployeeCard);
	}
}