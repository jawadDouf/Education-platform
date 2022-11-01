package com.example.simplon_clone_fb.Dao;


import com.example.simplon_clone_fb.Models.AdministrateurModel;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class daoAdministrateurs extends databaseAccessObject<AdministrateurModel> {

    //Intialise the entityManager and entityTransaction class
    @Override
    public List<AdministrateurModel> selectAll() {
        return null;
    }

    @Override
    public AdministrateurModel getOneElementById(int id) {
        return null;
    }

    @Override
    public AdministrateurModel getOneElementByEmailPassword(String email, String password) {
       try{
           //Start the transaction
           entityUtility.getEntityTransaction().begin();
           //Create the query and return the element from database
           TypedQuery<AdministrateurModel> query = entityUtility.getEntityManager().createQuery("SELECT Admin FROM " +
                           "AdministrateurModel Admin " +
                           "WHERE Admin.email = :email " +
                           "AND Admin.password = :password",
                   AdministrateurModel.class);
           //Prepare the statement
           query.setParameter("email",email);
           query.setParameter("password",password);
           //execute the query
           AdministrateurModel administrateurModel1 = query.getSingleResult();
           //commit the transaction
           entityUtility.getEntityTransaction().commit();
           return administrateurModel1;
       }catch (Exception e){
           System.out.println(e);
       }
        return null;
    }

    @Override
    public void addOneElement() {
    }

}
