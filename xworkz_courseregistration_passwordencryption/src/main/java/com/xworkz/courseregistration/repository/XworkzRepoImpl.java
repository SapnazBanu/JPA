package com.xworkz.courseregistration.repository;

import com.xworkz.courseregistration.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class XworkzRepoImpl implements XworkzRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public XworkzRepoImpl() {
        System.out.println("created XworkzRepoImpl");
    }

    @Override
    public boolean onSave(XworkzEntity entity) {
        System.out.println("save in XworkzRepoImpl");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        boolean isSaved = false;

        try {
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
            isSaved = true;
        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return isSaved;
    }

    @Override
    public XworkzEntity findByEmail(String email) {
        System.out.println("Finding entity by email: " + email);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createNamedQuery("XworkzEntity.findByEmail", XworkzEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.err.println("No entity found for email: " + email);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}
