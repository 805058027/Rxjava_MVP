package com.example.administrator.my_rxjava_mvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/3/9.
 */

public class App extends Application {
    private static App app;

    public static Context getAppContext() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(this);
        app = this;
    }
}
