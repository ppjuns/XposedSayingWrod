package com.ppjun.dio;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtils {
    private static final String CipherMode = "AES/CBC/PKCS5Padding";
    private static String iv = "-9TonAds20180713";
    private static String key_ = "9TonAds20180713-";
    public static final byte error = -1;
    public static final String AUDIO_STR_DEFAULT = "0";
    public static final String DEFAULT_CHARSET = "UTF-8";

    private static SecretKeySpec createKey(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append(AUDIO_STR_DEFAULT);
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    private static IvParameterSpec createIV(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append(AUDIO_STR_DEFAULT);
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new IvParameterSpec(bArr);
    }

    public static byte[] encrypt(byte[] bArr) {
        try {
            SecretKeySpec createKey = createKey(key_);
            Cipher instance = Cipher.getInstance(CipherMode);
            instance.init(1, createKey, createIV(iv));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes(DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        return byte2hex(encrypt(bArr));
    }

    public static byte[] decrypt(byte[] bArr) {
        try {
            SecretKeySpec createKey = createKey(key_);
            Cipher instance = Cipher.getInstance(CipherMode);
            instance.init(2, createKey, createIV(iv));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String str) {
        byte[] bArr;
        try {
            bArr = hex2byte(str);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        byte[] decrypt = decrypt(bArr);
        if (decrypt == null) {
            return null;
        }
        try {
            return new String(decrypt, DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & error);
            if (hexString.length() == 1) {
                stringBuffer.append(AUDIO_STR_DEFAULT);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    private static byte[] hex2byte(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }
}