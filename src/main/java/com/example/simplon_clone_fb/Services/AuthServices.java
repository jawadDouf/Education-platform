/*
 *This class contain the business logic of the authentification
 *This class uses the diffrent actors models to add to the actors table
 * And check if a user exists in a table
 */
package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Dao.daoAdministrateurs;
import com.example.simplon_clone_fb.Dao.daoApprenant;
import com.example.simplon_clone_fb.Dao.daoFormateur;



public class AuthServices {

    public Object login(String email,String password,String emailLog){
        //Create the new daoAdministrateur object
        daoAdministrateurs daoAdministrateurs = new daoAdministrateurs();
        //Check if the user exists in the database
        if(emailLog.equalsIgnoreCase("simplonadmin.co")){
            return new daoAdministrateurs().getOneElementByEmailPassword(email,password);
        }else if(emailLog.equalsIgnoreCase("simplon.co")){
            return new daoFormateur().getOneElementByEmailPassword(email,password);
        }else{
            return new daoApprenant().getOneElementByEmailPassword(email,password);
        }
    }
}
