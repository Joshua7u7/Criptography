/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import Clases.Bloques.ECB;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Imagen 
{
   private int alto;
   private int ancho;
   InputStream i;
   private String path;
   
   public Imagen(String imagen)
   { 
        this.path=imagen;
   }
   
    public BufferedImage addImage() throws FileNotFoundException, IOException
    {
        InputStream input = new FileInputStream(this.path);
        ImageInputStream imageInput = ImageIO.createImageInputStream(input);
        BufferedImage imageL = ImageIO.read(imageInput);
        
        setAlto(imageL.getHeight());
        setAncho(imageL.getWidth());
        setArchivo(input);
        
        return imageL;
    }
    
    public void crearImagenCifrada(BufferedImage buffer,int n) throws IOException, Exception
    {
        BufferedImage img=addImage();
        
        WritableRaster raster = img.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        
        byte[] datos;
        datos = data.getData();
        
        byte[]datos_cifrados=cifrarBloque(n,datos);
        
        for(int k=0;k<100;k++)
        {
            System.out.printf("0x%04x",datos_cifrados[k]);
            System.out.print("\n");
        }
         
        BufferedImage imagen_salida = new BufferedImage(getAncho(),getAlto(), BufferedImage.TYPE_3BYTE_BGR);
        int j=0;
        for(int y=0;y<getAlto();y++)
        {
            for(int x=0;x<getAncho();x++)
            {
                imagen_salida.setRGB(x,y,datos_cifrados[j]);
                j+=1;
            }
        }
       
       
        File outputfile = new File("C:\\Users\\josue\\Documents\\Criptography\\Imagen_AES\\src\\Imagenes\\saved.jpg");
	
        ImageIO.write(imagen_salida, "jpg",outputfile);

        JOptionPane.showMessageDialog(null,"Vamos bien we");
     
    }
    
    public void crearImagenDecifrada(BufferedImage buffer,int n) throws IOException, Exception
    {
        BufferedImage img=addImage();
        
        WritableRaster raster = img.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        
        byte[] datos;
        datos = data.getData();
        
        byte[]datos_cifrados=decifrarBloque(n,datos);
        
        for(int k=0;k<100;k++)
        {
            System.out.printf("0x%04x",datos_cifrados[k]);
            System.out.print("\n");
        }
         
        BufferedImage imagen_salida = new BufferedImage(getAncho(),getAlto(), BufferedImage.TYPE_3BYTE_BGR);
        int j=0;
        for(int y=0;y<getAlto();y++)
        {
            for(int x=0;x<getAncho();x++)
            {
                imagen_salida.setRGB(x,y,datos_cifrados[j]);
                j+=1;
            }
        }
       
       
        File outputfile = new File("C:\\Users\\josue\\Documents\\Criptography\\Imagen_AES\\src\\Imagenes\\saved.jpg");
	
        ImageIO.write(imagen_salida, "jpg",outputfile);

        JOptionPane.showMessageDialog(null,"Creo que si deciframos chido compa");
 

    }
    
    public void setAlto(int alto){this.alto=alto;}
    
    public void setAncho(int ancho) {this.ancho=ancho;}
    
    public int getAlto() {return this.alto;}
    
    public int getAncho() {return this.ancho;}
    
    public void setArchivo(InputStream i){this.i=i;}
    
    public InputStream getArchivo(){ return this.i; }
    
    public byte[] cifrarBloque(int n, byte[] b) throws Exception
    {
        ECB instancia = new ECB();
        return(instancia.encrypt("0123456789ABCDEF", "ABCDEF0123456789",b));
    }
    
    public byte[] decifrarBloque(int n, byte[] b) throws Exception
    {
        ECB instancia = new ECB();
        return(instancia.decrypt("0123456789ABCDEF", "ABCDEF0123456789",b));
    }
}