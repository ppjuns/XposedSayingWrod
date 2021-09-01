package com.ppjun.core;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import de.robv.android.xposed.XposedHelpers;

public class JavaClass {
    public static final Class intClass = int.class;
    public static final Class floatClass = float.class;
    public static final Class longClass = long.class;
    public static final Class booleanClass = boolean.class;
    public static final Class byteArrayClass = byte[].class;

    public static Method findMethodExact(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
        return XposedHelpers.findMethodExact(clazz, methodName, parameterTypes);
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
        return XposedHelpers.findMethodBestMatch(clazz, methodName, parameterTypes);
    }

    public static Constructor<?> findConstructorExact(Class<?> clazz, Class<?>[] parameterTypes) {
        return XposedHelpers.findConstructorExact(clazz, parameterTypes);
    }
}
