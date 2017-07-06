package ventana;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import javax.crypto.Cipher;
import javax.swing.JOptionPane;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Cifrado {
    private KeyPairGenerator keyGen;
    private KeyPair clavesRSA;
    private PrivateKey clavePrivada;
    public PublicKey clavePublica;
    private Cipher cifrador;
    private byte[] bufferCifrado;
    
    public Cifrado(){
        try{
            Security.addProvider(new BouncyCastleProvider());
            keyGen = KeyPairGenerator.getInstance("RSA", "BC");
            keyGen.initialize(512); //tamano de clave
            clavesRSA = keyGen.generateKeyPair();
            clavePrivada = clavesRSA.getPrivate();
            clavePublica = clavesRSA.getPublic();
            cifrador = Cipher.getInstance("RSA", "BC");
            
        }catch(Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "No se pudo crear llaves");
        }
    }
    
    public String Cifrar (String msj, PublicKey clavePublica){
        try{
            cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
            bufferCifrado = cifrador.doFinal(msj.getBytes());
            return new String(bufferCifrado, 0, bufferCifrado.length);
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "No se pudo cifrar");
            return null;
        }
    }
    
    public String Descifrar (String msj){
        try{
            cifrador.init(Cipher.DECRYPT_MODE, clavePublica);
            byte[] buffer2 = cifrador.doFinal(bufferCifrado);
            return new String(buffer2, 0, buffer2.length);
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "No se pudo cifrar");
            return null;
        }
    }
}