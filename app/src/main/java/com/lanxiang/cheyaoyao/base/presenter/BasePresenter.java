package com.lanxiang.cheyaoyao.base.presenter;

import com.lanxiang.cheyaoyao.base.view.MvpView;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public class BasePresenter<M, V extends MvpView<D>, D> implements Presenter {//M：model V：view D：data

    private M mModel;
    private WeakReference<V> refView;//弱引用
    private CompositeSubscription mCompositeSubscription;

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
    public void addSubscription(Observable observable, Subscriber subscriber) {
        onUnsubscribe();
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
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
        onUnsubscribe();
    }
    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
