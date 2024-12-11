package com.xworkz.acer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="acer_table")

@NamedQuery(name = "getproductNameById", query = "SELECT e.name FROM AcerEntity e WHERE e.id = :id")
@NamedQuery(name = "getBrandNameAndPriceById",query = "SELECT e.brandName, e.price FROM AcerEntity e WHERE e.pohone_no = :number")


public class AcerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "productName")
	private String name;
	
	private String brandName;
	
	private float price;
	
	private boolean in_stock;

	private long pohone_no;

	public AcerEntity() {
		super();
	}

	public AcerEntity(String name, String brandName, float price, boolean in_stock, long pohone_no) {
		super();
		this.name = name;
		this.brandName = brandName;
		this.price = price;
		this.in_stock = in_stock;
		this.pohone_no = pohone_no;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isIn_stock() {
		return in_stock;
	}

	public void setIn_stock(boolean in_stock) {
		this.in_stock = in_stock;
	}

	public long getPohone_no() {
		return pohone_no;
	}

	public void setPohone_no(long pohone_no) {
		this.pohone_no = pohone_no;
	}

	@Override
	public String toString() {
		return "AcerEntity [id=" + id + ", name=" + name + ", brandName=" + brandName + ", price=" + price
				+ ", in_stock=" + in_stock + ", pohone_no=" + pohone_no + "]";
	}
	
}