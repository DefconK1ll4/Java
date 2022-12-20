package com.mailservice.sendit;

import com.mailservice.sendit.mailprotocol.IMAP;
import com.mailservice.sendit.mailprotocol.SMTP;
import com.mailservice.sendit.serviceprovider.AOL;

public class User extends AOL implements IMAP, SMTP {
    @Override
    public int getIMAPPort() {
        return 0;
    }

    @Override
    public int getSMTPPort() {
        return 0;
    }


}
