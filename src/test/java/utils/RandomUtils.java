package utils;

import java.security.SecureRandom;

public class RandomUtils {
    public static void main(String[] args){
        System.out.println(getRandomString(10));
    }

    public static String getRandomString(int lenght) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lenght);
        for(int i = 0; i < lenght; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            return sb.toString();
    }
}
