package br.com.stefanini.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginUtil {

	public static String MD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }
}
