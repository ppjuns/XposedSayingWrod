package com.ppjun.hook

import com.ppjun.clazz.CnClazz
import de.robv.android.xposed.XC_MethodHook
import java.io.File

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 15:39
 */
class AIFaceHook {
    init {
        val file = File("/sdcard/aiface.txt")
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        CnClazz.AIFaceSwappingPresenter.getAiFaceTemplateList.setHook(object : XC_MethodHook() {
            override fun afterHookedMethod(param: MethodHookParam) {
                super.afterHookedMethod(param)
                val list = param.args[1] as List<Any>
                list.forEach { bean ->
                    val name = CnClazz.AIFaceTemplateBean.name.get(bean)
                    val thumbimage = CnClazz.AIFaceTemplateBean.thumbimage.get(bean)
                    val linkfile = CnClazz.AIFaceTemplateBean.linkfile.get(bean)
                    println("AIFaceTemplateBean=${name},${thumbimage},${linkfile}")
                    file.appendText("标题=${name},封面=${thumbimage},链接=${linkfile}")
                    file.appendText("\r\n")
                }
            }
        })
    }
}