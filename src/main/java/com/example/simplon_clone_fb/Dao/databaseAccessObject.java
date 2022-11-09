package com.example.simplon_clone_fb.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

abstract class  databaseAccessObject<T> {


    // select all elements from table
     public List<T> selectAll(Class<T> objectClass){
         //Start the entity
         EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
         try {
               //Create the query
               TypedQuery<T> query = entityManager.createQuery("SELECT a FROM "+objectClass.getSimpleName()+" a",objectClass);
               //Get the data from database
               List<T> list = query.getResultList();
                return list;
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
        return null;
    };

     // select element by id
    abstract T getOneElementById(int id);

    // Select element by A column String

   abstract T getOneElementByEmailPassword(String email,String password);
    // add element in table
    public boolean addOneElement(T object){
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    return false;
    };



}
