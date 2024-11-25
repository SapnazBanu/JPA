package com.xworkz.cinema.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cinema")
public class CinemaDTO {

	@Id
	private int cinema_id;
	private String cinema_name;
	private Integer number_of_screens;
	private double ticket_price;
	private String location;

	public int getCinema_id() {
		return cinema_id;
	}

	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}

	public Integer getNumber_of_screens() {
		return number_of_screens;
	}

	public void setNumber_of_screens(Integer number_of_screens) {
		this.number_of_screens = number_of_screens;
	}

	public double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
