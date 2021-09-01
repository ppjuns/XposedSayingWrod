package com.ppjun.clazz

import com.ppjun.core.ClassMapper
import com.ppjun.core.FieldMapper

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 15:48
 */
class AIFaceTemplateBean(classLoader: ClassLoader) :
    ClassMapper(classLoader, "cn.nineton.sayingwrod.bean.AIFaceTemplateBean") {

    val name by lazy { FieldMapper.ObjectFieldMapper(clazz, "name") }
    val thumbimage by lazy { FieldMapper.ObjectFieldMapper(clazz, "thumbimage") }
    val linkfile by lazy { FieldMapper.ObjectFieldMapper(clazz, "linkfile") }
}