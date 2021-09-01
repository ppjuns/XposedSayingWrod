package com.ppjun.dio

import android.Manifest
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ppjun.Constants
import com.tbruyelle.rxpermissions2.RxPermissions
import java.io.File

import java.lang.StringBuilder


/**
 * @description
 * @author ppjun
 * @date 2021-08-27 17:37
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rxpermission = RxPermissions(this)
        rxpermission.request(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
            .subscribe {
                if (it) {
                    init()
                }
            }


        val restart = findViewById<Button>(R.id.restart)
        restart.setOnClickListener {
            ShellUtil.executeCmd(arrayOf("am force-stop ${Constants.PACKAGE_NAME}"))
                .subscribe { t: Boolean? ->
                    if (t == null || !t) {
                        Toast.makeText(this, "没Kill掉爱字幕", Toast.LENGTH_SHORT).show()
                        return@subscribe
                    }
                    val wechatLaunchIntent =
                        packageManager.getLaunchIntentForPackage(Constants.PACKAGE_NAME)
                    wechatLaunchIntent?.let { startActivity(it) }
                }
        }
    }

    private fun init() {
        val file = File(Environment.getExternalStorageDirectory(), "$packageName.apk")
        val sourceDir = applicationInfo.sourceDir
        val apk = File(sourceDir)
        apk.copyTo(file, true)
        Toast.makeText(this, "初始化相关文件成功", Toast.LENGTH_SHORT).show()

    }
}