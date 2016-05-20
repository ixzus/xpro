package com.ixzus.xpro;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by metro on 2016/3/18.
 */
public class XApplication extends Application {

    private static XApplication xApplication;

    public static XApplication getInstance() {
        return xApplication;
    }

    private RefWatcher refWatcher;
    public static RefWatcher getRefWatcher(Context context) {
        XApplication xApplication  = (XApplication) context.getApplicationContext();
        return xApplication.refWatcher;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        final boolean isDebug = true;
        if(isDebug) {
            refWatcher = LeakCanary.install(this);
        }
        xApplication = this;
        //添加网络权限...
        //内存检测

    }
}
