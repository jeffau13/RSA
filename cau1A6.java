
/**
 * author: Jeffrey Au (Undergrad Student) CSC 4222
 */

import java.util.Random;
import java.math.BigInteger;

public class cau1A6 {

    public static void main(String[] args) {

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

    public class keyGeneration {

    }
}