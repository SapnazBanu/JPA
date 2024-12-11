package com.xworkz.acer.service;

import java.util.List;

import com.xworkz.acer.Repo.AcerRepo;
import com.xworkz.acer.Repo.AcerRepoImpl;
import com.xworkz.acer.entity.AcerEntity;

public class AcerServiceImpl implements AcerService {

	@Override
	public List<AcerEntity> getproductNameById(int id) {

		AcerRepo ref = new AcerRepoImpl();
		List<AcerEntity> list = ref.getproductNameById(id);
		return list;
	}

	@Override
	public List<Object[]> getBrandNameAndPriceByPhoneNumber(long pohone_no) {
		AcerRepo ref = new AcerRepoImpl();
		List<Object[]> ref2=ref.getBrandNameAndPriceByPhoneNumber(pohone_no);
		return ref2;
	}

}
