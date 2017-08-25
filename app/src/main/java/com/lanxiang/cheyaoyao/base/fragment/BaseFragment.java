package com.lanxiang.cheyaoyao.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.apkfuns.logutils.LogUtils;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :fragment的基类，进行了懒加载的处理
 * Created by WangDong on 2017/8/9.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    private Context mContext;
    private P mPresenter;
    protected Unbinder mUnbinder;
    private boolean isInitView;//是否与View建立起映射关系
    protected View mViewRoot;

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
        if (mViewRoot == null) {
            mViewRoot = inflater.inflate(getLayoutId(), container, false);
            mUnbinder = ButterKnife.bind(this, mViewRoot);
            initView();
            initListener();
            if (!isInitView) {
                initData();
                isInitView = true;
            }
        }
        return mViewRoot;
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.onPresenterDestroy();
        }
        super.onDestroyView();

        if (mViewRoot != null) {
            ViewParent parent = mViewRoot.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(mViewRoot);
            }
        }
        if (mUnbinder != null)
            mUnbinder.unbind();
    }
}
