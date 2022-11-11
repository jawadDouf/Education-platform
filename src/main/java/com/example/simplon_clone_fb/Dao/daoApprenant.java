package com.example.simplon_clone_fb.Dao;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class daoApprenant extends databaseAccessObject<ApprenantsModel> {


    @Override
    ApprenantsModel getOneElementById(int id) {
        return null;
    }

    @Override
    public ApprenantsModel getOneElementByEmailPassword(String email, String password) {
        try{

            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<ApprenantsModel> query = entityManager.createQuery("SELECT Apprenant FROM " +
                            "ApprenantsModel Apprenant " +
                            "WHERE Apprenant.email = :email " +
                            "AND Apprenant.password = :password",
                    ApprenantsModel.class);
            //Prepare the statement
            query.setParameter("email",email);
            query.setParameter("password",password);
            //execute the query
            ApprenantsModel apprenantsModel = query.getSingleResult();

            return apprenantsModel;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}
