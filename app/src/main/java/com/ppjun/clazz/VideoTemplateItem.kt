package com.ppjun.clazz

import com.ppjun.core.ClassMapper
import com.ppjun.core.FieldMapper

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 13:32
 */
class VideoTemplateItem(classLoader: ClassLoader): ClassMapper(classLoader,"cn.nineton.sayingwrod.bean.video.VideoTemplateItem") {

    val title by lazy {
        FieldMapper.ObjectFieldMapper(clazz,"title")
    }

    val thumb by lazy {
        FieldMapper.ObjectFieldMapper(clazz,"thumb")
    }
    val link by lazy {
        FieldMapper.ObjectFieldMapper(clazz,"link")
    }
}