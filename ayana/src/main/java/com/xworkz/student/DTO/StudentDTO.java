package com.xworkz.student.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="new_table")
public class StudentDTO {
	@Id
	private int id;
	private String name;
	private int age;
	private String grade;
	private String subject;

	public StudentDTO() {
	}

	public StudentDTO(int id, String name, int age, String grade, String subject) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.subject = subject;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
