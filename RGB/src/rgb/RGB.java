/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgb;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author josue
 */
public class RGB {

    private int alto;
    private int ancho;
    private String path;
    
    public RGB(String imagen) { this.path=imagen; }
    
    public BufferedImage addImage() throws FileNotFoundException, IOException
    {
        InputStream input = new FileInputStream(this.path);
        ImageInputStream imageInput = ImageIO.createImageInputStream(input);
        BufferedImage imageL = ImageIO.read(imageInput);
        
        setAlto(imageL.getHeight());
        setAncho(imageL.getWidth());
        
        return imageL;
    }
    
    public void crearImagen(BufferedImage buffer) throws IOException
    {
        BufferedImage salida = new BufferedImage(getAncho(), getAlto(), BufferedImage.TYPE_INT_RGB);
        
        for(int y=0; y < getAlto(); y++)
        {
            for(int x=0; x < getAncho(); x++)
            {
                int srcPixel = buffer.getRGB(x , y);
                Color c = new Color(srcPixel);
                
                int valR = c.getRed();
                int valG = c.getGreen();
                int valB = c.getBlue();
                
                Color nuevo =new Color((valR+100)%255,(valG+216)%255,(valB+50)%255);
                
                salida.setRGB(x, y, nuevo.getRGB());
                
                System.out.print(" r "+valR+" g"+valG+" b "+valB);
            }
            System.out.println("");
        }
        File outputfile = new File("C:\\Users\\josue\\Documents\\Criptography\\RGB\\src\\rgb\\saved.bmp");
        ImageIO.write(salida, "png", outputfile);
    }
    
    
    public void setAlto(int alto){this.alto=alto;}
    
    public void setAncho(int ancho) {this.ancho=ancho;}
    
    public int getAlto() {return this.alto;}
    
    public int getAncho() {return this.ancho;}
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
   
    public void hacerTodo() throws IOException
    {
        
    }
    
}
