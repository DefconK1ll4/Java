package com.mailservice.sendit.serviceprovider;

public class Zoho {

    /***
     * MAP is more recent than POP and allows a two-way synchronization between the email clients and your Zoho Mail account.
     * IMAP is recommended when you want to access the same account from multiple email clients.
     *
     * Incoming Server Settings (Personal users with an email address, username@zoho.com):
     *
     * Incoming Server Name: imap.zoho.eu
     * Port: 993
     * Require SSL: Yes
     * Username: username@zoho.com
     *
     * Incoming Server Settings (Organization users with a domain-based email address, you@yourdomain.com):
     *
     * Incoming Server Name: imappro.zoho.eu
     * Port: 993
     * Require SSL: Yes
     * Username: you@yourdomain.com
     *
     * Outgoing Server Settings: (Personal users with an email address, username@zoho.com):
     *
     * Outgoing Server Name: smtp.zoho.eu
     * Port: 465 with SSL or
     * Port: 587 with TLS
     * Require Authentication: Yes
     *
     * Outgoing Server Settings (Organization users with a domain-based email address, you@yourdomain.com):
     *
     * Outgoing Server Name: smtppro.zoho.eu
     * Port: 465 with SSL or
     * Port: 587 with TLS
     * Require Authentication: Yes
     *
     * User Name:  Enter your Zoho username or your complete Zoho Mail address.
     * If your domain is hosted with Zoho, then your email address will be in the format you@yourdomain.com.
     * Email Address: Enter Your Zoho Mail address. If your domain is hosted with Zoho, then your email address will be in the format you@yourdomain.com.
     * Password: Enter your Zoho account password.  (You might require an Application-specific Password if Two-factor Authentication is enabled).
     */
}
