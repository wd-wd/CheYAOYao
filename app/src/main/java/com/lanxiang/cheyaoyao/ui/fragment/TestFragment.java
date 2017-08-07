package com.lanxiang.cheyaoyao.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.adapter.GoodsAdapter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.ui.model.impl.GoodsModelImpl;
import com.lanxiang.cheyaoyao.ui.presenter.GoodsPresenterImpl;
import com.lanxiang.cheyaoyao.widget.LoadStateLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :测试商品
 * Created by WangDong on 2017/8/4.
 */

public class TestFragment extends Fragment implements MvpView<GoodsListData> {
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    Unbinder unbinder;
    @BindView(R.id.loadStateLayout)
    LoadStateLayout loadStateLayout;
    private GoodsAdapter mGoodsAdapter;
    private List<GoodsListData.ResultMapBean.ResultBean> mItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initListener();
        initData();
        return view;
    }

    private void initView() {
        loadStateLayout.setLoadingView(R.layout.stateview_loading);
        loadStateLayout.setEmptyView(R.layout.stateview_empty);
        loadStateLayout.setErrorView(R.layout.stateview_error);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(CheYaoYaoApp.getsContext(),
                2, LinearLayoutManager.VERTICAL, false);
        rvMovie.setLayoutManager(gridLayoutManager);
        mGoodsAdapter = new GoodsAdapter();
        rvMovie.setAdapter(mGoodsAdapter);
    }

    private void initListener() {

    }

    private void initData() {
        loadStateLayout.setState(LoadStateLayout.STATE_LOADING);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 2000);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoadingView() {
        loadStateLayout.setState(LoadStateLayout.STATE_LOADING);
    }

    @Override
    public void showErrorView() {
        loadStateLayout.setState(LoadStateLayout.STATE_ERROR);
    }

    @Override
    public void showSuccessEmptyView() {
        loadStateLayout.setState(LoadStateLayout.STATE_EMPTY);
    }

    @Override
    public void showSuccessContentView() {
        loadStateLayout.setState(LoadStateLayout.STATE_SUCCESS);
    }

    @Override
    public void setData(GoodsListData data) {
        if (data != null) {
            mItems = data.resultMap.result;
            mGoodsAdapter.setItems(mItems);
        }
    }

    @Override
    public void loadData() {
        GoodsPresenterImpl goodsPresenter = new GoodsPresenterImpl(new GoodsModelImpl(), this);
        goodsPresenter.getGoodsData("10", "1");
    }
}
