package com.example.simplon_clone_fb.Services;

import Models.ApprenantsModel;
import Models.FormateursModel;
import Models.PromotionsModel;
import com.example.simplon_clone_fb.Dao.daoApprenant;
import com.example.simplon_clone_fb.Dao.daoFormateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminServices {

    //This Method brings all the actors , Formateurs,apprenants or promotions
    public List getAll(String actor){
        System.out.println("AdminServices.getAll");
        if(actor.equalsIgnoreCase("apprenant")){
             List<ApprenantsModel> listApprenant = new daoApprenant().selectAll(ApprenantsModel.class);
             return listApprenant;
        } else if (actor.equalsIgnoreCase("formateurs")) {
            System.out.println("in here with list formateurs");
            List<FormateursModel> listFormaterus = new daoFormateur().selectAll(FormateursModel.class);
            return listFormaterus;
        }else {
                 return null;
        }
    };

    //Adding an actor or promotion to the database
   public boolean addUser(Object obj){
       if (obj instanceof FormateursModel){
           return new daoFormateur().addOneElement((FormateursModel) obj);
       } else if (obj instanceof ApprenantsModel) {
           return new daoApprenant().addOneElement((ApprenantsModel) obj);
       }else if(obj instanceof PromotionsModel){
           return true;
       }else {
           return false;
       }
   }
}
