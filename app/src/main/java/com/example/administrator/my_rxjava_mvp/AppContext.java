package com.example.administrator.my_rxjava_mvp;

import android.content.Context;

/**
 * Created by Administrator on 2018/3/9.
 */

public class AppContext {

    private static Context context;

    private AppContext() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        AppContext.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}
