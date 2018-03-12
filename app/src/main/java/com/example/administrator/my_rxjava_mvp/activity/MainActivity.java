package com.example.administrator.my_rxjava_mvp.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.my_rxjava_mvp.Presenter.MeiZiPresenter;
import com.example.administrator.my_rxjava_mvp.R;
import com.example.administrator.my_rxjava_mvp.activity.base.BaseActivity;
import com.example.administrator.my_rxjava_mvp.contact.MeiZiContact;
import com.example.administrator.my_rxjava_mvp.model.MeiZi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MeiZiContact.presenter> implements MeiZiContact.view {

    @BindView(R.id.text)
    TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.getData(1,1);
    }

    @Override
    public MeiZiContact.presenter initPresenter() {
        return new MeiZiPresenter(this);
    }

    @Override
    public void setData(List<MeiZi> dataList) {
        mText.setText("数据的长度--" + dataList.size());
    }

}
