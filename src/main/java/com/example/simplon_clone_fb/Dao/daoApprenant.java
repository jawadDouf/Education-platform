package com.example.simplon_clone_fb.Dao;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class daoApprenant extends databaseAccessObject<ApprenantsModel> {





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

    //select all learners by promotion and year

    public List<ApprenantsModel> selectAllStudentsOfPromotion(String year, int promoId){
        try{
            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<ApprenantsModel> query = entityManager.createQuery("SELECT a,b from ApprenantsModel a JOIN a.promoApprenantsById b WHERE b.promoId = :promoId AND b.year = :year",ApprenantsModel.class);

            //Prepare the statement
            query.setParameter("promoId",promoId);
            query.setParameter("year",year);

            List<ApprenantsModel> apprenants = query.getResultList();
            return apprenants;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    //select all learners with out a promotion
    public List<ApprenantsModel> getAllStudentsWithoutPromotion(){
        try{
            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<ApprenantsModel> query = entityManager.createQuery("SELECT a  from ApprenantsModel a LEFT JOIN a.promoApprenantsById b",ApprenantsModel.class);

            List<ApprenantsModel> apprenants = query.getResultList();
            return apprenants;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }


    }


}
