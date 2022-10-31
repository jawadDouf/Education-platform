package com.example.simplon_clone_fb.Dao;

import com.example.simplon_clone_fb.Models.ActeursModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class daoActeurs implements databaseAccessObject<ActeursModel> {
    //Intialise the entityManager and entityTransaction class
     EntityManager entityManager = entityUtility.getEntityManager();
     EntityTransaction entityTransaction = entityUtility.getEntityTransaction();
    @Override
    public List<ActeursModel> selectAll() {
        return null;
    }

    @Override
    public ActeursModel getOneElementById(int id) {
        return null;
    }

    @Override
    public ActeursModel getOneElementByStringColumn(String column) {
        return null;
    }




    @Override
    public void addOneElement() {

    }

}
