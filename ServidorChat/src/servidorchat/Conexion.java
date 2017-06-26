/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchat;
/**
 *
 * @author acer main
 */


import java.awt.Component;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

public class Conexion extends Thread{
   ServerSocket ss;
    Component c; 
    Semaphore guardia;
    Boolean a;// si el puerto esta abierto esta en true
   public Conexion(Component c){
       this.c= c;
       a= false;
       guardia = new Semaphore(1, true);
   }
   public void abrirPuerto(){
       ss=null;
       if(!a){
        try{
            guardia.acquire();
            a= true;
            ss = new ServerSocket(6000);
            guardia.release();
            while(true){
                 Socket s= ss.accept();
                 System.out.println("Conectado");
                 AdministradorConexiones.getInstance().ConectarNuevo(new MsAdmin(s));
            }
        }catch(Exception e){
            //JOptionPane.showMessageDialog(c, "Error al abrir el servidor");
        }
        
       }else{
          // JOptionPane.showMessageDialog(c, "El servidor esta escuchando");
       }
    }
   public void cerrarPuerto(){
        try{
            guardia.acquire();
            a=false;
            ss.close();
            JOptionPane.showMessageDialog(c,"El servidor no esta escuchando");
        }catch(Exception e){
            JOptionPane.showMessageDialog(c, "Error al cerrar el servidor");
        } 
        guardia.release();
       
   }
 
   public void run(){
        abrirPuerto();
           
          
   }
  
   
}
