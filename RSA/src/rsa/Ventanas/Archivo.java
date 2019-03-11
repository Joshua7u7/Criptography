/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author josue
 */
public class Archivo {
    private static Object interpreter;
    
     public static String rute(String actual_path,String title,String type){
        FileNameExtensionFilter filter = new FileNameExtensionFilter(title, type);
        String rute = "";
        File d = new File(actual_path);
        try {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setDialogTitle(title);
        chooser.setCurrentDirectory(d);
        int option = chooser.showOpenDialog(chooser);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = chooser.getSelectedFile();
            rute = f.getAbsolutePath();
            return rute;
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"You didnt select any key yet");
        }
        return null;
    }
     
     public static String MessageFromFile(String rute) throws FileNotFoundException, IOException
     {
       
        StringBuilder cad = new StringBuilder();
        String cadena;
        FileReader f = new FileReader(rute);
         try (BufferedReader b = new BufferedReader(f)) {
             while((cadena = b.readLine())!=null) {
                 cad.append(cadena).append("\n");
             }}
        return cad.toString();
     }
     
     public static void GuardarLLave(String path,String namePublic,String namePrivate,KeyPair llaves)
     {
         PythonInterpreter interpreter = new PythonInterpreter();
         interpreter.execfile("C:\\Users\\josue\\Documents\\Criptography\\RSA\\python\\save.py");
         PyFunction DumpFunct = (PyFunction)interpreter.get("Dump", PyFunction.class);
         
         String pu = path+namePublic;
         String priv = path+namePrivate;
         
         DumpFunct.__call__(Py.java2py(Base64.getEncoder().encode(llaves.getPrivate().getEncoded())),new PyString(priv));
         DumpFunct.__call__(Py.java2py(Base64.getEncoder().encode(llaves.getPublic().getEncoded())),new PyString(pu));   
     }
     
     public static PublicKey cargarPublica(String ruta) throws NoSuchAlgorithmException, InvalidKeySpecException
     {
         PublicKey pk = null;
         
         PythonInterpreter interpreter = new PythonInterpreter();
         interpreter.execfile("C:\\Users\\josue\\Documents\\Criptography\\RSA\\python\\save.py");
         PyFunction LoadFunct = (PyFunction)interpreter.get("Load", PyFunction.class);
         
        PyObject aux = LoadFunct.__call__(new PyString(ruta));
        byte[] kaux =(Py.tojava(aux,String.class)).getBytes();
        
        System.out.println(kaux);
        
     
        KeyFactory factory = KeyFactory.getInstance("RSA");
        EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(kaux));
        pk = factory.generatePublic(encodedKeySpec);
    
        System.out.println(pk);
        return pk;
     }
     
     
     public static PrivateKey cargarPrivada(String ruta) throws NoSuchAlgorithmException, InvalidKeySpecException
     {
         PrivateKey pk = null;
         
         PythonInterpreter interpreter = new PythonInterpreter();
         interpreter.execfile("C:\\Users\\josue\\Documents\\Criptography\\RSA\\python\\save.py");
         PyFunction LoadFunct = (PyFunction)interpreter.get("Load", PyFunction.class);
         
        PyObject aux = LoadFunct.__call__(new PyString(ruta));
        byte[] kaux =(Py.tojava(aux,String.class)).getBytes();
        
        System.out.println(kaux);
        
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(kaux));
        pk = factory.generatePrivate(encodedKeySpec);
        System.out.println(pk);
        return pk;
     }
}
