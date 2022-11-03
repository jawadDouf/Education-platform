package com.example.simplon_clone_fb.Dao;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class entityUtility {


    public static EntityManagerFactory entityManagerFactory;




    //return an entity manager
    public static EntityManagerFactory getEntityManagerFactory(){
            if(entityManagerFactory == null){
                //initialize the entity manager factory
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
                return entityManagerFactory;
            }else {
                return entityManagerFactory;
            }
    }

}
