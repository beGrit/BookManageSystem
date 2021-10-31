package org.pocky.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static String MD5(String s) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) {
        String rtn = MD5Util.MD5("123456");
        System.out.printf(rtn);
    }
}
