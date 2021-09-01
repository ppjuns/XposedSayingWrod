package com.ppjun.clazz

import com.ppjun.core.ClassMapper
import com.ppjun.core.MethodMapper

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 15:39
 */
class AIFaceTemplatePresenter(classLoader: ClassLoader) :
    ClassMapper(classLoader, "cn.nineton.sayingwrod.mvp.presenter.AIFaceTemplatePresenter") {

    val getAiFaceTemplateList by lazy {
        MethodMapper(clazz, "lambda${'$'}getAiTemplate${'$'}1", clazz, List::class.java)
    }

}