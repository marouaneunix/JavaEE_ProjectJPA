package com.conference.jpa.service;

/**
 * Created by mar1 on 4/26/16.
 */
public class EncryptPass {

    // private static ConfigurablePasswordEncryptor passwordEncryptor = new
    // ConfigurablePasswordEncryptor();
    //
    // private static final String ENCRIPTION_ALGO = "SHA-1";
    //
    // public static String encpass( String plainText ) {
    //
    // passwordEncryptor.setAlgorithm( ENCRIPTION_ALGO );
    // passwordEncryptor.setPlainDigest( false );
    // return passwordEncryptor.encryptPassword( plainText );
    // }
    //
    // public static boolean verifiePass( String plainTExt, String passwd ) {
    // if ( passwordEncryptor.checkPassword( plainTExt, passwd ) )
    // return true;
    // else
    // return false;
    // }

    // public static String SHA_1_Encryption( String pass ) {
    //
    // String securePass = null;
    // try {
    // byte[] salt = getSalt();
    // MessageDigest md = MessageDigest.getInstance( "SHA-1" );
    // md.update( salt );
    // byte[] bytes = md.digest( pass.getBytes() );
    // StringBuilder sb = new StringBuilder();
    // for ( int i = 0; i < bytes.length; i++ ) {
    // sb.append( Integer.toString( ( bytes[i] & 0xff ) + 0x100, 16 ).substring(
    // 1 ) );
    //
    // }
    // securePass = sb.toString();
    // } catch ( NoSuchAlgorithmException e ) {
    // e.printStackTrace();
    // }
    // return securePass;
    // }
    //
    // public static boolean verifiePass( String securePass, String blankPass )
    // {
    // if ( securePass.equals( SHA_1_Encryption( blankPass ) ) )
    // return true;
    // else
    // return false;
    //
    // }
    //
    // private static byte[] getSalt() throws NoSuchAlgorithmException {
    // SecureRandom sr = SecureRandom.getInstance( "SHA1PRNG" );
    // byte[] salt = new byte[16];
    // sr.nextBytes( salt );
    // return salt;
    // }

    public static String encPass( String password ) {
        return BCrypt.hashpw( password, BCrypt.gensalt( 12 ) );
    }

    public static boolean verifiePass( String blankPass, String securePass ) {
        return BCrypt.checkpw( blankPass, securePass );
    }

}
