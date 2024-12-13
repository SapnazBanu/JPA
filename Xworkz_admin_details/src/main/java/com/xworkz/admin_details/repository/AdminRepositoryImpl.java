package com.xworkz.admin_details.repository;

import com.xworkz.admin_details.entity.XworkzAdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    @Override
    public boolean save(XworkzAdminEntity entity) {


        System.out.println("Ascxc"+entityManagerFactory);

            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                em.persist(entity);
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
                entityManagerFactory.close();
            }

            return true;
        }

}
