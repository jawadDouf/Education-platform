package com.example.simplon_clone_fb.Services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminServicesTest {

    @Test
    void getAll() {
        assertNotNull(new AdminServices().getAll("formateurs"));
    }

    @Test
    void addUser() {
        assertTrue(new AdminServices().addUser("formateurs","nom","prenom","email","password"));
    }

    @Test
    void addPromotion() {
        assertTrue(new AdminServices().addPromotion("name","size"));
    }



    @Test
    void deleteElement() {
        assertTrue(new AdminServices().deleteElement("formateurs","1"));
    }
}