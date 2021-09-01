package com.ppjun.core

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge

class ParentMethodMapper(val clazz: Class<*>, val methodName: String, vararg argsClasss: Class<*>) {
    private val method = JavaClass.findMethodBestMatch(clazz, methodName, argsClasss)

    fun setHook(hook: XC_MethodHook) {
        XposedBridge.hookMethod(method, hook)
    }

    fun call(obj: Any, vararg params: Any?): Any? {
        return method.invoke(obj, *params)
    }

}