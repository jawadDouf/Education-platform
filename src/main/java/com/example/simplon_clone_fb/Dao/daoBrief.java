package com.example.simplon_clone_fb.Dao;

import com.example.simplon_clone_fb.Models.BriefsModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class daoBrief extends databaseAccessObject<BriefsModel> {

    public List<BriefsModel> selectAll(int promoId){

        try{
            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<BriefsModel> query = entityManager.createQuery("SELECT b from BriefsModel b JOIN  PromotionsModel p WHERE b.promoId = :promoId",BriefsModel.class);
            //Prepare the statement
            query.setParameter("promoId",promoId);

            List<BriefsModel> briefs = query.getResultList();

            return briefs;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


}
