package com.ppjun.core

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge

class ConstructorMapper(val clazz: Class<*>, vararg argsClasss: Class<*>) {
    private val method = JavaClass.findConstructorExact(clazz, argsClasss)

    fun setHook(hook: XC_MethodHook) {
        XposedBridge.hookMethod(method, hook)
    }

    fun newInstance(vararg params: Any?): Any {
        return method.newInstance(*params)
    }
}