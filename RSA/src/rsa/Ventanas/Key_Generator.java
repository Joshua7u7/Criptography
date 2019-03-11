/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.Ventanas;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.swing.JOptionPane;
/**
 *
 * @author josue
 */
public class Key_Generator {

/*    
public static KeyPair generarClave() 
{
    KeyPair clave = null;//La clase KeyPair soporta una clave privada y una pública.
    try {
        //Usamos el algoritmo RSA (RSA es un sistema criptográfico de clave pública desarrollado en 1977).
        KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        generador.initialize(1024);//Tamaño de la clave.

        clave = generador.genKeyPair();
    } catch (NoSuchAlgorithmException e) {
        JOptionPane.showMessageDialog(null,"Sorry, we couldnt create the keys  ");
    }
    return clave;
}
*/
    
   public static KeyPair generarClave() throws NoSuchAlgorithmException {
        final int keySize = 1024;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }

}
