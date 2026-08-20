package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ToSHA1 {
    public static String SHA1(String contentToConvert) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(contentToConvert.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 40) {
                hashtext = "0" + hashtext;
            }
            System.out.println("called");
            return hashtext;
        }

        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
