package com.ppjun.core

import android.util.Log
import de.robv.android.xposed.XposedHelpers


sealed class FieldMapper(clazz: Class<*>, name: String) {
    protected val field = XposedHelpers.findField(clazz, name)
    val TAG = "FieldMapper"

    class ObjectFieldMapper(clazz: Class<*>, name: String) : FieldMapper(clazz, name) {
        fun get(obj: Any?): Any? {
            if (obj == null) {
               Log.d(TAG,"get object field obj == null")
                return null
            }
            return try {
                field.get(obj)
            } catch (e: Exception) {
                Log.e(TAG,"get object field error", e)
                throw e
            }
        }

        fun set(obj: Any, value: Any?) {
            try {
                field.set(obj, value)
            } catch (e: Exception) {
                Log.e(TAG,"set object field error", e)
                throw e
            }
        }
    }

    class BoolFieldMapper(clazz: Class<*>, name: String) : FieldMapper(clazz, name) {
        fun get(obj: Any?): Boolean {
            if (obj == null) {
                Log.d(TAG,"get boolean field obj == null")
                return false
            }
            return try {
                field.getBoolean(obj)
            } catch (e: Exception) {
                Log.e(TAG,"get boolean field error", e)
                throw e
            }
        }

        fun set(obj: Any, value: Boolean) {
            try {
                field.setBoolean(obj, value)
            } catch (e: Exception) {
                Log.e(TAG,"set boolean field error", e)
                throw e
            }
        }
    }

    class LongFieldMapper(clazz: Class<*>, name: String) : FieldMapper(clazz, name) {
        fun get(obj: Any?): Long {
            if (obj == null) {
                Log.d(TAG,"get boolean field obj == null")
                return 0
            }
            return try {
                field.getLong(obj)
            } catch (e: Exception) {
                Log.e(TAG,"get boolean field error", e)
                throw e
            }
        }

        fun set(obj: Any, value: Long) {
            try {
                field.setLong(obj, value)
            } catch (e: Exception) {
                Log.e(TAG,"set boolean field error", e)
                throw e
            }
        }
    }

    class IntFieldMapper(clazz: Class<*>, name: String) : FieldMapper(clazz, name) {
        fun get(obj: Any?): Int {
            if (obj == null) {
                Log.d(TAG,"get boolean field obj == null")
                return 0
            }
            return try {
                field.getInt(obj)
            } catch (e: Exception) {
                Log.e(TAG,"get boolean field error", e)
                throw e
            }
        }

        fun set(obj: Any, value: Int) {
            try {
                field.setInt(obj, value)
            } catch (e: Exception) {
                Log.e(TAG,"set boolean field error", e)
                throw e
            }
        }
    }


    class StaticObjectFieldMapper(clazz: Class<*>, name: String) : FieldMapper(clazz, name) {
        fun get(): Any? {
            return try {
                field.get(null)
            } catch (e: Exception) {
                Log.e(TAG,"get static object field error", e)
                throw e
            }
        }

        fun set(value: Any?) {
            try {
                field.set(null, value)
            } catch (e: Exception) {
                Log.e(TAG,"set static object field error", e)
                throw e
            }
        }
    }
}