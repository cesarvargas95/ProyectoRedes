/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PublicKey;
import javax.swing.JOptionPane;


/**
 *
 * @author acer main
 */
public class EnviarMsj extends Thread{

    private String ip;
    private int puerto;
    private Socket s;
    
    
    Interfaz ventana;
    public EnviarMsj(String ip, int puerto,Interfaz ventana ) {
        this.ip= ip;
        this.puerto= puerto;
        this.ventana= ventana;
        
    }

    
    public void enviarMsj(String msj){
    
        try{
            DataOutputStream d = new DataOutputStream(s.getOutputStream());
            String aux = ventana.cifrado.Cifrar(msj, ventana.publicKey);
            d.writeUTF(aux);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se puedo enviar el msj");
        } 
    }
    
    public void enviarLlave(PublicKey llavePublica){
        try{
        ObjectOutputStream d = new ObjectOutputStream (s.getOutputStream());
        d.writeObject(llavePublica);
        d.flush();
        } catch (Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(ventana, "No se puedo enviar la llave");
        }
    }

    public void run() {
        try{
            s= new Socket(ip, puerto);
            System.out.println("conectado");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            ObjectInputStream pK = new ObjectInputStream(s.getInputStream());
            while(true){
                String msj = dis.readUTF();
                Object obj = pK.readObject();
                PublicKey otherPublicKey = (PublicKey) obj;
                ventana.recibirKey(otherPublicKey);
                ventana.recibirMsj(msj);
                
            }
        }catch(Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(ventana, "Error al conectar");
        } 
    } 
}
