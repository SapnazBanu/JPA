package com.xworkz.Oggy.Runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.Oggy.Entity.Oggy;

import java.util.*;

public class Queries {
	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("xworkz");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction eT = eM.getTransaction();

		Query query = eM.createNamedQuery("findByName");
		Object object = query.getSingleResult();
		Oggy oggy = (Oggy) object;
		System.out.println("values:" + oggy.getName());
		System.out.println("----------------------------------------");
		
		Query query1 = eM.createNamedQuery("findByRating");
		Object object1 = query.getSingleResult();
		Oggy oggy1 = (Oggy) object1;
		System.out.println("values:" +oggy1.getRating());
		System.out.println("-----------------------------------------");
		
		Query query2 = eM.createNamedQuery("findByFavoriteFoods");
		query2.setParameter("food", "Kunafa");
		Object ob=query2.getSingleResult(); 
		String str=(String)ob;
		System.out.println("String:"+str);
		System.out.println("-----------------------------------------");
		
		
		Query query3 = eM.createNamedQuery("findByLevel");
		query3.setParameter("levelk", (byte) 2); 
		Object obj3 = query3.getSingleResult();
		Short sh1 = (Short) obj3;
		System.out.println(sh1);
		System.out.println("-----------------------------------------");
		
		Query query4 = eM.createNamedQuery("findByGrade");
		query4.setParameter("grade", 'D');
		Object obj4 = query4.getSingleResult();
		Boolean bn = (Boolean) obj4; 
		System.out.println(bn);
		System.out.println("-----------------------------------------");
		
		Query query5 = eM.createNamedQuery("findAll");
		List<Oggy> oggyList = query.getResultList();
		oggyList.forEach(og -> System.out.println(og));
		System.out.println("");


		try {
			eT.begin();
			eT.commit();
		} catch (Exception e) {
			if (eT.isActive()) {
				eT.rollback();
			}
			e.printStackTrace();
		} finally {
			eM.close();
			eMF.close();
		}
	}
}
