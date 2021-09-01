package com.ppjun.core

import de.robv.android.xposed.XposedHelpers


open class ClassMapper(private val loader: ClassLoader, private val name: String? = null) {
    val clazz: Class<*> by lazy {
        val clsName = name ?: javaClass.simpleName
        XposedHelpers.findClass(clsName, loader)
    }

    fun newInstance(): Any {
        return XposedHelpers.newInstance(clazz)
    }
}