package com.ppjun.dio;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

public class AuthCode {

    public enum DiscuzAuthcodeMode {
        Encode,
        Decode
    }

    public static String CutString(String str, int i, int i2) {
        int i3 = 0;
        if (i >= 0) {
            if (i2 < 0) {
                i2 *= -1;
                int i4 = i - i2;
                if (i4 < 0) {
                    i2 = i;
                } else {
                    i3 = i4;
                }
            } else {
                i3 = i;
            }
            if (i3 > str.length()) {
                return "";
            }
        } else if (i2 < 0 || (i2 = i2 + i) <= 0) {
            return "";
        }
        if (str.length() - i3 < i2) {
            i2 = str.length() - i3;
        }
        return str.substring(i3, i2 + i3);
    }

    public static String CutString(String str, int i) {
        return CutString(str, i, str.length());
    }

    private static byte[] GetKey(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = ((i3 + ((bArr2[i4] + 256) % 256)) + bArr[i4 % bArr.length]) % i;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
        }
        return bArr2;
    }

    public static String RandomString(int i) {
        char[] cArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int length = cArr.length;
        String str = "";
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            str = str + cArr[Math.abs(random.nextInt(length))];
        }
        return str;
    }

    public static String RandomNumber(int i) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int length = cArr.length;
        String str = "";
        Random random = new Random();
        int i2 = 0;
        while (i2 < i) {
            int abs = Math.abs(random.nextInt(length));
            if (i2 == 0 && abs == 0) {
                i2--;
            } else {
                str = str + cArr[Math.abs(random.nextInt(length))];
            }
            i2++;
        }
        return str;
    }
//
//    public static String authcodeEncode(String str, String str2, int i, String str3) {
//        return authcode(str, str2, DiscuzAuthcodeMode.Encode, i, str3);
//    }
//
//    public static String authcodeEncode(String str, String str2, String str3) {
//        return authcode(str, str2, DiscuzAuthcodeMode.Encode, 0, str3);
//    }
//
//    public static String authcodeDecode(String str, String str2, String str3) {
//        return authcode(str, str2, DiscuzAuthcodeMode.Decode, 0, str3);
//    }
//
//    private static String authcode(String str, String str2, DiscuzAuthcodeMode discuzAuthcodeMode, int i, String str3) {
//        String str4;
//        String str5;
//        if (str == null || str2 == null) {
//            return "";
//        }
//        boolean z = false;
//        try {
//            String MD52 = MD52(CutString(str2, 0, 16));
//            String MD522 = MD52(CutString(str2, 16, 16));
//            if (discuzAuthcodeMode == DiscuzAuthcodeMode.Decode) {
//                str4 = CutString(str, 0, 4);
//            } else {
//                str4 = RandomString(4);
//            }
//            StringBuilder sb = new StringBuilder();
//            sb.append(MD52);
//            sb.append(MD52(MD52 + str4));
//            String sb2 = sb.toString();
//            if (discuzAuthcodeMode == DiscuzAuthcodeMode.Decode) {
//                String str6 = new String(RC4(Base64.decode(CutString(str, 4)), sb2), str3);
//                String CutString = CutString(str6, 10, 16);
//                boolean equals = CutString.equals(CutString(MD52(CutString(str6, 26) + MD522), 0, 16));
//                if (Integer.parseInt(CutString(str6, 0, 10)) == 0 || ((long) Integer.parseInt(CutString(str6, 0, 10))) - getUnixTimestamp() > 0) {
//                    z = true;
//                }
//                return (!equals || !z) ? "" : CutString(str6, 26);
//            }
//            if (i == 0) {
//                StringBuilder sb3 = new StringBuilder();
//                sb3.append("0000000000");
//                sb3.append(CutString(MD52(str + MD522), 0, 16));
//                sb3.append(str);
//                str5 = sb3.toString();
//            } else {
//                StringBuilder sb4 = new StringBuilder();
//                sb4.append(getUnixTimestamp() + ((long) i));
//                sb4.append(CutString(MD52(str + MD522), 0, 16));
//                sb4.append(str);
//                str5 = sb4.toString();
//            }
//            byte[] RC4 = RC4(str5.getBytes(str3), sb2);
//            return str4 + Base64.encodeBytes(RC4);
//        } catch (Exception unused) {
//            return "";
//        }
//    }

    private static byte[] RC4(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        byte[] GetKey = GetKey(str.getBytes(), 256);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % GetKey.length;
            i2 = (i2 + ((GetKey[i] + 256) % 256)) % GetKey.length;
            byte b = GetKey[i];
            GetKey[i] = GetKey[i2];
            GetKey[i2] = b;
            bArr2[i3] = (byte) (bArr[i3] ^ toInt(GetKey[(toInt(GetKey[i]) + toInt(GetKey[i2])) % GetKey.length]));
        }
        return bArr2;
    }

    public static String MD52(String str) {
        byte[] digest;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8")))) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return stringBuffer.toString();
    }

    public static String MD5(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int toInt(byte b) {
        return (b + 256) % 256;
    }

    public static long getUnixTimestamp() {
        return Calendar.getInstance().getTimeInMillis() / 1000;
    }

//    public static void main(String[] strArr) {
//        String authcodeEncode = authcodeEncode("/asdfas/asdf.html", "czgjj", 30, "UTF-8");
//        String authcodeDecode = authcodeDecode(authcodeEncode, "czgjj", "UTF-8");
//        PrintStream printStream = System.out;
//        printStream.println("--------encode:" + authcodeEncode);
//        PrintStream printStream2 = System.out;
//        printStream2.println("--------decode:" + authcodeDecode);
//        PrintStream printStream3 = System.out;
//        printStream3.println("MD52--------:" + MD52("vhjrQrYlTDTGwytOgGRvr0BY9uQ78GoK{\"code\":\"0013\"}vhjrQrYlTDTGwytOgGRvr0BY9uQ78GoK"));
//    }
}