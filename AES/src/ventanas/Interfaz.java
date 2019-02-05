/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

 

/**
 *
 * @author josue
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    private String archivo;
    StringBuilder letra;
    
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.letra=new StringBuilder();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFondo = new javax.swing.JLabel();
        jLabelAES = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Cryptography = new javax.swing.JLabel();
        jLabelFondo2 = new javax.swing.JLabel();
        Select = new javax.swing.JButton();
        Entry = new javax.swing.JButton();
        Output = new javax.swing.JButton();
        Key = new javax.swing.JLabel();
        JKEY = new javax.swing.JTextField();
        Encrypt = new javax.swing.JButton();
        Decrypt = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel1");

        jLabelAES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/black.jpg"))); // NOI18N
        jLabelAES.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Josue Ruiz Hernandez");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 40));

        Cryptography.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Cryptography.setForeground(new java.awt.Color(255, 255, 255));
        Cryptography.setText("Cryptography");
        getContentPane().add(Cryptography, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 160, -1));

        jLabelFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aes.png"))); // NOI18N
        getContentPane().add(jLabelFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        Select.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Select.setForeground(new java.awt.Color(255, 255, 255));
        Select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        Select.setText("Select file");
        Select.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });
        getContentPane().add(Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, 40));

        Entry.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Entry.setForeground(new java.awt.Color(255, 255, 255));
        Entry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        Entry.setText("See entry");
        Entry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntryActionPerformed(evt);
            }
        });
        getContentPane().add(Entry, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 130, 40));

        Output.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Output.setForeground(new java.awt.Color(255, 255, 255));
        Output.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        Output.setText("See output");
        Output.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });
        getContentPane().add(Output, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 40));

        Key.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Key.setForeground(new java.awt.Color(255, 255, 255));
        Key.setText("Type key");
        getContentPane().add(Key, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        JKEY.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        JKEY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JKEYActionPerformed(evt);
            }
        });
        getContentPane().add(JKEY, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 160, 30));

        Encrypt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Encrypt.setForeground(new java.awt.Color(255, 255, 255));
        Encrypt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        Encrypt.setText("Encrypt");
        Encrypt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptActionPerformed(evt);
            }
        });
        getContentPane().add(Encrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 130, 40));

        Decrypt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Decrypt.setForeground(new java.awt.Color(255, 255, 255));
        Decrypt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        Decrypt.setText("Decrypt");
        Decrypt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptActionPerformed(evt);
            }
        });
        getContentPane().add(Decrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 130, 40));

        Exit.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cp3.jpg"))); // NOI18N
        Exit.setText("Exit");
        Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 130, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/black3.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
         JFileChooser file = new JFileChooser();
        
        int opcion=file.showOpenDialog(this);
        
        if(opcion==JFileChooser.APPROVE_OPTION)
        {
            String nombre=file.getSelectedFile().getPath();
            
            String ruta=file.getSelectedFile().toString();
            
            JOptionPane.showMessageDialog(null,"File successfully loaded");
            
            setArchivo(ruta);
        }
    }//GEN-LAST:event_SelectActionPerformed

    private void EntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntryActionPerformed
        String file = getArchivo(); 
   
         try{ 
         //definiendo la ruta en la propiedad file
         Runtime.getRuntime().exec("cmd /c start "+file);
        }catch(IOException e){
        } 
    }//GEN-LAST:event_EntryActionPerformed

    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        if(getArchivo()!=null)
        {
            String file = "C:\\Users\\josue\\Documents\\Criptography\\AES\\Salida\\salida.txt"; 
   
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
    }//GEN-LAST:event_OutputActionPerformed

    private void JKEYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JKEYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JKEYActionPerformed

    private void EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptActionPerformed
        File documento=new File(getArchivo());
        FileReader f=null;
        try {
            f=new FileReader(documento);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader b = new BufferedReader(f);
        
        String cadena="";
        StringBuffer texto_s=new StringBuffer();
        try {
            while((cadena=b.readLine())!=null)
            {
                texto_s.append(cadena);
                texto_s.append("\r\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Encryption encriptador=new Encryption();
        
        try {
            escribirArchivo(encriptador.encrypt(this.JKEY.getText(),"0123456789ABCDEF",texto_s.toString()));
            JOptionPane.showMessageDialog(null,"You´ve encrypted your message successfully");
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_EncryptActionPerformed
    
    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed
         File documento=new File(getArchivo());
        FileReader f=null;
        try {
            f=new FileReader(documento);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader b = new BufferedReader(f);
        
        String cadena="";
        StringBuffer texto_s=new StringBuffer();
        try {
            while((cadena=b.readLine())!=null)
            {
                texto_s.append(cadena);
                texto_s.append("\r\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Encryption encriptador=new Encryption();
        
        try {
            escribirArchivo(encriptador.decrypt(this.JKEY.getText(),"0123456789ABCDEF",texto_s.toString()));
            JOptionPane.showMessageDialog(null,"You´ve decrypted your message successfully");
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_DecryptActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

      public void setArchivo(String file)
    {
        this.archivo=file;
    }
    
    public String getArchivo()
    {
        return this.archivo;
    }
    
    public void setLetra(StringBuilder letra)
    {
        this.letra=letra;
    }
    
    public StringBuilder getLetra()
    {
        return this.letra;
    }
    
    public void escribirArchivo(String letra) throws IOException
    {
        File out=new File("C:\\Users\\josue\\Documents\\Criptography\\AES\\Salida\\salida.txt");
        
        if(out.delete()){}
        
        File nuevo=new File("C:\\Users\\josue\\Documents\\Criptography\\AES\\Salida\\salida.txt");
        
        try (PrintWriter fw = new PrintWriter(nuevo,"utf-8")) {
            fw.println(letra);
            fw.close();
        }
       System.out.print(letra);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cryptography;
    private javax.swing.JButton Decrypt;
    private javax.swing.JButton Encrypt;
    private javax.swing.JButton Entry;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField JKEY;
    private javax.swing.JLabel Key;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton Output;
    private javax.swing.JButton Select;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabelAES;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFondo2;
    // End of variables declaration//GEN-END:variables
}
