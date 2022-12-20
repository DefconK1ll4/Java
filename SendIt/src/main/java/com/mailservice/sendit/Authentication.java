package com.mailservice.sendit;

import com.mailservice.sendit.authentication.SSL;
import com.mailservice.sendit.authentication.TLS;

public class Authentication implements TLS, SSL {
    @Override
    public boolean isSSL() {
        return false;
    }

    @Override
    public boolean isTLS() {
        return false;
    }

    // Abstract factory
    // Creating instances and returning depending on the authentication the user wants.


}
