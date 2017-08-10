package com.lanxiang.cheyaoyao.ui.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.adapter.HomeListAdapter;
import com.lanxiang.cheyaoyao.adapter.MovieListAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Desc :  主界面
 * Created by WangDong on 2017/8/3.
 */
public class HomeFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.home_tv_address)
    TextView homeTvAddress;
    @BindView(R.id.ll_title_search)
    LinearLayout llTitleSearch;
    @BindView(R.id.ll_title_container)
    LinearLayout llTitleContainer;
    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    private String[] strs = {"banner","fenlei","video", "video", "image", "gif", "text", "video", "gif", "text", "video",
            "video", "gif", "text", "image", "video", "gif", "text", "image", "video", "gif", "text", "image", "video"};
    private List<String> mStringList = Arrays.asList(strs);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initListener();
        initData();
        return view;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CheYaoYaoApp.getsContext()
                , LinearLayoutManager.VERTICAL, false);
        rvHome.setLayoutManager(linearLayoutManager);
        HomeListAdapter homeListAdapter = new HomeListAdapter(mStringList);
        rvHome.setAdapter(homeListAdapter);
    }
    //累积的滚动量
    private int sumY = 0;
    //设计在0到150之间去改变头部的透明度
    private float duration = 300.0f;
    //系统的颜色计算器
    private ArgbEvaluator evaluator = new ArgbEvaluator();
    private void initListener() {
        rvHome.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             *
             * @param recyclerView
             * @param dx 滚动的增量
             * @param dy 滚动的增量
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                sumY+=dy;
                // 滚动的总距离相对0-150之间有一个百分比，头部的透明度也是从初始值变动到不透明，通过距离的百分比，得到透明度对应的值
                // 如果小于0那么透明度为初始值，如果大于150为不透明状态
                int bgColor = 0X5520c0a0;
                if (sumY < 0) {
                    bgColor = 0X5520c0a0;
                } else if (sumY > 300) {
                    bgColor = 0XFF20c0a0;
                } else {
                    bgColor = (int) evaluator.evaluate(sumY / duration, 0X5520c0a0, 0XFF20c0a0);
                }
                llTitleContainer.setBackgroundColor(bgColor);
            }
        });
    }

    private void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
