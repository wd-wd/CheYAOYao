package com.lanxiang.cheyaoyao.ui.presenter;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.ui.model.GoodsModel;
import com.lanxiang.cheyaoyao.ui.model.impl.GoodsModelImpl;
import com.lanxiang.cheyaoyao.utils.CommonCacheUtils;
import com.lanxiang.cheyaoyao.utils.NetWorkUtils;

import rx.Subscriber;

/**
 * Desc :商品列表的presenter
 * Created by WangDong on 2017/8/4.
 */

public class GoodsPresenterImpl extends BasePresenter<GoodsModelImpl, MvpView<GoodsListData>, GoodsListData> implements GoodsModel.OnListener {
    public GoodsPresenterImpl(GoodsModelImpl model, MvpView<GoodsListData> view) {
        super(model, view);
    }

    public void getGoodsData(String pageSize, String currentPageIndex) {
        getView().showLoadingView();
        if (NetWorkUtils.isNetworkConnected(CheYaoYaoApp.getsContext())) {
            addSubscription(getModel().getNetData(pageSize, currentPageIndex), new Subscriber<GoodsListData>() {//使用rx
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    getView().showErrorView();
                }

                @Override
                public void onNext(GoodsListData data) {
                    if (data != null) {
                        String json = CheYaoYaoApp.getGson().toJson(data);
                        CommonCacheUtils.cacheToFile(json, "goodsList.do");
                        if (data.resultMap.result != null && data.resultMap.result.size() > 0) {
                            getView().showSuccessContentView();
                        } else {
                            getView().showSuccessEmptyView();
                        }
                        getView().setData(data);
                    }
                }
            });
        }else {
            getModel().getCacheData("goodsList.do",this);
        }
        /*if (NetWorkUtils.isNetworkConnected(CheYaoYaoApp.getsContext())) {
            getModel().getNetData(pageSize, currentPageIndex, this);
        } else {
            getModel().getCacheData("goodsList.do",this);
        }*/
    }

    @Override
    public void onSuccess(GoodsListData goodsListData) {
        if (goodsListData != null) {
            if (goodsListData.resultMap.result.size() > 0) {
                getView().showSuccessContentView();
            } else {
                getView().showSuccessEmptyView();
            }
            getView().setData(goodsListData);
        }
    }

    @Override
    public void onError(String errorMessage) {
        getView().showErrorView();
    }
}
