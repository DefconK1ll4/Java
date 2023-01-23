package com.mailservice.sendit;


import java.util.Properties;

public class Protocol {


    public Properties outgoingServerProp(String serviceProvider) {
        Properties prop = new Properties();
        if(serviceProvider.equalsIgnoreCase("gmail")) {
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.starttls.required", "true");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

            return prop;

        } else if(serviceProvider.equalsIgnoreCase("aol")) {
            prop.put("mail.smtp.host", "smtp.aol.com");
            prop.put("mail.smtp.port", "465");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.starttls.required", "true");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

            return prop;
        }  else if(serviceProvider.equalsIgnoreCase("icloud")) {
            prop.put("mail.smtp.host", "smtp.mail.me.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.starttls.required", "true");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");


        } else if(serviceProvider.equalsIgnoreCase("outlook")) {
            prop.put("mail.smtp.host", "smtp-mail.outlook.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.starttls.required", "true");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        } else if(serviceProvider.equalsIgnoreCase("yahoo")) {
            prop.put("mail.smtp.host", "smtp.mail.yahoo.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.starttls.required", "true");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        } else if(serviceProvider.equalsIgnoreCase("zoho")) {
            prop.put("mail.smtp.host", "smtp.mail.yahoo.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.starttls.required", "true");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        }
        return null;

    }
}
