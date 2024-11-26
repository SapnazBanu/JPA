package com.xworkz.ring.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ring_table")

public class RingDTO {

	@Id
	private int id;
	private String material;
	private String type;
	private double size;
	private String color;
	
	public RingDTO()
	{
		
	}

	public RingDTO(int id, String material, String type, double size, String color) {
		super();
		this.id = id;
		this.material = material;
		this.type = type;
		this.size = size;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}