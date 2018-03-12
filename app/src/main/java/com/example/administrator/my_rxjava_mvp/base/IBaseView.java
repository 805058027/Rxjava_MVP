package com.example.administrator.my_rxjava_mvp.base;

/**
 * 描述：视图基类
 */

public interface IBaseView<T> {
    /**
     * @descriptoin 请求前加载progress
     */
    void showProgress();

    /**
     * @descriptoin 请求结束之后隐藏progress
     */
    void dismissProgress();

    /**
     * @param tData 数据类型
     * @descriptoin 请求数据成功
     */
    void loadDataSuccess(T tData);

    /**
     * @param throwable 异常类型
     * @descriptoin 请求数据错误
     */
    void loadDataError(Throwable throwable);
}
