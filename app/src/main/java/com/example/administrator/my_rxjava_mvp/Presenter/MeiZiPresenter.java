package com.example.administrator.my_rxjava_mvp.Presenter;

import android.app.Activity;

import com.example.administrator.my_rxjava_mvp.Presenter.base.BasePresenterImpl;
import com.example.administrator.my_rxjava_mvp.contact.MeiZiContact;
import com.example.administrator.my_rxjava_mvp.model.MeiZi;
import com.example.administrator.my_rxjava_mvp.model.base.BasicResponse;
import com.example.administrator.my_rxjava_mvp.net.DefaultObserver;
import com.example.administrator.my_rxjava_mvp.net.IdeaApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/3/9.
 */

public class MeiZiPresenter extends BasePresenterImpl<MeiZiContact.view> implements MeiZiContact.presenter {
    private Activity activity;

    public MeiZiPresenter(MeiZiContact.view view) {
        super(view);
        activity = (Activity) view;
    }
    /**
     * 获取数据
     */
    @Override

    public void getData(int page, int row) {
        IdeaApi.getApiService()
                .getMezi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<BasicResponse<List<MeiZi>>>(activity) {
                    @Override
                    public void onSuccess(BasicResponse<List<MeiZi>> response) {
                        view.setData(response.getResults());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDisposable(d);
                    }
                });
    }

}
