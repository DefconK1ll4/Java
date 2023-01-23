package com.mailservice.sendit.serviceprovider;

import com.mailservice.sendit.ServiceProvider;
import com.mailservice.sendit.authentication.SSL;
import com.mailservice.sendit.authentication.TLS;

public abstract class Gmail extends ServiceProvider implements SSL, TLS {
    @Override
    public boolean isSSL() {
        return false;
    }

    @Override
    public boolean isTLS() {
        return false;
    }
/***
     * Med IMAP kan du läsa Gmail-meddelanden på flera enheter och meddelandena synkroniseras i realtid.
     * Du kan även läsa Gmail-meddelanden med hjälp av POP.
     *
     * Viktigt! Undvik att bli utelåst från ditt konto genom att se till att du inte överskrider 2500MB per dag för
     * IMAP-nedladdningar och 500MB per dag för IMAP-uppladdningar.
     * Om du konfigurerar ett enda IMAP-konto på flera datorer bör du ta en paus mellan varje konfiguration.
     *
     * Server för inkommande e-post (IMAP)
     *
     * imap.gmail.com
     *
     * Kräver SSL: Ja
     *
     * Port: 993
     * Server för utgående e-post (SMTP)
     *
     * smtp.gmail.com
     *
     * Kräver SSL: Ja
     *
     * Kräver TLS: Ja (om tillgängligt)
     *
     * Kräver autentisering: Ja
     *
     * Port för SSL: 465
     *
     * Port för TLS/STARTTLS: 587
     * Fullständigt namn eller visningsnamn 	Ditt namn
     * Kontonamn, användarnamn eller e-postadress 	Din fullständiga e-postadress
     * Lösenord 	Ditt Gmail-lösenord
     */
}
