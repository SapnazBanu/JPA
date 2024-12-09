package com.xworkz.UserCard.Entity;

import javax.persistence.Column;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employee_card ")

@NamedQuery(name="findAll", query="SELECT e from EmployeeCard e")

@NamedQuery(name = "getById", query = "SELECT e.name, e.email FROM EmployeeCard e WHERE e.id = :id")

@NamedQuery(name = "getCountByWeight", query = "SELECT COUNT(e) FROM EmployeeCard e WHERE e.weight > :weight")

@NamedQuery(name = "getSingleAll", query = "SELECT e FROM EmployeeCard e WHERE e.id = :id")

@NamedQuery(name = "getAllbyName&Email", query = "SELECT e FROM EmployeeCard e WHERE e.name = :name AND e.email = :email")

@NamedQuery(name = "deleteByByName&isActive", query = "DELETE FROM EmployeeCard e WHERE e.name = :name AND e.isActive = :isactive")

@NamedQuery( name = "update",query = "UPDATE EmployeeCard e SET e.name = :name WHERE e.email = :email AND e.number = :phno")

@NamedQuery(name = "updateByNameAndEmail",query = "UPDATE EmployeeCard e SET e.weight = :weight WHERE e.name = :name AND e.email = :email")

@NamedQuery(name = "User.countByEmailAndDate",query = "SELECT COUNT(u) FROM  EmployeeCard u WHERE u.email = :email AND u.joiningDate = :joiningDate")
public class EmployeeCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_phNumber")
	private Long number;
	
	@Column(name = "user_isActive")
	private boolean isActive;
	
	@Column(name="user_grade")
	private char grade;   
	
	@Column(name = "user_rating")
	private short rating;
	
	@Column(name="user_experienceYears")
	private byte experienceYears;
	
	@Column(name = "user_height")
	private float height;
	
	@Column(name = "user_weight")
	private double weight;
	
	@Column(name="user_joiningDate")
	private LocalDate joiningDate;

	public EmployeeCard() {
		super();
	}

	public EmployeeCard(String name, String email, Long number, boolean isActive, char grade, short rating,
			byte experienceYears, float height, double weight, LocalDate joiningDate) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.isActive = isActive;
		this.grade = grade;
		this.rating = rating;
		this.experienceYears = experienceYears;
		this.height = height;
		this.weight = weight;
		this.joiningDate = joiningDate;
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public byte getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(byte experienceYears) {
		this.experienceYears = experienceYears;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "EmployeeCard [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + ", isActive="
				+ isActive + ", grade=" + grade + ", rating=" + rating + ", experienceYears=" + experienceYears
				+ ", height=" + height + ", weight=" + weight + ", joiningDate=" + joiningDate + "]";
	}   
	

}
