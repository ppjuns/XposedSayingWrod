package com.ppjun.dio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * @author ppjun
 * @description
 * @date 2021-08-30 16:36
 */
public class Intercept {
    public static final String API_SALT = "123456ABCDEFGHIJKL{(&#!,.&*)}MNOPQRSTUVWXYZ789010000";

    private String sign(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            arrayList.add(str);
        }


        Collections.sort(arrayList, new Comparator<String>(){

            @Override
            public int compare(String obj, String obj2) {
                return ((String) obj).compareTo((String) obj2);
            }
        });
        for (int i = 0; i < arrayList.size(); i++) {
            String str2 = (String) arrayList.get(i);
            sb.append(String.format("%s=%s&", str2, map.get(str2)));
        }
        sb.append(API_SALT);
        return AuthCode.MD5(sb.toString());
    }
}
