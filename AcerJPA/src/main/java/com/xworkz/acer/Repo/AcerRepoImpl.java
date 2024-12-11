package com.xworkz.acer.Repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.acer.entity.AcerEntity;
import com.xworkz.acer.service.AcerService;

import java.util.List;

public class AcerRepoImpl implements AcerRepo {

	@Override
	public List<AcerEntity> getproductNameById(int id) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		List<AcerEntity> list = null;
		try {
			eT.begin();
			Query query = eM.createNamedQuery("getproductNameById");
			query.setParameter("id", id);
			list = query.getResultList();
			for (AcerEntity ent : list) {
				System.out.println(ent);
			}
			eT.commit();

		} catch (Exception e) {

		} finally {
			eM.close();
		}
		return list;
	}

	@Override
	public List<Object[]> getBrandNameAndPriceByPhoneNumber(long phoneNumber) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		List<Object[]> ref2 = null;
		Query query = eM.createNamedQuery("getBrandNameAndPriceById");
		query.setParameter("number", phoneNumber);
		ref2 = query.getResultList();
		for (Object[] objects : ref2) {
			System.out.println("bName:" + objects[0]);
			System.out.println("price:" + objects[1]);

		}
		return ref2;
	}

}
