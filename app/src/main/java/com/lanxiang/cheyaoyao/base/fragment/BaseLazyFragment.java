package com.lanxiang.cheyaoyao.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :fragment的基类，进行了懒加载的处理
 * Created by WangDong on 2017/8/9.
 */

public abstract class BaseLazyFragment<P extends BasePresenter> extends Fragment {
    private Context mContext;
    private P mPresenter;
    protected Unbinder mUnbinder;
    private boolean isVisible = false;//当前Fragment是否可见
    private boolean isInitView = false;//是否与View建立起映射关系
    private boolean isFirstLoad = true;//是否是第一次加载数据

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.i(" onCreateView  " + this.getClass().getSimpleName());
        View view = getFragmentView(inflater, container);
        mUnbinder = ButterKnife.bind(this, view);
        isInitView = true;//与view有映射关系
        lazyLoadData();//调用懒加载数据的方法
        return view;
    }

    /**
     * 懒加载数据的处理逻辑
     */
    private void lazyLoadData() {
        if (isFirstLoad) {
            LogUtils.i("第一次加载 " + " isInitView  " + isInitView + "  isVisible  " + isVisible + "   " + this.getClass().getSimpleName());
        } else {
            LogUtils.i("不是第一次加载" + " isInitView  " + isInitView + "  isVisible  " + isVisible + "   " + this.getClass().getSimpleName());
        }
        if (!isFirstLoad || !isVisible || !isInitView) {
            LogUtils.i("不加载" + "   " + this.getClass().getSimpleName());
            return;
        }
        LogUtils.i("完成数据第一次加载" + "   " + this.getClass().getSimpleName());
        initData();
        isFirstLoad = false;
    }

    protected abstract View getFragmentView(LayoutInflater inflater, ViewGroup container);

    protected abstract void initData();

    /**
     * fragment是否对当前用户显示
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        LogUtils.i("isVisibleToUser " + isVisibleToUser + "   " + this.getClass().getSimpleName());
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoadData();
        } else {
            isVisible = false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.onPresenterDestroy();
        }
        super.onDestroyView();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }
}
