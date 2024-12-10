package com.xworkz.UserCard.Repository;

import java.util.List;
import com.xworkz.UserCard.Entity.EmployeeCard;

public interface UserCardRepo {
	boolean Save(EmployeeCard card);
	List<EmployeeCard> findAll();
	String getNameAndEmailById(int id);
	long getCountByWeight(double weight);
	EmployeeCard getSingleAll(int id); 
}
