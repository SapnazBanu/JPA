package com.xworkz.travelPlaces.service;

import com.xworkz.travelPlaces.dto.TravelPlacesDTO;
import com.xworkz.travelPlaces.entity.TravelPlacesEntity;
import com.xworkz.travelPlaces.repository.TravelPlacesRepo;
import com.xworkz.travelPlaces.repository.TravelPlacesRepoImpl;

public class TravelPlacesServiceImpl implements TravelPlacesService {

	@Override
	public boolean save(TravelPlacesDTO dto) {
		System.out.println("dto inservice==" + dto.toString());

		TravelPlacesEntity entity = new TravelPlacesEntity();
		entity.setPlaceName(dto.getPlaceName());
		entity.setPinCode(dto.getPinCode());
		TravelPlacesRepo repo = new TravelPlacesRepoImpl();
		repo.save(entity);
		System.out.println("entity:" + entity.toString());
		return false;
	}

}
