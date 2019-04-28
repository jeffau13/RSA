
/**
 * author: Jeffrey Au (Undergrad Student) CSC 4222
 */

import java.util.Random;
import java.math.BigInteger;

public class cau1A6 {

    public static void main(String[] args) {
        // keyGeneration:
        BigInteger p;
        BigInteger q;
        BigInteger n;
        BigInteger phi;
        BigInteger e;
        BigInteger d;
        int bitLen = 512;
        Random r;
        r = new Random();
        // p = prime 1
        p = BigInteger.probablePrime(bitLen, r);
        // q = prime 2
        q = BigInteger.probablePrime(bitLen, r);
        // n = p * q
        n = p.multiply(q);
        // phi = totient(n) = (prime1-1)*(prime2-1)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitLen / 2, r);

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(phi);

        String plain = "This is the last assignment";

        System.out.println("Plaintext string to encrypt: " + plain);
        System.out.println("------------------------------------");
        System.out.println("Public Key e: " + e);
        System.out.println("------------------------------------");
        System.out.println("n: " + n);
        System.out.println("------------------------------------");

        byte[] encrypted = encryption(e, n, plain);

        System.out.println("Encrypted ciphertext: " + byteArrayToString(encrypted));
        System.out.println("------------------------------------");
        System.out.println("Private Key d: " + d);
        System.out.println("------------------------------------");

        String decrypted = decryption(d, n, encrypted);

        System.out.println("Decrypted plaintext string :" + decrypted);

    }

    // @params: public key pair (e,n) and plaintext in String form
    // returns an encrypted byte array
    public static byte[] encryption(BigInteger e, BigInteger n, String plaintext) {
        byte[] encrypted = (new BigInteger(plaintext.getBytes())).modPow(e, n).toByteArray();
        return encrypted;
    }

    // @params: private key pair (d,n) and cyphertext in byte array
    // returns decrypted String
    public static String decryption(BigInteger d, BigInteger n, byte[] ciphertext) {
        byte[] plaintext = (new BigInteger(ciphertext)).modPow(d, n).toByteArray();
        return new String(plaintext);
    }

    // @params: byte[]
    // returns String of the byte[]
    public static String byteArrayToString(byte[] bytes) {
        String str = "";
        for (byte b : bytes) {
            str += Byte.toString(b);
        }
        return str;
    }

}
