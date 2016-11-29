# NoHttpOzner 作为nohttp和其他一些常用框架的学习demo

#NoHttp使用文档 http://doc.nohttp.net/162186

#ButterKnife的使用：
butterknife8.0之后的版本集成需要在项目根目录的build.gradle文件中增加一个插件
    classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
然后在Module的gradle文件中添加引用 apply plugin: 'com.neenbedankt.android-apt' ，
在依赖文件中添加同版本的
    compile 'com.jakewharton:butterknife:8.4.0'
    apt 'com.jakewharton:butterknife-compiler:8.4.0'

