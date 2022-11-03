package com.example.simplon_clone_fb.Dao;

import Models.ApprenantsModel;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class daoApprenant extends databaseAccessObject<ApprenantsModel> {
    @Override
    List<ApprenantsModel> selectAll() {
        return null;
    }

    @Override
    ApprenantsModel getOneElementById(int id) {
        return null;
    }

    @Override
    public ApprenantsModel getOneElementByEmailPassword(String email, String password) {
        try{
            //Start the transaction
            entityUtility.getEntityTransaction().begin();
            //Create the query and return the element from database
            TypedQuery<ApprenantsModel> query = entityUtility.getEntityManager().createQuery("SELECT Apprenant FROM " +
                            "ApprenantsModel Apprenant " +
                            "WHERE Apprenant.email = :email " +
                            "AND Apprenant.password = :password",
                    ApprenantsModel.class);
            //Prepare the statement
            query.setParameter("email",email);
            query.setParameter("password",password);
            //execute the query
            ApprenantsModel apprenantsModel = query.getSingleResult();
            //Commit the transaction
            entityUtility.getEntityTransaction().commit();
            return apprenantsModel;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    void addOneElement() {

    }
}
