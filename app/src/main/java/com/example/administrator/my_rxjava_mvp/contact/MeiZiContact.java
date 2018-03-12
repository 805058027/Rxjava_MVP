package com.example.administrator.my_rxjava_mvp.contact;

import com.example.administrator.my_rxjava_mvp.Presenter.base.BasePresenter;
import com.example.administrator.my_rxjava_mvp.base.IBaseView;
import com.example.administrator.my_rxjava_mvp.model.MeiZi;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */

public interface MeiZiContact {

    interface view extends IBaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(List<MeiZi> dataList);
    }

    interface presenter extends BasePresenter {
        /**
         * 获取数据
         */
        void getData(int page,int row);
    }
}
