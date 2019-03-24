/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author josue
 */
public class Archivo {
    
    public static String rute(String actual_path,String title,String type){
        FileNameExtensionFilter filter = new FileNameExtensionFilter(title, type);
        String rute;
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
            JOptionPane.showMessageDialog(null,"You didnt select any text yet");
        }
        return null;
    }
    
    public static void mostrarArchivo(String ruta)
    {
         try{ 
         //definiendo la ruta en la propiedad file
         Runtime.getRuntime().exec("cmd /c start "+ruta);
        }catch(IOException e){
        } 
    }
    
    public static void escribirArchivo(String file,String rute) throws FileNotFoundException, UnsupportedEncodingException
    {
        File nuevo=new File(rute);        
        try (PrintWriter fw = new PrintWriter(nuevo,"utf-8")) {
            fw.println(file);
            fw.close();
        }
    }
    
    public static String leerArchivo(String file) throws FileNotFoundException, IOException
    {
        StringBuilder cad = new StringBuilder();
        String cadena;
        //FileReader f = new FileReader(rute);
        File f = new File(file);
        try (BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(f),StandardCharsets.UTF_8))) {
             while((cadena = b.readLine())!=null) {
                 cad.append(cadena).append("\n");
             }}
        cad.deleteCharAt(cad.length()-1);
        return cad.toString();   
    }
    
    
    
}
