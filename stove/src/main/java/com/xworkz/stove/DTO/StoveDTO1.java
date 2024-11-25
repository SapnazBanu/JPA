package com.xworkz.stove.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stove_table")
public class StoveDTO1 {

	@Id
	@Column(name = "stove_id")
	private int stoveId;

	@Column(name = "brand_name")
	private String stoveBrand;

	@Column(name = "burner_count")
	private int totalBurners;

	@Column(name = "electric_stove")
	private boolean electricStove;

	private double stovePrice;

	public int getStoveId() {
		return stoveId;
	}

	public void setStoveId(int stoveId) {
		this.stoveId = stoveId;
	}

	public String getStoveBrand() {
		return stoveBrand;
	}

	public void setStoveBrand(String stoveBrand) {
		this.stoveBrand = stoveBrand;
	}

	public int getTotalBurners() {
		return totalBurners;
	}

	public void setTotalBurners(int totalBurners) {
		this.totalBurners = totalBurners;
	}

	public boolean isElectricStove() {
		return electricStove;
	}

	public void setElectricStove(boolean electricStove) {
		this.electricStove = electricStove;
	}

	public double getStovePrice() {
		return stovePrice;
	}

	public void setStovePrice(double stovePrice) {
		this.stovePrice = stovePrice;
	}
}
