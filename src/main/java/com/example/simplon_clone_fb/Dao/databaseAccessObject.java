package com.example.simplon_clone_fb.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
     public T getOneElementById(Class<T> objectClass,int id){
         //Start the entity
         EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
         try{

             return entityManager.find(objectClass,id);

         }catch (Exception e){
             System.out.println(e.getMessage());
         }
         return null;
     };


    // add element in a table
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

    public boolean update(T object) {
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }




}
