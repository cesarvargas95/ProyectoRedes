/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *http://www.sanfoundry.com/java-program-implement-rsa-algorithm/ recuperado
 */
package ventana;

/**
 *
 * @author acer main
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
 
public class RSA
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int        bitlength = 1024;
    private Random     r;
 
    public RSA()
    {
       // r = new Random();
       // p = new BigInteger("5");
       // q = new BigInteger("7");
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
       
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
        
       // System.out.println(e.toString());
        //System.out.println(d.toString());
        //System.out.println(N.toString());
        //e = new BigInteger("5");
        //d = new BigInteger("29");
       // N = new BigInteger("35");
    }
 
    public RSA(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
 
 
    public static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
 
    // Encrypt message
    public byte[] encrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
 
    // Decrypt message
    public byte[] decrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}