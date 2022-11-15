package com.example.simplon_clone_fb.Services;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class sendEmail {

    public sendEmail(int teacherId) {
        ApprenantsModel apprenantsModel = new ApprenantsModel();
        ArrayList<ApprenantsModel> apprenants = (ArrayList<ApprenantsModel>) new TeacherServices().getAllTeacherStudents("2022-2021",teacherId);
        for (ApprenantsModel apprenant1 : apprenants) {
            String to = apprenant1.getEmail();
            String subject = "New Brief";
            String message = "Bonjour " + apprenant1.getNom() + " " + apprenant1.getPrenom() + ",\n" +
                    "Vous avez un nouveau brief à lire.\n" +
                    "Cordialement,\n";
            sendEmail.send(to, subject, message);
        }
    }


    private static void send(String email, String subject, String message) {
        System.out.println(subject);
        System.out.println(email);
        System.out.println(message);
        System.out.println("--------------------------");
        Courier.init("pk_prod_YFX88J0RXZM3WRQ2M0FTHWF4BMV7");
        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<>();
        to.put("email", email);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<>();
        content.put("title", subject);
        content.put("body", message);
        sendRequestMessage.setContent(content);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);
        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
