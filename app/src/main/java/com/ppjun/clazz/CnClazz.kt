package com.ppjun.clazz

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 13:26
 */
object CnClazz {
    lateinit var classLoader: ClassLoader
    val VideoTemplateConcat by lazy { VideoTemplateConcat(classLoader) }
    val VideoTemplateItem by lazy { VideoTemplateItem(classLoader) }
    val VideoTemplateFragmentPresenter by lazy { VideoTemplateFragmentPresenter(classLoader) }
    val AIFaceSwappingPresenter by lazy { AIFaceTemplatePresenter(classLoader) }
    val AIFaceTemplateBean by lazy { AIFaceTemplateBean(classLoader) }
}