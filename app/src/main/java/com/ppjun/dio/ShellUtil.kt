package com.ppjun.dio

import com.jaredrummler.android.shell.Shell
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @description
 * @author ppjun
 * @date 2021-08-31 17:05
 */
class ShellUtil {
    companion object{
        fun executeCmd(cmds: Array<String>) = Observable.create(ObservableOnSubscribe<Boolean> { emitter ->
            val result = Shell.SU.run(cmds.joinToString("; "))
            emitter.onNext(result.isSuccessful)
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}