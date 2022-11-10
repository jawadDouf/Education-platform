package com.example.simplon_clone_fb.Dao;

import Models.FormateursModel;
import Models.PromotionsModel;

public class daoPromotions extends databaseAccessObject<PromotionsModel>{
    @Override
    PromotionsModel getOneElementById(int id) {
        return null;
    }

    @Override
    PromotionsModel getOneElementByEmailPassword(String email, String password) {
        return null;
    }
}
