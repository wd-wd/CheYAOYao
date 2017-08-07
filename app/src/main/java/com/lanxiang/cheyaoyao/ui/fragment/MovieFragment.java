package com.lanxiang.cheyaoyao.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.apkfuns.logutils.LogUtils;
import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.Http.RetrofitClient;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.adapter.MovieAdapter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.common.CYYApi;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.MovieTabListData;
import com.lanxiang.cheyaoyao.magicIndicator.MagicIndicator;
import com.lanxiang.cheyaoyao.magicIndicator.ViewPagerHelper;
import com.lanxiang.cheyaoyao.magicIndicator.buildins.commonnavigator.CommonNavigator;
import com.lanxiang.cheyaoyao.magicIndicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import com.lanxiang.cheyaoyao.magicIndicator.buildins.commonnavigator.abs.IPagerIndicator;
import com.lanxiang.cheyaoyao.magicIndicator.buildins.commonnavigator.abs.IPagerTitleView;
import com.lanxiang.cheyaoyao.magicIndicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import com.lanxiang.cheyaoyao.magicIndicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import com.lanxiang.cheyaoyao.ui.model.impl.TabTitleModelImpl;
import com.lanxiang.cheyaoyao.ui.presenter.MovieTabTitlePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Desc :视频fragment
 * Created by WangDong on 2017/6/1.
 */

public class MovieFragment extends Fragment implements MvpView<MovieTabListData> {
    @BindView(R.id.tab_magicIndicator)
    MagicIndicator tabMagicIndicator;
    @BindView(R.id.vp_movie)
    ViewPager vpMovie;
    Unbinder unbinder;
    List<MovieTabListData.MenusBean.SubmenusBean> mDataList;
    private MovieAdapter mMovieAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initListener();
        initData();
        return view;
    }

    private void initView() {

    }

    private void initListener() {

    }

    private void getData() {
        RetrofitClient.initBaseUrl(CheYaoYaoApp.getsContext(), CYYConstants.BAISI_URL);
        CYYApi cyyApi = RetrofitClient.getInstance().getCyyApi();
        Call<MovieTabListData> movieTabListData = cyyApi.getMovieTabListData();
        movieTabListData.enqueue(new Callback<MovieTabListData>() {
            @Override
            public void onResponse(Call<MovieTabListData> call, Response<MovieTabListData> response) {
                if (response.code() == 200 && response.body() != null) {
                    mDataList = response.body().menus.get(0).submenus;
                    mMovieAdapter = new MovieAdapter(getChildFragmentManager(), CheYaoYaoApp.getsContext(), mDataList);
                    vpMovie.setAdapter(mMovieAdapter);
                    vpMovie.setOffscreenPageLimit(mDataList.size());
                    initMagicIndicator();
                }
            }

            @Override
            public void onFailure(Call<MovieTabListData> call, Throwable t) {

            }
        });
    }

    private void initData() {
//        getData();
        loadData();
        LogUtils.e(vpMovie);
    }

    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(CheYaoYaoApp.getsContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index).name);
                simplePagerTitleView.setTextSize(18);
                simplePagerTitleView.setNormalColor(Color.parseColor("#c8e6c9"));
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vpMovie.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.WHITE);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
                indicator.setLineWidth(200);
                indicator.setYOffset(5);
                indicator.setLineHeight(6);
                indicator.setRoundRadius(3);
                return indicator;
            }
        });
        if (mDataList.size() < 6) {
            commonNavigator.setAdjustMode(true);
        } else {
            commonNavigator.setAdjustMode(false);
        }
        tabMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(tabMagicIndicator, vpMovie);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showSuccessEmptyView() {

    }

    @Override
    public void showSuccessContentView() {

    }

    @Override
    public void setData(MovieTabListData data) {
        if (mDataList == null) {
            mDataList = data.menus.get(0).submenus;
        }
        mMovieAdapter = new MovieAdapter(getChildFragmentManager(), CheYaoYaoApp.getsContext(), mDataList);
        vpMovie.setAdapter(mMovieAdapter);
        vpMovie.setOffscreenPageLimit(mDataList.size());
        initMagicIndicator();
    }

    @Override
    public void loadData() {
        MovieTabTitlePresenter movieTabTitlePresenter = new MovieTabTitlePresenter(new TabTitleModelImpl(), this);
        movieTabTitlePresenter.getTabTitlelistData();
    }
}
