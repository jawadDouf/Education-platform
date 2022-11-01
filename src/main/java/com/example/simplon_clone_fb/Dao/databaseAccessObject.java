package com.example.simplon_clone_fb.Dao;

import java.util.List;

abstract class  databaseAccessObject<T> {


    // select all elements from table
    abstract List<T> selectAll();

     // select element by id
    abstract T getOneElementById(int id);

    // Select element by A column String

   abstract T getOneElementByEmailPassword(String email,String password);
    // add element in table
   abstract void addOneElement();



}
