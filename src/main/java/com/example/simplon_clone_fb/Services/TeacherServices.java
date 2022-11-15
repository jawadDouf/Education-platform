package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Dao.daoApprenant;
import com.example.simplon_clone_fb.Dao.daoApprenantPromo;
import com.example.simplon_clone_fb.Dao.daoBrief;
import com.example.simplon_clone_fb.Dao.daoPromotions;
import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.BriefsModel;
import com.example.simplon_clone_fb.Models.PromoApprenantModel;

import java.util.List;

public class TeacherServices {

    // get all students of a teacher
    public List<ApprenantsModel> getAllTeacherStudents(String year, Integer teacherId){
        System.out.println("TeacherServices.getAllTeacherStudents");
        //get the promo of the teacher id
        System.out.println("id now is :" + teacherId);
        int promoId = new daoPromotions().selectPromotionOfTeacher(teacherId).getId();
        System.out.println(promoId);
        //return the students of that teacher
        return new daoApprenant().selectAllStudentsOfPromotion(year,promoId);
    }

    //get all students with out promo
    public  List<ApprenantsModel> getAllStudentsWithoutPromotion(){

        return new daoApprenant().getAllStudentsWithoutPromotion();
    }

    //Add student to prom
    public boolean addStudentToPromo(String studentId,Integer teacherId){
        //get the promo of the teacher id
        System.out.println("id now is :" + teacherId);
        int promoId = new daoPromotions().selectPromotionOfTeacher(teacherId).getId();
        //assign promo to student
        PromoApprenantModel promoApprenantModel = new PromoApprenantModel();
        promoApprenantModel.setApprenantId(Integer.parseInt(studentId));
        promoApprenantModel.setPromoId(promoId);
        promoApprenantModel.setYear("2022-2021");
        return new daoApprenantPromo().addOneElement(promoApprenantModel);
    }

    //get all the briefs

    public List<BriefsModel> getAllBriefs(Integer id){
        //get the promo of the teacher id
        System.out.println("id now is :" + id);
        int promoId = new daoPromotions().selectPromotionOfTeacher(id).getId();
        System.out.println(promoId);

        //select the briefs
        List<BriefsModel> briefs = new daoBrief().selectAll(promoId);
        System.out.println("dddd" + briefs.get(0).getPromoId());
        return briefs;
    }

    //Create a new assignement
    public boolean createAssignment(String title,String subTitle,String languages,String description,String startDate ,String deadline ,Integer teacherId){
        //get the promo of the teacher id
        System.out.println("id now is :" + teacherId);
        int promoId = new daoPromotions().selectPromotionOfTeacher(teacherId).getId();
        System.out.println(promoId);
        //Start adding the assignment
        System.out.println("AdminServices.addPromotion");
        BriefsModel brief = new BriefsModel();
        brief.setTitre(title);
        brief.setDescription(description);
        brief.setLanguages(languages);
        brief.setSubTitle(subTitle);


        brief.setDateDebut(java.sql.Date.valueOf(startDate));
        brief.setDateFin(java.sql.Date.valueOf(deadline));
        //set the promo id and status
        brief.setPromoId(promoId);
        brief.setStatus(false);
        return new daoBrief().addOneElement(brief);
    }
}
