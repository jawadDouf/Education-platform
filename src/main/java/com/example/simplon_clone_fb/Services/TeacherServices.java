package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Dao.daoApprenant;
import com.example.simplon_clone_fb.Dao.daoApprenantPromo;
import com.example.simplon_clone_fb.Dao.daoPromotions;
import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.PromoApprenantModel;

import java.util.List;

public class TeacherServices {

    // get all students of a teacher
    public List<ApprenantsModel> getAllTeacherStudents(String year,String teacherId){
        //get the promo of the teacher id
        int promoId = new daoPromotions().selectPromotionOfTeacher(Integer.parseInt(teacherId)).getId();
        //return the students of that teacher
        return new daoApprenant().selectAllStudentsOfPromotion(year,promoId);
    }

    //get all students with out promo
    public  List<ApprenantsModel> getAllStudentsWithoutPromotion(){

        return new daoApprenant().getAllStudentsWithoutPromotion();
    }

    //Add student to prom
    public boolean addStudentToPromo(String studentId,String promoId,String year){
        PromoApprenantModel promoApprenantModel = new PromoApprenantModel();
        promoApprenantModel.setApprenantId(Integer.parseInt(studentId));
        promoApprenantModel.setPromoId(Integer.parseInt(promoId));
        promoApprenantModel.setYear(year);
        return new daoApprenantPromo().addOneElement(promoApprenantModel);

    }
}
