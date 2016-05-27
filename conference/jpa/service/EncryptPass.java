package com.conference.jpa.service;

public class EncryptPass {
    public EncryptPass() {
    }

    public static String encPass( String password ) {
        return BCrypt.hashpw( password, BCrypt.gensalt( 12 ) );
    }

    public static boolean verifiePass( String blankPass, String securePass ) {
        return BCrypt.checkpw( blankPass, securePass );
    }
}