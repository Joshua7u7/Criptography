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
import java.lang.reflect.Array;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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
   
   private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
   
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
       
        BufferedImage imagen_salida = new BufferedImage(getAncho(),getAlto(), BufferedImage.TYPE_3BYTE_BGR);
        String cadena_salida="";
        
        for(int y=0;y<getAlto();y++)
        {
            for(int x=0;x<getAncho();x++)
            {
                int pixel = buffer.getRGB(x,y);
    	        Color color = new Color(pixel);
                String res;
    		int valR = color.getRed();
                int valG = color.getGreen();
                int valB = color.getBlue();
                int resultado=(valR<<16)|(valG<<8)|(valB);
                res=Integer.toString(resultado);
                cadena_salida+=res;
                System.out.printf("0x%06x  ",resultado);
               // System.out.print(" R: "+valR + " G: "+valG+" B: "+valB);
            }
            System.out.println(cadena_salida);
        }
        
        char[] joshua = cadena_salida.toCharArray();
        
        String joshua_cad="";
        int mod=0;
        String cifrado="";
        for(int i=0;i<joshua.length;i++)
        {
          if(i==0 || (i%16)==0)
          {
              cifrado+=cifrarBloque(n,joshua_cad);
              
              System.out.println(cifrado +"---------------|");
              joshua_cad="";
          }
          else if(i==0)
            joshua_cad+=joshua[i];
          else
            joshua_cad+=joshua[i];
          
        }
        
        File outputfile = new File("C:\\Users\\josue\\Documents\\Criptography\\Imagen_AES\\src\\Imagenes\\saved.bmp");
	
        ImageIO.write(imagen_salida, "bmp",outputfile);

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

        BufferedImage imagen_salida = new BufferedImage(getAncho(),getAlto(), BufferedImage.TYPE_3BYTE_BGR);
        
        int j=0,cont=1;
        byte[] datos_descifrados= new byte[3];
        
        for(int y=0;y<getAlto();y++)
        {
            for(int x=0;x<getAncho();x++)
            {
                        datos_descifrados[0]=(byte) (datos_cifrados[j] << 16);
                        datos_descifrados[1]=(byte) (datos_cifrados[j+1] << 8);
                        datos_descifrados[2]=(byte) (datos_cifrados[j+2]);
                        j=j+3;
                        int var = datos_descifrados[0]+datos_descifrados[1]+datos_descifrados[2]; 
                    imagen_salida.setRGB(x,y,var);
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
    
    public String cifrarBloque(int n, String b) throws Exception
    {
        /*
        ECB instancia = new ECB();
        return(instancia.encrypt("0123456789ABCDEF", "ABCDEF0123456789",b));
        */        
        String key="0123456789ABCDEF";
        String iv = "0123456789ABCDEF";
        
        Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted=null;
            try
            {
                encrypted= cipher.doFinal(b.getBytes());
            }catch (IllegalBlockSizeException | BadPaddingException BadPaddingException)
            {
                System.out.println("No se pudo we :| ----");
            }
            
                
            
           return new String(encrypted);
    }
    
    public byte[] decifrarBloque(int n, byte[] b) throws Exception
    {
        /*
        ECB instancia = new ECB();
        return(instancia.decrypt("0123456789ABCDEF", "ABCDEF0123456789",b));
        */
         String key="0123456789ABCDEF";
        String iv = "0123456789ABCDEF";
        
        Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = b;
            try
            {
               decrypted = cipher.doFinal(b);
            }catch(IllegalBlockSizeException | BadPaddingException BadPaddingException){
                System.err.println("Sigue sin poderse we :|");
            }
            return decrypted;
    }
}