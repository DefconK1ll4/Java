package com.mailservice.sendit.serviceprovider;

import com.mailservice.sendit.ServiceProvider;
import com.mailservice.sendit.authentication.SSL;
import com.mailservice.sendit.authentication.TLS;

public abstract class Outlook extends ServiceProvider implements SSL, TLS {
    @Override
    public boolean isSSL() {
        return false;
    }

    @Override
    public boolean isTLS() {
        return false;
    }
/***
     *  E-postleverantör
     *
     *
     * IMAP-Inställningar
     *
     *
     * POP-Inställningar
     *
     *
     * SMTP-Inställningar
     *
     * Microsoft 365
     *
     * Outlook
     *
     * Hotmail
     *
     * Live.com
     *
     *
     * Server: outlook.office365.com
     *
     * Port: 993
     *
     * Kryptering: SSL/TLS
     *
     *
     * Server: outlook.office365.com
     *
     * Port: 995
     *
     * Kryptering: SSL/TLS
     *
     *
     * Server: smtp.office365.com
     *
     * Port: 587
     *
     * Kryptering: STARTTLS
     *
     * MSN
     *
     *
     * Server: imap-mail.outlook.com
     *
     * Port: 993
     *
     * Kryptering: SSL/TLS
     *
     *
     * Server: pop-mail.outlook.com
     *
     * Port: 995
     *
     * Kryptering: SSL/TLS
     *
     *
     * Server: smtp-mail.outlook.com
     *
     * Port: 587
     *
     * Kryptering: STARTTLS
     */
}
