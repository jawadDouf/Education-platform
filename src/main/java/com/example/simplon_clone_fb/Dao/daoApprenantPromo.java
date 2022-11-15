package com.example.simplon_clone_fb.Dao;

import com.example.simplon_clone_fb.Models.PromoApprenantModel;
import com.example.simplon_clone_fb.Models.PromotionsModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class daoApprenantPromo extends databaseAccessObject<PromoApprenantModel> {


    public int getPromoIdOfStudent(int studentId){
        try{
            System.out.println("daoApprenantPromo.getPromoIdOfStudent");
            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<PromoApprenantModel> query = entityManager.createQuery("SELECT a from PromoApprenantModel a  WHERE  a.apprenantId = :studentId",PromoApprenantModel.class);
            //Prepare the statement
            query.setParameter("studentId",studentId);
            PromoApprenantModel apprenantpromotion = query.getSingleResult();
            return apprenantpromotion.getPromoId();
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

}
