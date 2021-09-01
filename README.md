# XposedSayingWrod
爱字幕版本v2.8.1，采用了网易易盾加固，其Applicaiton名为com.netease.nis.wrapper，包名为cn.nineton.sayingwrod，在Applicaiton调用了很多java2c方法来完成初始化，apk里面只有一个classes.dex文件有40多M。
最后使用Fdex2来dump出对应的dex文件。

### 寻找hook点
我们可以使用命令找到当前Activity的名字，然后jadx打开dex文件找到对应类的源码
```
adb shell dumpsys activity activities | grep mResume
```

因为爱字幕使用了mvp的架构，网络请求都在presenter层中使用rxjava和retrofit来完成请求网络，所以在p层会调用v层的方法来改变ui界面。所以我们找到getView().result(list)方法，就可以找到返回值list。

### hook
直接hook P层调用V层的方法，拿到对应的list来收集数据。











