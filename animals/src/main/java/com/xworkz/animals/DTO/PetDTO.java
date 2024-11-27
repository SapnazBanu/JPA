package com.xworkz.animals.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets_table")
public class PetDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "species")
	private String species;

	@Column(name = "breed")
	private String breed;

	@Column(name = "age")
	private int age;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "weight")
	private double weight;

	@Column(name = "color")
	private String color;

	@Column(name = "microchip_id")
	private String microchipId;

	@Column(name = "vaccination_status")
	private boolean vaccinationStatus;

	@Column(name = "last_checkup_date")
	private String lastCheckupDate;

	public PetDTO(String name, String species, String breed, int age, String ownerName, double weight, String color,
			String microchipId, boolean vaccinationStatus, String lastCheckupDate) {
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.ownerName = ownerName;
		this.weight = weight;
		this.color = color;
		this.microchipId = microchipId;
		this.vaccinationStatus = vaccinationStatus;
		this.lastCheckupDate = lastCheckupDate;
	}

	public PetDTO() {
		super();
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMicrochipId() {
		return microchipId;
	}

	public void setMicrochipId(String microchipId) {
		this.microchipId = microchipId;
	}

	public boolean isVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(boolean vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public String getLastCheckupDate() {
		return lastCheckupDate;
	}

	public void setLastCheckupDate(String lastCheckupDate) {
		this.lastCheckupDate = lastCheckupDate;
	}
}
