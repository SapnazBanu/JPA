package com.xworkz.coursedetails.repository;

import com.xworkz.coursedetails.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    EntityManagerFactory eMF;

    @Override
    public boolean save(CourseEntity entity) {
        System.out.println("CourseRepositoryImpl created");
        EntityManager em = eMF.createEntityManager();
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
            eMF.close();
        }
        return true;
    }
    @Override
    public String getNameByEmailAndPassword(String email, String password) {
        EntityManager entityManager=eMF.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        String name=null;
        try{
            entityTransaction.begin();
            Query query=entityManager.createNamedQuery("getNameByEmailAndPassword");
            query.setParameter("byemail",email).setParameter("bypassword",password);
            name=(String)query.getSingleResult();
            entityTransaction.commit();
        } catch (Exception e) {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
        finally {

        }
        return name;
    }

}