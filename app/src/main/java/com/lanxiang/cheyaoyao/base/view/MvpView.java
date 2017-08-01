package com.lanxiang.cheyaoyao.base.view;

/**
 * Desc :Mvp的view底层接口
 * Created by WangDong on 2017/7/28.
 */

public interface MvpView<M> extends BaseView {
    /**
     * 正在加载界面展示
     */
    void showLoadingView();

    /**
     * 加载失败界面展示
     */
    void showErrorView();

    void showSuccessEmptyView();

    void showSuccessContentView();

    void setData(M data);

    void loadData();
}
