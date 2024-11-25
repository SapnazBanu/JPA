package com.xworkz.cinema.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.cinema.DTO.CinemaDTO;

public class CinemaRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager eM = emf.createEntityManager();
        EntityTransaction eT = eM.getTransaction();

        try {
            eT.begin();
            CinemaDTO cinema = new CinemaDTO();
            cinema.setCinema_id(3);
            cinema.setCinema_name("Bsangalore Days");
            cinema.setNumber_of_screens(2);
            cinema.setTicket_price(200);
            cinema.setLocation("IONIX");
            eM.persist(cinema);
            eT.commit();
            System.out.println("Cinema data saved successfully!");
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close();
			emf.close();
		}
	}
}
