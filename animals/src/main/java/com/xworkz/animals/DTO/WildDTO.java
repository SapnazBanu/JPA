package com.xworkz.animals.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wild_table")
public class WildDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "species")
	private String species;

	@Column(name = "habitat")
	private String habitat;

	@Column(name = "diet")
	private String diet;

	@Column(name = "age")
	private int age;

	@Column(name = "weight")
	private double weight;

	@Column(name = "endangered_status")
	private String endangeredStatus;

	@Column(name = "region_found")
	private String regionFound;

	@Column(name = "last_seen_date")
	private String lastSeenDate;

	public WildDTO() {
	}

	public WildDTO(String name, String species, String habitat, String diet, int age, double weight,
			String endangeredStatus, String regionFound, String lastSeenDate) {
		this.name = name;
		this.species = species;
		this.habitat = habitat;
		this.diet = diet;
		this.age = age;
		this.weight = weight;
		this.endangeredStatus = endangeredStatus;
		this.regionFound = regionFound;
		this.lastSeenDate = lastSeenDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getEndangeredStatus() {
		return endangeredStatus;
	}

	public void setEndangeredStatus(String endangeredStatus) {
		this.endangeredStatus = endangeredStatus;
	}

	public String getRegionFound() {
		return regionFound;
	}

	public void setRegionFound(String regionFound) {
		this.regionFound = regionFound;
	}

	public String getLastSeenDate() {
		return lastSeenDate;
	}

	public void setLastSeenDate(String lastSeenDate) {
		this.lastSeenDate = lastSeenDate;
	}
}
