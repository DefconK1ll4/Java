package com.mailservice.sendit.serviceprovider;

import com.mailservice.sendit.ServiceProvider;
import com.mailservice.sendit.authentication.SSL;
import com.mailservice.sendit.authentication.TLS;

public abstract class Yahoo extends ServiceProvider implements SSL, TLS {
    @Override
    public boolean isSSL() {
        return false;
    }

    @Override
    public boolean isTLS() {
        return false;
    }
/***
     * Incoming Mail (IMAP) Server
     *
     *     Server - imap.mail.yahoo.com
     *     Port - 993
     *     Requires SSL - Yes
     *
     * Outgoing Mail (SMTP) Server
     *
     *     Server - smtp.mail.yahoo.com
     *     Port - 465 or 587
     *     Requires SSL - Yes
     *     Requires authentication - Yes
     *
     * Your login info
     *
     *     Email address - Your full email address (name@domain.com)
     *     Password - Generate App Password
     *     Requires authentication - Yes
     *
     *
     *    Need 2-way syncing?
     * Want to connect your Yahoo Mail account to a desktop mail client or mobile app for 2-way syncing? See SLN4075.
     */
}
