/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Principal extends javax.swing.JFrame {

    Archivo imagen;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        imagen = new Archivo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre = new javax.swing.JLabel();
        Seleccion = new javax.swing.JButton();
        key_t = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        Encrypt = new javax.swing.JButton();
        Decrypt = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Entry = new javax.swing.JButton();
        Output = new javax.swing.JButton();
        Bloques = new javax.swing.JComboBox();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Josue Ruiz Hernandez");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Seleccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Seleccion.setForeground(new java.awt.Color(255, 255, 255));
        Seleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton2.jpg"))); // NOI18N
        Seleccion.setText("Select file");
        Seleccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Seleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionActionPerformed(evt);
            }
        });
        getContentPane().add(Seleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 190, 50));

        key_t.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        key_t.setForeground(new java.awt.Color(255, 255, 255));
        key_t.setText("Key");
        getContentPane().add(key_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 50, -1));
        getContentPane().add(key, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 150, 30));

        Encrypt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Encrypt.setForeground(new java.awt.Color(255, 255, 255));
        Encrypt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton2.jpg"))); // NOI18N
        Encrypt.setText("Encrypt");
        Encrypt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptActionPerformed(evt);
            }
        });
        getContentPane().add(Encrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 190, 50));

        Decrypt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Decrypt.setForeground(new java.awt.Color(255, 255, 255));
        Decrypt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton2.jpg"))); // NOI18N
        Decrypt.setText("Decypt");
        Decrypt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptActionPerformed(evt);
            }
        });
        getContentPane().add(Decrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 190, 50));

        Exit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton2.jpg"))); // NOI18N
        Exit.setText("Exit");
        Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 190, 50));

        Entry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Entry.setForeground(new java.awt.Color(255, 255, 255));
        Entry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton2.jpg"))); // NOI18N
        Entry.setText("See input");
        Entry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntryActionPerformed(evt);
            }
        });
        getContentPane().add(Entry, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 190, 50));

        Output.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Output.setForeground(new java.awt.Color(255, 255, 255));
        Output.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton2.jpg"))); // NOI18N
        Output.setText("See output");
        Output.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });
        getContentPane().add(Output, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 190, 50));

        Bloques.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Bloques.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Electronic Codeblock", "Cipher Block Channing", "Cipher Feed Back", "Output Feed Back" }));
        Bloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloquesActionPerformed(evt);
            }
        });
        getContentPane().add(Bloques, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 170, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        imagen.mostrarSalida();
    }//GEN-LAST:event_OutputActionPerformed

    private void EntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntryActionPerformed
        imagen.mostrarEntrada();
    }//GEN-LAST:event_EntryActionPerformed

    private void SeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionActionPerformed
        JFileChooser file = new JFileChooser();
        
        int opcion=file.showOpenDialog(this);
        
        if(opcion==JFileChooser.APPROVE_OPTION)
        {
            String nombre=file.getSelectedFile().getPath();
            
            String ruta=file.getSelectedFile().toString();
            
            JOptionPane.showMessageDialog(null,"File successfully loaded");
            
            imagen.setRuta(ruta);
        }
    }//GEN-LAST:event_SeleccionActionPerformed

    private void EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptActionPerformed
        switch(get_Bloque_T())
        {
            case "Electronic Codeblock":
                String ruta=imagen.getRuta();
                Imagen imagen_ = new Imagen(ruta);
                BufferedImage buffer=null;
                try {
                    buffer = imagen_.addImage();
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            try {
                imagen_.crearImagenCifrada(buffer,1);
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                break;
                
            case "Cipher Block Channing":
                JOptionPane.showMessageDialog(null,"CBC");
                break;
                
            case "Cipher Feed Back":
                JOptionPane.showMessageDialog(null,"CFB");
                break;
                
            case "Output Feed Back":
                JOptionPane.showMessageDialog(null,"OFB");
                break;
        }
    }//GEN-LAST:event_EncryptActionPerformed

    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed
         switch(get_Bloque_T())
        {
            case "Electronic Codeblock":
                String ruta=imagen.getRuta();
                Imagen imagen_ = new Imagen(ruta);
                BufferedImage buffer=null;
                try {
                    buffer = imagen_.addImage();
                   } catch (IOException ex) {
                       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                   }

                try {
                   imagen_.crearImagenDecifrada(buffer,1);
                } catch (Exception ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "Cipher Block Channing":
                JOptionPane.showMessageDialog(null,"CBC");
                break;
                
            case "Cipher Feed Back":
                JOptionPane.showMessageDialog(null,"CFB");
                break;
                
            case "Output Feed Back":
                JOptionPane.showMessageDialog(null,"OFB");
                break;
        }
    }//GEN-LAST:event_DecryptActionPerformed

    private void BloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloquesActionPerformed
        
    }//GEN-LAST:event_BloquesActionPerformed

    private String get_Bloque_T()
    {
        String bloque;
        
        bloque = this.Bloques.getSelectedItem().toString();
        
        return bloque;
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Bloques;
    private javax.swing.JButton Decrypt;
    private javax.swing.JButton Encrypt;
    private javax.swing.JButton Entry;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton Output;
    private javax.swing.JButton Seleccion;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField key;
    private javax.swing.JLabel key_t;
    // End of variables declaration//GEN-END:variables
}
