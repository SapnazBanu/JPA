package com.xworkz.travelPlaces.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TravelPlacesDTO {
	
	private int id;
	private String placeName;
	private Long pinCode;

}
