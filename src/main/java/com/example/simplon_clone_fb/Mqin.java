package com.example.simplon_clone_fb;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Mqin {


    public static void main(String[] args) {
        EntityManagerFactory e = Persistence.createEntityManagerFactory("persistence");

        EntityManager em = e.createEntityManager();

        System.out.println("ok111");
    }
}
