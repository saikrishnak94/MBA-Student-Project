package com.mba.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.SecureRandom;

public class EncodedProgram {
   /*private static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException 
    {
        String passwordToHash = "password";
        byte[] salt = getSalt();
         
        String securePassword = getSecurePassword(passwordToHash, salt);
        System.out.println(securePassword); 
         
        String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, salt);
        System.out.println(regeneratedPassowrdToVerify);
    }
    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }*/
	public static String hide(String pwd){
		MessageDigest digest;
		String pwrd=null;
		try {
            //MessageDigest digest=MessageDigest.get("SHA-1");
			digest = MessageDigest.getInstance("MD5");
            digest.update(pwd.getBytes());
            byte[] bytes = digest.digest();
            StringBuilder sb = new StringBuilder(); //same as StingBuffer stores object in heap and it can be modified.
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pwrd = sb.toString().toLowerCase();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
		return pwrd;
	}
	/*
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //create for loop again
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
*/
}

/*
 
public class SHAExample {
     
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String passwordToHash = "password";
        byte[] salt = getSalt();
         
        String securePassword = get_SHA_1_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);
         
        securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);
         
        securePassword = get_SHA_384_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);
         
        securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);
    }
 
    private static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt)
    {
        //Use MessageDigest md = MessageDigest.getInstance("SHA-256");
    }
     
    private static String get_SHA_384_SecurePassword(String passwordToHash, byte[] salt)
    {
        //Use MessageDigest md = MessageDigest.getInstance("SHA-384");
    }
     
    private static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt)
    {
        //Use MessageDigest md = MessageDigest.getInstance("SHA-512");
    }
     
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
} 
*/ 
