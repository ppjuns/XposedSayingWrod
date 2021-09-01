package com.ppjun.dio

import android.os.Environment
import android.os.Handler
import android.util.Log
import com.ppjun.Constants
import com.ppjun.clazz.CnClazz
import com.ppjun.hook.AIFaceHook
import com.ppjun.hook.FetchVideoTypeHook
import dalvik.system.DexClassLoader
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import java.io.File

/**
 * @description
 * @author ppjun
 * @date 2021-08-27 17:29
 */
class KeyHookLogic : IXposedHookLoadPackage {
    val TAG = "KeyHookLogic"
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam == null) {
            return
        }
        if (lpparam.packageName.equals(Constants.PACKAGE_NAME)) {
            onHotLoad(lpparam)
        }
    }

    fun handlePackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        Thread.setDefaultUncaughtExceptionHandler { t, e -> Log.e(t.name, "发生异常") }
        if (lpparam.packageName.equals(Constants.PACKAGE_NAME)) {
            val classLoader = lpparam.classLoader
            CnClazz.classLoader = classLoader
            Handler().postDelayed({
                FetchVideoTypeHook()
                AIFaceHook()
            }, 5000)
        }
    }

    fun onHotLoad(lpp: XC_LoadPackage.LoadPackageParam) {
        var aClass: Class<*>? = null
        val packageName = javaClass.`package`.name
        try {
            val apk = File(Environment.getExternalStorageDirectory(), "$packageName.apk")
            if (!apk.isFile) {
                XposedBridge.log("${apk.path} not exists, exit hook")
                return
            }
            val optimizedDirectory = File(lpp.appInfo.dataDir, "cache").absolutePath
            Log.d(TAG, lpp.processName + " optimizedDirectory = " + optimizedDirectory)
            val pathClassLoader =
                DexClassLoader(
                    apk.absolutePath,
                    optimizedDirectory,
                    null,
                    KeyHookLogic::class.java.classLoader.parent
                )
            aClass = pathClassLoader.loadClass(KeyHookLogic::class.java.name)
        } catch (e: Exception) {
            XposedBridge.log("Exception:" + e.message)
            XposedBridge.log(e)
            handlePackage(lpp)
            return
        }

        val aClassMethod =
            aClass?.getMethod("handlePackage", XC_LoadPackage.LoadPackageParam::class.java)
        aClassMethod?.invoke(aClass?.newInstance(), lpp)
        Log.d(TAG, "load package ok +_+_+_+_+_+_+_+_+_+_+")
    }
}