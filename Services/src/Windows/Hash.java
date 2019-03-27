/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author josue
 */
public class Hash {
    
     public static String getSha(String input)
    {
        try { 
  
            // Static getInstance method is called with hashing SHA 
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
            // digest() method called 
            // to calculate message digest of an input 
            // and return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            return hashtext; 
        } 
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown"
                               + " for incorrect algorithm: " + e); 
            return null; 
        } 
    }
    
    public static boolean verifySha(String rute_old) throws IOException
    {
        String output_text = Archivo.leerArchivo(rute_old);
        
        char[] array = output_text.toCharArray();
        
        String aux="";
        String oo ="";
        
        for(int i=0;i<output_text.length()-65;i++)
            oo+=array[i];
        
        for(int i=output_text.length()-64;i<output_text.length();i++)
            aux+=array[i];
        
        String newSha = getSha(oo);
        System.out.println(aux);
        System.out.println(oo.length());
        
        return (aux.equalsIgnoreCase(newSha));
    }
    
    public static boolean verifySha2(String output_text)
    {
        char[] array = output_text.toCharArray();
        
        String aux="";
        String oo ="";
        
        for(int i=0;i<output_text.length()-65;i++)
            oo+=array[i];
        
        for(int i=output_text.length()-64;i<output_text.length();i++)
            aux+=array[i];
        
        
        String newSha = getSha(oo);
        System.out.println(aux);
        System.out.println(oo.length());
        
        return (aux.equalsIgnoreCase(newSha));
    }
    
}
