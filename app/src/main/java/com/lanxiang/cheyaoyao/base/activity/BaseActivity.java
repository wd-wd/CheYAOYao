package com.lanxiang.cheyaoyao.base.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :activity的基类
 * Created by WangDong on 2017/8/3.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    private Unbinder mBind;
    private P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);//子类就不用再bind
        initView();
        initListener();
        initData();
    }

    protected abstract int getLayoutId();//获取布局id，由子类实现

    protected abstract void initView();//初始化view

    protected abstract void initListener();//初始化监听

    protected abstract void initData();//初始化数据
    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();//解除绑定
        }
    }
}
