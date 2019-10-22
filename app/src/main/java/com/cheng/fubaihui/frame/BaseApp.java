package com.cheng.fubaihui.frame;

import android.app.Application;
import android.content.Context;


import com.cheng.fubaihui.frame.safe.DeviceUuidFactory;

import java.util.UUID;

public class BaseApp extends Application {
    private static BaseApp sApplication;
    public boolean mPlayInWifi = false;
    public String mToken;
    public UUID mUuid;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        mUuid = DeviceUuidFactory.getInstance(getApplicationContext()).getDeviceUuid();
    }

    public static BaseApp getApplication() {
        return sApplication;
    }

    public static Context getAppContext() {
        return sApplication.getApplicationContext();
    }
}
