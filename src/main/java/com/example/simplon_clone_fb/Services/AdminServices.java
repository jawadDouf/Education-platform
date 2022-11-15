package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Dao.daoApprenant;
import com.example.simplon_clone_fb.Dao.daoFormateur;
import com.example.simplon_clone_fb.Dao.daoPromotions;
import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.FormateursModel;
import com.example.simplon_clone_fb.Models.PromotionsModel;

import java.util.List;

public class AdminServices {

    //This Method brings all the actors , Formateurs,apprenants or promotions
    public List getAll(String actor){
        System.out.println("AdminServices.getAll");
        if(actor.equalsIgnoreCase("apprenants")){
             List<ApprenantsModel> listApprenant = new daoApprenant().selectAll(ApprenantsModel.class);
             return listApprenant;
        } else if (actor.equalsIgnoreCase("formateurs")) {
            System.out.println("in here with list formateurs");
            List<FormateursModel> listFormaterus = new daoFormateur().selectAll(FormateursModel.class);
            return listFormaterus;
        }else {
            System.out.println("in here with list promotions");
            List<PromotionsModel> listPromotions = new daoPromotions().selectAll(PromotionsModel.class);
            return listPromotions;
        }
    };

    //Adding an actor or promotion to the database
   public boolean addUser(String acteur,String nom,String prenom,String email,String password){
       if (acteur.equalsIgnoreCase("formateurs")){
           FormateursModel formateur = new FormateursModel();
           formateur.setNom(nom);
           formateur.setPrenom(prenom);
           formateur.setEmail(email);
           formateur.setPassword(password);
           return new daoFormateur().addOneElement(formateur);
       } else if (acteur.equalsIgnoreCase("apprenants")) {
           ApprenantsModel apprenant = new ApprenantsModel();
           apprenant.setNom(nom);
           apprenant.setPrenom(prenom);
           apprenant.setEmail(email);
           apprenant.setPassword(password);
           return new daoApprenant().addOneElement(apprenant);
       }else {
           return false;
       }
   }

   public boolean addPromotion(String name,String size){
       System.out.println("AdminServices.addPromotion");
       PromotionsModel promotion = new PromotionsModel();
       promotion.setNom(name);
       promotion.setSize(Integer.parseInt(size));
       promotion.setFormateurId(1);
       return new daoPromotions().addOneElement(promotion);
   }


   public boolean assignPromotion(String id_promo,String name,String size,String id_formateur){
       System.out.println("AdminServices.assignPromotion");
       PromotionsModel promotion = new PromotionsModel();
       promotion.setId(Integer.parseInt(id_promo));
       promotion.setNom(name);
       System.out.println("size = "+size);
       promotion.setSize(Integer.parseInt(size));
       promotion.setFormateurId(Integer.parseInt(id_formateur));
       return new daoPromotions().update(promotion);
   }
}
