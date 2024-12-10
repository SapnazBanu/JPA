package com.xworkz.UserCard.Service;

import java.util.List;

import com.xworkz.UserCard.Entity.EmployeeCard;
import com.xworkz.UserCard.Repository.UserCardRepo;
import com.xworkz.UserCard.Repository.UserCardRepoImpl;

public class UserCardServiceImpl implements UserCardService {

	@Override
	public boolean save(EmployeeCard card) {
		System.out.println("EmployeeCard:" + card.toString());
		UserCardRepo repo = new UserCardRepoImpl();
		repo.Save(card);
		return false;
	}

	@Override
	public List<EmployeeCard> findAll() {
		UserCardRepo repo = new UserCardRepoImpl();
		repo.findAll();
		return null;
	}

	@Override
	public String getNameAndEmailById(int id) {
		UserCardRepo repo = new UserCardRepoImpl();
		return repo.getNameAndEmailById(id);
	}

	@Override
	public long getCountByWeight(double weight) {
		UserCardRepo repo = new UserCardRepoImpl();
		return repo.getCountByWeight(weight);
	}

	@Override
	public EmployeeCard getSingleAll(int id) {
		UserCardRepo repo = new UserCardRepoImpl();
		return repo.getSingleAll(id);
	}
}
