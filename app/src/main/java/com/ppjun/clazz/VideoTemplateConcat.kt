package com.ppjun.clazz

import com.ppjun.core.ClassMapper
import com.ppjun.core.FieldMapper

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 12:50
 */
class VideoTemplateConcat(classLoader: ClassLoader) :
    ClassMapper(classLoader, "cn.nineton.sayingwrod.bean.video.VideoTemplateConcat") {
    val VideoTemplateItem by lazy {
        FieldMapper.ObjectFieldMapper(clazz, "item")
    }
}