package com.example.administrator.my_rxjava_mvp.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.my_rxjava_mvp.Presenter.base.BasePresenter;
import com.example.administrator.my_rxjava_mvp.base.IBaseView;

/**
 * Created by Administrator on 2018/3/9.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected P presenter;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        //ActivityManager.getAppInstance().addActivity(this);//将当前activity添加进入管理栈
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        //ActivityManager.getAppInstance().removeActivity(this);//将当前activity移除管理栈
        if (presenter != null) {
            presenter.unDisposable();
            presenter.detach();//在presenter中解绑释放view
            presenter = null;
        }
        super.onDestroy();
    }

    /**
     * 在子类中初始化对应的presenter
     *
     * @return 相应的presenter
     */
    public abstract P initPresenter();

}
