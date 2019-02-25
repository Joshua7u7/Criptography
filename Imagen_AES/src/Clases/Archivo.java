 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author josue
 */
public class Archivo {

    private String ruta;
    
    public Archivo(){}
    
    
    public void mostrarEntrada()
    {
        String file = getRuta(); 
   
         try{ 
         //definiendo la ruta en la propiedad file
         Runtime.getRuntime().exec("cmd /c start "+file);
        }catch(IOException e){
        } 
    }
    
    public void mostrarSalida()
    {
         if(getRuta()!=null)
        {
            String file = "C:\\Users\\josue\\Documents\\Criptography\\Imagen_AES\\src\\Imagenes\\saved.jpg"; 
   
         try{ 
         //definiendo la ruta en la propiedad file
         Runtime.getRuntime().exec("cmd /c start "+file);
        }catch(IOException e){
        } 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sorry, you must encrypt or decrypt a file first at all");
        }
    }
    
    public void setRuta(String ruta){ this.ruta=ruta; }
    
    public String getRuta(){ return this.ruta; }
    
    
    
}