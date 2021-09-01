package com.ppjun.hook

import com.ppjun.clazz.CnClazz
import de.robv.android.xposed.XC_MethodHook
import java.io.File

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 15:37
 */
class FetchVideoTypeHook {
    init {
        val file = File("/sdcard/Zimu.txt")
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        CnClazz.VideoTemplateFragmentPresenter.fetchVideoType.setHook(object :
            XC_MethodHook() {
            override fun afterHookedMethod(param: MethodHookParam) {
                super.afterHookedMethod(param)
                val list = param.args[1] as List<Any>
                list.forEach { concat ->
                    val videoTemplateItem =
                        CnClazz.VideoTemplateConcat.VideoTemplateItem.get(concat)
                    val title =
                        CnClazz.VideoTemplateItem.title.get(videoTemplateItem)
                    val thumb =
                        CnClazz.VideoTemplateItem.thumb.get(videoTemplateItem)
                    val link =
                        CnClazz.VideoTemplateItem.link.get(videoTemplateItem)
                    println("VideoTemplate=${title},${thumb},${link}")
                    file.appendText("标题=${title},封面=${thumb},链接=${link}")
                    file.appendText("\r\n")
                }
            }
        })

    }
}