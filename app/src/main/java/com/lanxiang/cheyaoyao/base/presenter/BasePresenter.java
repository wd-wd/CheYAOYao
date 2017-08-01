package com.lanxiang.cheyaoyao.base.presenter;

import com.lanxiang.cheyaoyao.base.view.MvpView;

import java.lang.ref.WeakReference;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public class BasePresenter<M, V extends MvpView<D>, D> implements Presenter {//M：model V：view D：data

    private M mModel;
    private WeakReference<V> refView;//弱引用

    public BasePresenter(M model, V view) {
        this.mModel = model;
        this.refView = new WeakReference(view);
    }

    public V getView() {
        return refView == null ? null : refView.get();
    }

    public boolean isViewAttached() {
        return refView != null && refView.get() != null;
    }

    public M getModel() {
        if (mModel != null) {
            return mModel;
        }
        return null;
    }

    @Override
    public void onPresenterStart() {

    }

    @Override
    public void onPresenterDestroy() {
        this.mModel = null;
        if (refView!=null){
            refView.clear();
            refView=null;
        }
    }
}
