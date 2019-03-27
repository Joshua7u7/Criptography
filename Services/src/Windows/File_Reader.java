/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class File_Reader {
    
    public static ArrayList ReadTextNDKey(String path) throws IOException
    {
        ArrayList<String> array = new ArrayList<>();
        String text="",key="";
        String message = Archivo.leerArchivo(path);
        
        char[] aux=message.toCharArray();
        int contador=0;
        
        for(int i=0;i<message.length();i++)
        {
            if(aux[i]=='[')
                contador+=1;
            
            if(contador==0)
                text+=aux[i];
            else
                key+=aux[i];
        }
        array.add(text);
        array.add(key);
        
        return array;
    }
    
    public static String getKeyFromFile(String file,PrivateKey key) throws IOException, Exception
    {
        ArrayList array;
        array = ReadTextNDKey(file);
        String A_key = array.get(1).toString();
        return RSA.fromByteToString( RSA.decrypt(key, RSA.fromStringToByte(A_key)));
    }
    
    public static String getHashFromFile(String file,PublicKey key) throws IOException, Exception
    {
        ArrayList array;
        array = ReadTextNDKey(file);
        String A_key = array.get(1).toString();
        return RSA.fromByteToString( RSA.decrypt(key, RSA.fromStringToByte(A_key)));
    }
    
    public static ArrayList separateTextNDHash(String message)
    {
        ArrayList<String> array = new ArrayList<>();
        String text="",hash="";
        
        char[] aux=message.toCharArray();
        int contador=0;
        
        for(int i=0;i<message.length();i++)
        {
            if(aux[i]=='[')
                contador+=1;
            
            if(contador==0)
                text+=aux[i];
            else
                hash+=aux[i];
        }
        array.add(text);
        array.add(hash);
        
        return array;
    }
    
}
