package com.example.simplon_clone_fb.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class entityUtility {


    static EntityManager entityManager;
    static EntityTransaction entityTransaction;

    //Initialize the Entities only once (in the first object itialization
    static {
        try{
            //initialize the entity manager factory
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            //Initialise the entityManager
            entityManager = entityManagerFactory.createEntityManager();
            //initialise the transaction
            entityTransaction = entityManager.getTransaction();

        }catch (Exception e){
            //Handle the exception
            System.out.println("Something went wrong with the entity classes innitialization");
        }
    }

    //return an entity manager
    static public EntityManager getEntityManager(){

        return entityManager;
    }

    //return an entity transaction
    static public EntityTransaction getEntityTransaction(){

        return entityTransaction;
    }
}
