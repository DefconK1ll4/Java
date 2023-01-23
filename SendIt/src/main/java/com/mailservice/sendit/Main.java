package com.mailservice.sendit;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.net.ssl.SSLServerSocketFactory;

public class Main {

    /**
     Outgoing Mail (SMTP) Server
     requires TLS or SSL: smtp.gmail.com (use authentication)
     Use Authentication: Yes
     Port for SSL: 465
     */
    public static void main(String[] args) {
        final String fromEmail = "seddigh.daniel@gmail.com"; //requires valid gmail id
        final String password = "tsxopmffhvrzzmkr"; // correct password for gmail id
        final String toEmail = "linn.sedigh@gmail.com"; // can be any email id

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props);
        System.out.println("Session created");
        EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "Heeeeeeeeeeeeeeeeeeeeyyy baaabeeeeeeeee");

    }
}