package com.xworkz.animals.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "trainer_table")
@NamedQuery(name="findByName",query="Select dto from TDTO dto where dto.name='Priya Singh'")
@NamedQuery(name="findById",query="Select dto from TDTO dto where dto.email='neha.gupta@example.com'")
@NamedQuery(name = "findByAgeAndPhoneNo", query = "select dto from TDTO dto where dto.id=5")
@NamedQuery(name = "findBySpecialization", query = "SELECT dto FROM TDTO dto WHERE dto.specialization = :specialization")
@NamedQuery(name="findByExperienceYear",query ="select dto from TDTO dto where dto.name='Rajesh Kumar' ")

public class TDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "phone_no", nullable = false, unique = true)
	private String phoneNo;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "experience_years", nullable = false)
	private int experienceYears;

	public TDTO() {
	}

	public TDTO(String name, String email, String phoneNo, int age, String specialization, int experienceYears) {
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.age = age;
		this.specialization = specialization;
		this.experienceYears = experienceYears;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	@Override
	public String toString() {
		return "TrainerDTO {" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phoneNo='"
				+ phoneNo + '\'' + ", age=" + age + ", specialization='" + specialization + '\'' + ", experienceYears="
				+ experienceYears + '}';
	}
}
