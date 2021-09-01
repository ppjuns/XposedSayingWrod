package com.ppjun.core

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge


/**
 *  @author ppjun
 *  @date 2019/02/26.
 */
class AllMethodMapper(val clazz: Class<*>, val methodName: String) {

    fun setHook(hook: XC_MethodHook) {
        XposedBridge.hookAllMethods(clazz,methodName,hook)
    }

}