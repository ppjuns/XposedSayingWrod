# XposedSayingWrod
爱字mu版本v2.8.1，采用了网易易盾加固，其Applicaiton名为com.netease.nis.wrapper，包名为cn.nineton.sayingwrod，在Applicaiton调用了很多java2c方法来完成初始化，apk里面只有一个classes.dex文件有40多M。尝试了frida-dumpdex,dumpdex等工具，最后在7.1.2的手机上使用Fdex2来dump出对应的dex文件。（fdex原理是在getclassloader.getdex.getfile）

### 寻找hook点
我们可以使用命令找到当前Activity的名字，然后jadx打开dex文件找到对应类的源码
```
adb shell dumpsys activity activities | grep mResume
```

因为爱字mu使用了mvp的架构，网络请求都在presenter层中使用rxjava和retrofit来完成请求网络，所以在p层会调用v层的方法来改变ui界面。所以我们找到getView().result(list)方法，就可以找到返回值list。

### 接口加密
爱字mu的请求接口采用加密的方法，在ApiBaseParamsInterept拦截器上，将请求参数（公共参数和接口参数）按照key升序排列，再将全部key和value进行md5编码，得到sign的请求参数值
```
    private String sign(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            arrayList.add(str);
        }
        Collections.sort(arrayList, $$Lambda$ApiBaseParamsInterept$R2G3TduFSmLv0zVuzyTZtBegIL0.INSTANCE);
        for (int i = 0; i < arrayList.size(); i++) {
            String str2 = (String) arrayList.get(i);
            sb.append(String.format("%s=%s&", str2, map.get(str2)));
        }
        sb.append(Constant.API_SALT);
        return AuthCode.MD5(sb.toString());
    }
```
### 接口解密
接口请求顺利的话会得到一串数字字母的字符串（8826b0bb81706007dd6a70586191651169a099cc5f0c48...）
```
    static /* synthetic */ Object lambda$provideResponseConcert$0(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String Decrypt = Aes.Decrypt(str, Constant.API_AES_KEY);
                Logger.wtf("接口解密后返回:%s", new Object[]{Decrypt});
                return Decrypt;
            }
            Logger.wtf("接口参数空", new Object[0]);
            return null;
        } catch (Exception e) {
           ...
        }
    }
```
查看代码可知，服务器使用了aes对称加密返回数据，客户端需要使用秘钥解密即可得到明文。

### hook
直接hook P层调用V层的方法，拿到对应的list来收集数据。比如hook在AIFaceTemplatePresenter类的lambda$getAiTemplate$1，我们就可以拿到对应list。

### 插件
该插件支持不用重启生效插件（第一次安装后需要重启，后续修改插件不用重启）原理是使用dexclassloader加载apk文件，然后重启目标app，让插件马上生效。

声明：以上仅供学习使用，如有侵权，请通知删除。









