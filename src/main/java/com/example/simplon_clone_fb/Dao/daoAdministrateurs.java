package com.example.simplon_clone_fb.Dao;



import com.example.simplon_clone_fb.Models.AdministrateurModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class daoAdministrateurs extends databaseAccessObject<AdministrateurModel> {

    //Intialise the entityManager and entityTransaction class



    public AdministrateurModel getOneElementByEmailPassword(String email, String password) {
       try{

           //Start the entity
           EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
           //Create the query and return the element from database
           TypedQuery<AdministrateurModel> query = entityManager.createQuery("SELECT Admin FROM AdministrateurModel Admin WHERE Admin.email = :email AND Admin.password = :password",
                   AdministrateurModel.class);
           //Prepare the statement
           query.setParameter("email",email);
           query.setParameter("password",password);


           //execute the query
           AdministrateurModel administrateurModel1 = query.getSingleResult();

           return administrateurModel1;
       }catch (Exception e){
           System.out.println(e.getMessage());
           e.printStackTrace();
       }
        return null;
    }



}
