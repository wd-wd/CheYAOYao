package com.lanxiang.cheyaoyao.ui.presenter;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.domain.MovieTabListData;
import com.lanxiang.cheyaoyao.ui.model.TabTitleModel;
import com.lanxiang.cheyaoyao.ui.model.impl.TabTitleModelImpl;
import com.lanxiang.cheyaoyao.utils.NetWorkUtils;

/**
 * Desc :视频tabTitlepresenter实现类
 * Created by WangDong on 2017/8/5.
 */

public class MovieTabTitlePresenter extends BasePresenter<TabTitleModelImpl, MvpView<MovieTabListData>, MovieTabListData> implements TabTitleModel.OnListener {
    public MovieTabTitlePresenter(TabTitleModelImpl model, MvpView<MovieTabListData> view) {
        super(model, view);
    }

    public void getTabTitlelistData() {
        if (NetWorkUtils.isNetworkConnected(CheYaoYaoApp.getsContext())) {
            getModel().getTabTitleData(this);
        } else {
            getModel().getCacheData(this);
        }
    }

    @Override
    public void onsuccess(MovieTabListData movieTabListData) {
        if (movieTabListData != null) {
            if (movieTabListData.menus.size() > 0) {
                getView().showSuccessContentView();
                getView().setData(movieTabListData);
            }
        }
    }

    @Override
    public void onError(String errorMassage) {
        getView().showErrorView();
    }
}
