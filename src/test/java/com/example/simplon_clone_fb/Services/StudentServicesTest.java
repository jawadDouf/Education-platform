package com.example.simplon_clone_fb.Services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServicesTest {

    @Test
    void getAllBriefs() {
        assertNotNull(new StudentServices().getAllBriefs(1));
    }

    @Test
    void getTeacherOfStudent() {
        assertNotNull(new StudentServices().getTeacherOfStudent(1));
    }
}