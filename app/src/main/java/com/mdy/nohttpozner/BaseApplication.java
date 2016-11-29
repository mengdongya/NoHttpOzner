package com.mdy.nohttpozner;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.URLConnectionNetworkExecutor;
import com.yolanda.nohttp.cache.DBCacheStore;

/**
 * Created by cecha on 2016/11/28.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        NoHttp.initialize(this,new NoHttp.Config().setNetworkExecutor(new URLConnectionNetworkExecutor()).setCacheStore(new DBCacheStore(this).setEnable(false)));
//        NoHttp.initialize(this,new NoHttp.Config().setConnectTimeout(30*1000));
    }
}
