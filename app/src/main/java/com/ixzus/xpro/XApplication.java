package com.ixzus.xpro;

import android.app.Application;

/**
 * Created by metro on 2016/3/18.
 */
public class XApplication extends Application {

    private static XApplication xApplication;

    public static XApplication getInstance() {
        return xApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        xApplication = this;
        //添加网络权限...

    }
}
