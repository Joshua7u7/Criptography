/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.swing.JOptionPane;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 *
 * @author josue
 */
public class RSA {
    
    public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  

        return cipher.doFinal(message.getBytes());  
    }
    
     public static byte[] encrypt(PrivateKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  

        return cipher.doFinal(message.getBytes());  
    }
    
    public static byte[] decrypt(PrivateKey privateKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        
        return cipher.doFinal(encrypted);
    }
    
    public static byte[] decrypt(PublicKey privateKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        
        return cipher.doFinal(encrypted);
    }
    
    public static KeyPair generarClave() throws NoSuchAlgorithmException {
        final int keySize = 1024;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }
    
     public static PublicKey cargarPublica(String ruta) throws NoSuchAlgorithmException, InvalidKeySpecException
     {
         PublicKey pk;
         
         PythonInterpreter Interpreter = new PythonInterpreter();
         Interpreter.execfile("C:\\Users\\josue\\Documents\\Criptography\\RSA\\python\\save.py");
         PyFunction LoadFunct = (PyFunction)Interpreter.get("Load", PyFunction.class);
         
        PyObject aux = LoadFunct.__call__(new PyString(ruta));
        byte[] kaux =(Py.tojava(aux,String.class)).getBytes();
     
        KeyFactory factory = KeyFactory.getInstance("RSA");
        EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(kaux));
        pk = factory.generatePublic(encodedKeySpec);
    
        //System.out.println(pk);
        //System.out.println("Llave publica recuperada");
        return pk;
     }
     
     
     public static PrivateKey cargarPrivada(String ruta) throws NoSuchAlgorithmException, InvalidKeySpecException
     {
         PrivateKey pk;
         
         PythonInterpreter Interpreter = new PythonInterpreter();
         Interpreter.execfile("C:\\Users\\josue\\Documents\\Criptography\\RSA\\python\\save.py");
         PyFunction LoadFunct = (PyFunction)Interpreter.get("Load", PyFunction.class);
         
        PyObject aux = LoadFunct.__call__(new PyString(ruta));
        byte[] kaux =(Py.tojava(aux,String.class)).getBytes();
        
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(kaux));
        pk = factory.generatePrivate(encodedKeySpec);
        //System.out.println(pk);
        //System.out.println("Llave privada recuperada");
        return pk;
     }
     
     public static byte[] fromStringToByte(String arreglo)
    {
        String[] items = arreglo.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        byte[] results = new byte[items.length];
        
        for (int i = 0; i < items.length; i++) {
        
        try {
            results[i] = Byte.parseByte(items[i]);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null,"Check the format bro");
        }}
        return results;
    }
    public static String fromByteToString(byte[] array)
    {
        String cad = "";
        for(int i = 0; i < array.length; i++)
        {
            cad += (char)array[i];
        }
        return cad;
    }
    
}
