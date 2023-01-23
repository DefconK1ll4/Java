package com.mailservice.sendit.serviceprovider;

import com.mailservice.sendit.ServiceProvider;
import com.mailservice.sendit.authentication.SSL;
import com.mailservice.sendit.authentication.TLS;
import com.mailservice.sendit.mailprotocol.IMAP;
import com.mailservice.sendit.mailprotocol.SMTP;

public abstract class AOL extends ServiceProvider implements SSL, TLS, IMAP, SMTP {
    @Override
    public boolean isSSL() {
        return false;
    }

    @Override
    public boolean isTLS() {
        return false;
    }

    @Override
    public int getInIMAPSSLPort() {
        return 0;
    }

    @Override
    public int getOutSMTPSSLPort() {
        return 0;
    }

    @Override
    public int getOutSMTPTLSPort() {
        return 0;
    }
/***
     * Setup Your Aol.com Account with Your Email Program Using IMAP
     *
     * To access your Aol.com email account from a desktop email program, you'll need the IMAP and SMTP settings below:
     * Aol.com (AOL Mail) IMAP Server 	imap.aol.com
     * IMAP port	993
     * IMAP security	SSL / TLS
     * IMAP username	Your full email address
     * IMAP password	Your Aol.com password
     * Aol.com (AOL Mail) SMTP Server 	smtp.aol.com
     * SMTP port	465
     * SMTP security	SSL / TLS
     * SMTP username	Your full email address
     * SMTP password	Your Aol.com password
     */
}
