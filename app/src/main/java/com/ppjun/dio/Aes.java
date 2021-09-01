package com.ppjun.dio;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
    public static String Encrypt(String str, String str2) throws Exception {
        if (str2 == null) {
            System.out.print("Key为空null");
            return null;
        } else if (str2.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            return bytesToHexString(instance.doFinal(str.getBytes("utf-8")));
        }
    }

    public static String Decrypt(String str, String str2) throws Exception {
        if (str2 == null) {
            try {
                System.out.print("Key为空null");
                return null;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } else if (str2.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            try {
                return new String(instance.doFinal(hexStringToByte(str)), "utf-8");
            } catch (Exception e2) {
                System.out.println(e2.toString());
                return null;
            }
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] hexStringToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (toByte(charArray[i2 + 1]) | (toByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    private static byte toByte(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }
}