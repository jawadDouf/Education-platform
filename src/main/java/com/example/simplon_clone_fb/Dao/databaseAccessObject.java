package com.example.simplon_clone_fb.Dao;

import java.util.List;

interface  databaseAccessObject<T> {

    // select all elements from table
     List<T> selectAll();

     // select element by id
    T getOneElementById(int id);

    // Select element by A column String

    T getOneElementByStringColumn(String column);
    // add element in table
    void addOneElement();



}
