package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Dao.daoAdministrateurs;
import com.example.simplon_clone_fb.Models.AdministrateurModel;

/*
*This class contain the business logic of the authentification
*This class uses the diffrent actors models to add to the actors table
* And check if a user exists in a table
 */
public class AuthService {

    public AdministrateurModel login(String email,String password){
        //Create the new daoAdministrateur object
        daoAdministrateurs daoAdministrateurs = new daoAdministrateurs();
        //Check if the user exists in the database
        if(daoAdministrateurs.getOneElementByEmailPassword(email,password) != null){
            //Return the user
            return daoAdministrateurs.getOneElementByEmailPassword(email,password);
        }else {
            return null;
        }
    }
}
