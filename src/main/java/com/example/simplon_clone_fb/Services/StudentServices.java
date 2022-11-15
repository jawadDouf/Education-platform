package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Dao.daoApprenantPromo;
import com.example.simplon_clone_fb.Dao.daoBrief;
import com.example.simplon_clone_fb.Dao.daoFormateur;
import com.example.simplon_clone_fb.Dao.daoPromotions;
import com.example.simplon_clone_fb.Models.BriefsModel;
import com.example.simplon_clone_fb.Models.FormateursModel;
import com.example.simplon_clone_fb.Models.PromotionsModel;

import java.util.List;

public class StudentServices {

    public List<BriefsModel> getAllBriefs(Integer id){
        //get the promo of the teacher id
        System.out.println("id now is :" + id);
        int promoId = new daoApprenantPromo().getPromoIdOfStudent(id);
        System.out.println(promoId);
        //select the briefs
        List<BriefsModel> briefs = new daoBrief().selectAll(promoId);
        return briefs;
    }

    //get teacher of a student
    public FormateursModel getTeacherOfStudent(Integer promoId){

        PromotionsModel promo = new daoPromotions().getOneElement(PromotionsModel.class,promoId);
        FormateursModel formateursModel = new daoFormateur().getOneElement(FormateursModel.class,promo.getFormateurId());
        return formateursModel;

    }

}
