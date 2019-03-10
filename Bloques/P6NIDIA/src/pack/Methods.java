/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sebas
 This clas contains all the Methods to be used in the Practice of AES and DES ciphers
 */
public class Methods {
    
    
    /**
     * Obtain the rute of a file
     * @return Returns a String with the rute of the file that is selected on the FileChooser if the rute can not be obtained returns null
    */
    public String rute(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen BMP", "bmp");
        String rute = "";
        File d = new File("C:\\Users\\josue\\Documents\\Criptography\\Bloques\\P6NIDIA\\Imagenes");
        try {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("SELECT BMP");
        chooser.setCurrentDirectory(d);
        int option = chooser.showOpenDialog(chooser);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = chooser.getSelectedFile();
            rute = f.getAbsolutePath();
            return rute;
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * Set an image in a JLabel
     * @param rute The string that has rute of the image
     * @param label The JLabel where you want to put the image
     * @throws java.io.IOException
    */
    public void showImg(String rute, JLabel label) throws IOException{
        File f = new File(rute);
        Image image = ImageIO.read(f);
        ImageIcon icon = new ImageIcon(image);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        label.setText(null);
        label.setIcon(icono);
    }
    
    /**
     * Encrypt the image with the AES method
     * @param rute The string that has rute of the image
     * @param output The string of the path where you want to save the encrypted image
     * @param method The method that you want to use to cipher.
     * @param mode The mode of the cipher that you want to use to encrypt
     * @param key The key to pass in to the encryption function
     * @throws java.lang.Exception
    */
    public void encrypt(String rute, String output, String method, String mode, String key) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initialize(method, mode, key, 1);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Encrypt the image with the AES method
     * @param rute The string that has rute of the image
     * @param output The string of the path where you want to save the encrypted image
     * @param method The method that you want to use to cipher.
     * @param mode The mode of the cipher that you want to use to encrypt
     * @param key The key to pass in to the encryption function
     * @param iv The initializacion vector to encrypt the first block of data.
     * @throws Exception
     */
    public void encrypt(String rute, String output, String method, String mode, String key, String iv) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initialize(method, mode, key, iv, 1);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Decrypt the image with the AES method
     * @param rute The string that has rute of the encrypted image
     * @param output The string of the path where you want to save the decrypted image
     * @param method The method that you want to use to decrypt.
     * @param mode The mode of the cipher that you want to use to decrypt.
     * @param key The key to pass in to the dcryption function
     * @throws Exception
     */
    public void decrypt(String rute, String output, String method, String mode, String key) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initialize(method, mode, key, 2);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Decrypt the image with the AES method
     * @param rute The string that has rute of the encrypted image
     * @param output The string of the path where you want to save the decrypted image
     * @param method The method that you want to use to decrypt.
     * @param mode The mode of the cipher that you want to use to decrypt.
     * @param key The key to pass in to the dcryption function
     * @param iv The initializacion vector to decrypt the first block of data.
     * @throws Exception
     */
    public void decrypt(String rute, String output, String method, String mode, String key, String iv) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initialize(method, mode, key, iv, 2);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Initialize the cipher to the method and the mode that is provide
     * @param method The method that is being used to encrypt
     * @param mode The mode that is being used to encrypt
     * @param key The key to pass in to the decryption function
     * @param ed 1 to encript and 2 to decrypt
     * @return The cipher to encrypt the image
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public Cipher initialize(String method, String mode, String key, int ed) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        Cipher cipher = Cipher.getInstance(mode);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), method);
        switch (ed) {
            case 1:
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
                return cipher;
            case 2:
                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
                return cipher;
            default:
                return null;
        }
    }
    
    /**
     * Initialize the cipher to the method and the mode that is provide
     * @param method The method that is being used to encrypt
     * @param mode The mode that is being used to encrypt
     * @param key The key to pass in to the decryption function
     * @param iv The initialization vector
     * @param ed 1 to encript and 2 to decrypt
     * @return The cipher to encrypt the image
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     */
    public Cipher initialize(String method, String mode, String key, String iv, int ed) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException{
        Cipher cipher = Cipher.getInstance(mode);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), method);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        switch (ed) {
            case 1:
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
                return cipher;
            case 2:
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
                return cipher;
            default:
                return null;
        }
    }
    
    /**
     * Initialize the cipher to the method and the mode that is provide the diference between the other method is the form wich the key is cipher
     * @param method The method that is being used to encrypt
     * @param mode The mode that is being used to encrypt
     * @param key The key to pass in to the decryption function
     * @param iv The initialization vector
     * @param ed 1 to encript and 2 to decrypt
     * @return The cipher to encrypt the image
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws Exception
     */
    public Cipher initializeDES(String method, String mode, String key, String iv, int ed) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, Exception{
        Cipher cipher = Cipher.getInstance(mode);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        SecretKey skeySpec = generateKey(key);
        switch (ed) {
            case 1:
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
                return cipher;
            case 2:
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
                return cipher;
            default:
                return null;
        }
    }
    
    /**
     * Initialize the cipher to the method and the mode that is provide the diference between the other method is the form wich the key is cipher
     * @param method The method that is being used to encrypt
     * @param mode The mode that is being used to encrypt
     * @param key The key to pass in to the decryption function
     * @param ed 1 to encript and 2 to decrypt
     * @return The cipher to encrypt the image
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws Exception
     */
    public Cipher initializeDES(String method, String mode, String key, int ed) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, Exception{
        Cipher cipher = Cipher.getInstance(mode);
        SecretKey skeySpec = generateKey(key);
        switch (ed) {
            case 1:
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
                return cipher;
            case 2:
                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
                return cipher;
            default:
                return null;
        }
    }
    
    /**
     * Cipher the key provided
     * @param stringKey The string with the key
     * @return SecretKey a cipher key
     * @throws Exception
     */
    public SecretKey generateKey( String stringKey ) throws Exception{
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        DESKeySpec kspec = new DESKeySpec(stringKey.getBytes());
        SecretKey ks = skf.generateSecret(kspec);
        return ks;
    }
    
    /**
     * Encrypt the image with the DES method
     * @param rute The string that has rute of the image
     * @param output The string of the path where you want to save the encrypted image
     * @param method The method that you want to use to cipher.
     * @param mode The mode of the cipher that you want to use to encrypt
     * @param key The key to pass in to the encryption function
     * @throws Exception
     */
    public void encryptDES(String rute, String output, String method, String mode, String key) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initializeDES(method, mode, key, 1);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Encrypt the image with the DES method
     * @param rute The string that has rute of the image
     * @param output The string of the path where you want to save the encrypted image
     * @param method The method that you want to use to cipher.
     * @param mode The mode of the cipher that you want to use to encrypt
     * @param key The key to pass in to the encryption function
     * @param iv The initializacion vector to encrypt the first block of data.
     * @throws Exception
     */
    public void encryptDES(String rute, String output, String method, String mode, String key, String iv) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initializeDES(method, mode, key, iv, 1);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Decrypt the image with the DES method
     * @param rute The string that has rute of the encrypted image
     * @param output The string of the path where you want to save the decrypted image
     * @param method The method that you want to use to decrypt.
     * @param mode The mode of the cipher that you want to use to decrypt.
     * @param key The key to pass in to the dcryption function
     * @throws Exception
     */
    public void decryptDES(String rute, String output, String method, String mode, String key) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initializeDES(method, mode, key, 2);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
    
    /**
     * Decrypt the image with the DES method
     * @param rute The string that has rute of the encrypted image
     * @param output The string of the path where you want to save the decrypted image
     * @param method The method that you want to use to decrypt.
     * @param mode The mode of the cipher that you want to use to decrypt.
     * @param key The key to pass in to the dcryption function
     * @param iv The initializacion vector to decrypt the first block of data.
     * @throws Exception
     */
    public void decryptDES(String rute, String output, String method, String mode, String key, String iv) throws Exception {
            int nBytes;
            FileInputStream inputFile = new FileInputStream(rute);
            FileOutputStream outputFile = new FileOutputStream(output);
            byte[] headerBMP = new byte[58], buffer = new byte[1024], encryptedBlock;
            inputFile.read(headerBMP);
            outputFile.write(headerBMP);
            Cipher cipher = initializeDES(method, mode, key, iv, 2);
            while ((nBytes = inputFile.read(buffer))!=-1) {            
                encryptedBlock = cipher.update(buffer, 0, nBytes);
                outputFile.write(encryptedBlock);
            }
            encryptedBlock = cipher.doFinal();
            outputFile.write(encryptedBlock);
            
            inputFile.close();
            outputFile.close();
    }
}
