package com.xworkz.fan.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fan_table")
public class FanDTO {
	@Id
	private int id;
	private String brand;
	private int speed;
	private boolean isRemoteControlled;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isRemoteControlled() {
		return isRemoteControlled;
	}

	public void setRemoteControlled(boolean isRemoteControlled) {
		this.isRemoteControlled = isRemoteControlled;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
