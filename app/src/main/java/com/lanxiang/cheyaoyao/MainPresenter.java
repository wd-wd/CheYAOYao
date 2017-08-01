package com.lanxiang.cheyaoyao;

import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.ActivityListData;
import com.lanxiang.cheyaoyao.utils.NetWorkUtils;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public class MainPresenter extends BasePresenter<MainModel, MvpView<ActivityListData>, ActivityListData> implements MainModel.onListener {
    public MainPresenter(MainModel model, MvpView<ActivityListData> view) {
        super(model, view);
    }

    public void getData(String myFlag, String userid, String currentPageIndex) {
        getView().showLoadingView();
        if (NetWorkUtils.isNetworkConnected(CheYaoYaoApp.getsContext())) {
            getModel().getNetData(myFlag, userid, currentPageIndex, this);
        } else {
            getModel().getCacheData("queryMyComActivityByUserId.do", this);
        }
    }

    @Override
    public void onSuccess(ActivityListData activityListData) {
        if (activityListData != null) {//java与kotlin的一个区别是要多做非空判断
            if (activityListData.data.items.size() > 0) {
                getView().showSuccessContentView();
            } else {
                getView().showSuccessEmptyView();
            }
            getView().setData(activityListData);
        }
    }

    @Override
    public void onFailed(String errorMessage) {
        getView().showErrorView();
    }
}
