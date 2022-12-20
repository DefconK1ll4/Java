package com.mailservice.sendit.serviceprovider;

public abstract class iCloud {
    /***
     *
     IMAP-information för den inkommande iCloud Mail-servern

     Servernamn: imap.mail.me.com
     SSL krävs: Ja
     Om ett felmeddelande visas vid användning av SSL prövar du TLS istället.
     Port: 993
     Användarnamn: Det här är oftast namnet på iCloud Mail-e-postadressen (till exempel johnappleseed, inte johnappleseed@icloud.com).
     Om e-postappen inte kan ansluta till iCloud Mail med endast namndelen av e-postadressen prövar du med hela adressen.
     Lösenord: Generera ett appspecifikt lösenord.

     SMTP-information för den inkommande iCloud Mail-servern

     Servernamn: smtp.mail.me.com
     SSL krävs: Ja
     Om ett felmeddelande visas vid användning av SSL prövar du TLS eller STARTTLS istället.
     Port: 587
     SMTP-autentisering krävs: Ja
     Användarnamn: Din fullständiga iCloud Mail-e-postadress (till exempel johnappleseed@icloud.com, inte johnappleseed)
     Lösenord: Använd det appspecifika lösenordet som du skapade när du konfigurerade servern för inkommande e-post.


     */
}
