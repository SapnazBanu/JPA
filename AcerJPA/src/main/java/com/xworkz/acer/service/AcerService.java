package com.xworkz.acer.service;

import java.util.List;
import com.xworkz.acer.entity.AcerEntity;

public interface AcerService {

	List<AcerEntity> getproductNameById(int id);
	 List<Object[]> getBrandNameAndPriceByPhoneNumber(long pohone_no);
}
