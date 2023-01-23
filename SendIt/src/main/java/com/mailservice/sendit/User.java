package com.mailservice.sendit;

import com.mailservice.sendit.mailprotocol.IMAP;
import com.mailservice.sendit.mailprotocol.SMTP;
import com.mailservice.sendit.serviceprovider.AOL;

public class User {
    private String mailAddress;
    private String appPwd;

    public User(String email, String pwd) {
        String mailAddress = email;
        String appPwd = pwd;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getAppPwd() {
        return appPwd;
    }
}
