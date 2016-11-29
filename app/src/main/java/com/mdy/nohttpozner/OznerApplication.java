package com.mdy.nohttpozner;

import com.yolanda.nohttp.Logger;

/**
 * Created by cecha on 2016/11/28.
 */

public class OznerApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.setDebug(true);
        Logger.setTag("mdy");
    }
}
