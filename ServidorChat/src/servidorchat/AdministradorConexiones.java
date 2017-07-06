/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchat;

import java.util.ArrayList;

/**
 *
 * @author acer main
 */
public class AdministradorConexiones {
    
    private static AdministradorConexiones s1= new AdministradorConexiones();
    public static  AdministradorConexiones getInstance(){
        return s1;
    }
    
    private ArrayList<MsAdmin> conexiones = new ArrayList();
    
    public void enviarMsj(byte[] msj, int len){
        for(MsAdmin ms: conexiones){
            ms.enviarMsj(msj,len);
        }
        
    }
    public void ConectarNuevo(MsAdmin nuevo){
        conexiones.add(nuevo);
    }
    
    public AdministradorConexiones(){
        
    
    }
}
