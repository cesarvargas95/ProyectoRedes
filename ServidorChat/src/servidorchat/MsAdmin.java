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
    public void enviarMsj(String msj){
        try{
            dos.writeUTF(msj);
        }catch(Exception e){
        }
        
    }
    public void run(){
        while (true){
            try {
                String msj = dis.readUTF();
                AdministradorConexiones.getInstance().enviarMsj(msj);
            } catch (Exception e) {
            }
           
            
        }
        
    }
    

  
}
