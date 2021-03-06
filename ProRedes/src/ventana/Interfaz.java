/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import java.awt.Image;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author acer main
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    Socket s;
    EnviarMsj em;
    String entradatext;
    //Cifrado cifrado;
    Boolean pKey = false;
    PublicKey publicKey;
    PrivateKey privateKey;
    RSA rsa;
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon image= new ImageIcon(getClass().getResource("/imag/dota.jpg"));
        ImageIcon icono = new ImageIcon(image.getImage().getScaledInstance(477,426,Image.SCALE_DEFAULT));
        never.setIcon(icono);
        entradatext= entrada.getText();
        rsa= new RSA(new BigInteger("13086071780231689389281582130505724206171493340370421401756073105563342532676514221535928493686214327650784635425662439549468739263898434994166247814495971"),
                    new BigInteger("6975307335673450650551260136096376813678535418880548403912435920585367249561754214501082289221804523325965926732889759519672082983951923010853558243235290409492775815309070079274042003680465449971851435955876127219540183904365338202255068607445000410662908458840816895422873819771766412103424264208689914578464154108404338263159487768488609339116507484736839312411322316413382394212172420287166895311718206453682088184894124108675997148165652970885277381530462636382688750732759733946359921104232202847641955581088438796843672078299937807247224079470675465553599847642906687793770872004418999749675084223402412560619"),
                            new BigInteger("18065789795781398642379227077624043218450889348509554652295707693652109235579503483252061241830894398594106674952693589953285988275009936032277180043875634048612263430916840939465314844726045904207175536273782239728071513689165460343815318291545984462141091746074434125647941945002164393538026028939500551981902388688946831735054253690748490387138282100068302214236890876046962316120072816906062370907868914786249863757294738556802578062275655654548189955227799296771662355676422199280336042493477325777802050392880297987169330236547832163755427847159051245548482812759732226374072375020159981560177488610382913605003"));
        //rsa= new RSA();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        entrada = new javax.swing.JTextField();
        puertoEntrada = new javax.swing.JTextField();
        NombreEntrada = new javax.swing.JTextField();
        IpEntrada = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        puertoText = new javax.swing.JLabel();
        ipText = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        desconectarBot = new javax.swing.JButton();
        conectarBot = new javax.swing.JButton();
        never = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setHorizontalScrollBar(null);

        chat.setEditable(false);
        chat.setColumns(10);
        chat.setLineWrap(true);
        chat.setRows(5);
        chat.setToolTipText("");
        chat.setWrapStyleWord(true);
        chat.setAutoscrolls(false);
        jScrollPane1.setViewportView(chat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 330, 180));

        entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaActionPerformed(evt);
            }
        });
        entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entradaKeyPressed(evt);
            }
        });
        getContentPane().add(entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 330, 30));

        puertoEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        puertoEntrada.setText("6000");
        getContentPane().add(puertoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, -1));

        NombreEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NombreEntrada.setText("User1");
        NombreEntrada.setToolTipText("");
        NombreEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(NombreEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 110, -1));

        IpEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IpEntrada.setText("localhost");
        IpEntrada.setToolTipText("");
        IpEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IpEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(IpEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 110, -1));

        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("Nombre");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        puertoText.setForeground(new java.awt.Color(255, 255, 255));
        puertoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puertoText.setText("Puerto");
        getContentPane().add(puertoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 20));

        ipText.setForeground(new java.awt.Color(255, 255, 255));
        ipText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipText.setText("IP");
        getContentPane().add(ipText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 50, 20));

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        getContentPane().add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 70, 30));

        desconectarBot.setText("Desconectar");
        desconectarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectarBotActionPerformed(evt);
            }
        });
        getContentPane().add(desconectarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 100, -1));

        conectarBot.setText("Conectar");
        conectarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarBotActionPerformed(evt);
            }
        });
        getContentPane().add(conectarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 100, -1));

        never.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/dota.jpg"))); // NOI18N
        never.setMaximumSize(new java.awt.Dimension(850, 600));
        never.setMinimumSize(new java.awt.Dimension(850, 600));
        never.setPreferredSize(new java.awt.Dimension(850, 600));
        getContentPane().add(never, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaActionPerformed

    private void entradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entradaKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==10){
            //System.out.println(entrada.getText());
            if(entrada.getText()!=entradatext){
            String s= NombreEntrada.getText()+": "+entrada.getText();
            System.out.println(s);
            System.out.println("String in Bytes: "+ rsa.bytesToString(s.getBytes()));
            byte[] encrypted = rsa.encrypt(s.getBytes());
            
            //String s2= new String(encrypted);
            
            //byte[] decrypted = rsa.decrypt(s2.getBytes());
           // String str = new String(rsa.encrypt(s.getBytes()));
           // System.out.println("Decrypting Bytes: " + rsa.bytesToString(decrypted));
           // System.out.println("Decrypted String: " + new String(decrypted)); 
            
            em.enviarMsj(encrypted);
            entrada.setText(entradatext);
            }
        }
        
        
       // System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_entradaKeyPressed

    private void conectarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarBotActionPerformed
        // TODO add your handling code here:
        em=null;
        if(em==null){
           // if(cifrado == null)
            //{
           //     cifrado = new Cifrado();
            //}
            em= new EnviarMsj(IpEntrada.getText(), Integer.parseInt(puertoEntrada.getText()),this);
            em.start();   
        }
        
    }//GEN-LAST:event_conectarBotActionPerformed

    private void IpEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IpEntradaActionPerformed
   
    }//GEN-LAST:event_IpEntradaActionPerformed

    private void NombreEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreEntradaActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        String s= NombreEntrada.getText()+": "+entrada.getText();
            System.out.println(s);
            System.out.println("String in Bytes: "+ rsa.bytesToString(s.getBytes()));
            byte[] encrypted = rsa.encrypt(s.getBytes());
            
            //String s2= new String(encrypted);
            
            //byte[] decrypted = rsa.decrypt(s2.getBytes());
           // String str = new String(rsa.encrypt(s.getBytes()));
           // System.out.println("Decrypting Bytes: " + rsa.bytesToString(decrypted));
           // System.out.println("Decrypted String: " + new String(decrypted)); 
            
            em.enviarMsj(encrypted);
            entrada.setText(entradatext);
    }//GEN-LAST:event_enviarActionPerformed

    private void desconectarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectarBotActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_desconectarBotActionPerformed

    
    public void recibirMsj(byte[] msj){
        //String aux = cifrado.Descifrar(msj);
        //chat.append(aux+ "\n");
        
        chat.append(new String(msj)+ "\n");
        // decrypt
        byte[] decrypted = rsa.decrypt(msj);
        String s1 =  new String(decrypted);
        System.out.println("Decrypted String: " +s1);
        //msj = new String(decrypted, StandardCharsets.UTF_8);
        chat.append(s1+ "\n");
    }
    
    public void recibirKey(PublicKey llavePublica){
        this.publicKey = llavePublica;
        pKey = true;
        JOptionPane.showMessageDialog(null, "Recibi llave");
        
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IpEntrada;
    private javax.swing.JTextField NombreEntrada;
    private javax.swing.JTextArea chat;
    private javax.swing.JButton conectarBot;
    private javax.swing.JButton desconectarBot;
    private javax.swing.JTextField entrada;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel ipText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel never;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField puertoEntrada;
    private javax.swing.JLabel puertoText;
    // End of variables declaration//GEN-END:variables
}
