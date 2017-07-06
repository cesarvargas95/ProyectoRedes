/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchat;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer main
 */
public class MsAdmin extends Thread {

    
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public MsAdmin(Socket s1){
       try{
        this.s=s1;
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());
        this.start();
       }catch(Exception e){
       }
    }
    public void enviarMsj(byte[] msj,int len){
        try{
            dos.writeInt(len);
            dos.write(msj,0,len);
        }catch(Exception e){
            System.out.println("error en enviar de msAd");
        }
        
    }
    public void run(){
        while (true){
            try {
                int len =dis.readInt();
                byte[] msj = new byte[len];
                dis.readFully(msj,0,len);
                System.out.println("estoy en enviar MSadm: " + new String(msj));
                AdministradorConexiones.getInstance().enviarMsj(msj,len);
            } catch (Exception e) {
            }
           System.out.println("estoy en env");
            
        }
        
    }
    

  
}
