package com.xworkz.UserCard.Service;

import com.xworkz.UserCard.Entity.EmployeeCard;
import com.xworkz.UserCard.Repository.UserCardRepo;
import com.xworkz.UserCard.Repository.UserCardRepoImpl;

public class UserCardServiceImpl implements UserCardService {
	@Override
	public boolean save(EmployeeCard card) {
		System.out.println("EmployeeCard:"+card.toString());
		UserCardRepo repo=new UserCardRepoImpl();
		repo.Save(card);
		return false;
	}
}
