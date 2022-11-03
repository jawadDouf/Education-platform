package com.example.simplon_clone_fb.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class entityUtility {


    public static EntityManager entityManager;
    public static EntityTransaction entityTransaction;



    //return an entity manager
    public static EntityManager getEntityManager(){

            //initialize the entity manager factory
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager;

    }

    //return an entity transaction
    public static EntityTransaction getEntityTransaction(){


             //check if we already have intialise the entity manager
             entityManager = entityUtility.getEntityManager();
             //Initialise the entityManager
             entityTransaction = entityManager.getTransaction();
             return entityTransaction;


    }
}
