package com.example.simplon_clone_fb.Dao;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.PromotionsModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class daoPromotions extends databaseAccessObject<PromotionsModel>{


    public PromotionsModel selectPromotionOfTeacher(int teacherId){

        try{
            System.out.println("daoPromotions.selectPromotionOfTeacher");
            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<PromotionsModel> query = entityManager.createQuery("SELECT a from PromotionsModel a  WHERE  a.formateurId = :teacherId",PromotionsModel.class);

            //Prepare the statement
            query.setParameter("teacherId",teacherId);
            PromotionsModel promotion = query.getSingleResult();
            return promotion;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


}
