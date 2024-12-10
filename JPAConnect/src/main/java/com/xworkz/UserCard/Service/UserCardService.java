package com.xworkz.UserCard.Service;

import com.xworkz.UserCard.Entity.EmployeeCard;

import java.util.List;

public interface UserCardService {
	boolean save(EmployeeCard card);

	List<EmployeeCard> findAll();

	String getNameAndEmailById(int id);

	long getCountByWeight(double weight);

	EmployeeCard getSingleAll(int id); 
}
