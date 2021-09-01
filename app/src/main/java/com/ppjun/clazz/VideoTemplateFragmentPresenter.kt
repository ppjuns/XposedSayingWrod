package com.ppjun.clazz

import com.ppjun.core.ClassMapper
import com.ppjun.core.MethodMapper

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 14:15
 */
class VideoTemplateFragmentPresenter(classLoader: ClassLoader) :
    ClassMapper(classLoader, "cn.nineton.sayingwrod.mvp.presenter.VideoTemplateFragmentPresenter") {

    val fetchVideoType = MethodMapper(clazz, "lambda${'$'}fetchVideoType${'$'}3", clazz, List::class.java)
}