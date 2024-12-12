package com.xworkz.travelPlaces.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@Entity
@RequiredArgsConstructor
@Table(name="TravelPlaces_Table")
public class TravelPlacesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name="place_Name")
	private String placeName;
	
	@Column (name="pin_Code")
	private Long pinCode;
}
