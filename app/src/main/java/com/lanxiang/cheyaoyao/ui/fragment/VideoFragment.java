package com.lanxiang.cheyaoyao.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.adapter.VideoAdapter;
import com.lanxiang.cheyaoyao.base.fragment.BaseFragment;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.domain.VideoData;
import com.lanxiang.cheyaoyao.ui.model.impl.VideoListModelImpl;
import com.lanxiang.cheyaoyao.ui.presenter.VideoListPresenter;
import com.lanxiang.cheyaoyao.widget.LoadStateLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Desc :项目中的视频界面
 * Created by WangDong on 2017/8/24.
 */

public class VideoFragment extends BaseFragment implements MvpView<VideoData> {

    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    @BindView(R.id.loadLayout)
    LoadStateLayout loadLayout;
    Unbinder unbinder;
    private LinearLayoutManager mLinearLayoutManager;
    private VideoAdapter mVideoAdapter;
    private List<VideoData.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mContentlist;
    private int pager = 1;

    @Override
    protected VideoListPresenter createPresenter() {
        VideoListPresenter videoListPresenter = new VideoListPresenter(new VideoListModelImpl(), this);
        return videoListPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_fragment;
    }


    @Override
    protected void initView() {
        loadLayout.setLoadingView(R.layout.stateview_loading);
        loadLayout.setEmptyView(R.layout.stateview_empty);
        loadLayout.setErrorView(R.layout.stateview_error);
        loadLayout.setState(LoadStateLayout.STATE_LOADING);
        mLinearLayoutManager = new LinearLayoutManager(CheYaoYaoApp.getsContext(), LinearLayoutManager.VERTICAL, false);
        rvVideo.setLayoutManager(mLinearLayoutManager);
        mVideoAdapter = new VideoAdapter(CheYaoYaoApp.getsContext());
        rvVideo.setAdapter(mVideoAdapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        loadData();
    }

    @Override
    public void showLoadingView() {
        loadLayout.setState(LoadStateLayout.STATE_LOADING);
    }

    @Override
    public void showErrorView() {
        loadLayout.setState(LoadStateLayout.STATE_ERROR);
    }

    @Override
    public void showSuccessEmptyView() {
        loadLayout.setState(LoadStateLayout.STATE_EMPTY);
    }

    @Override
    public void showSuccessContentView() {
        loadLayout.setState(LoadStateLayout.STATE_SUCCESS);
    }

    @Override
    public void setData(VideoData data) {
        mContentlist = data.showapiResBody.pagebean.contentlist;
        mVideoAdapter.setItem(mContentlist);
    }

    @Override
    public void loadData() {
        createPresenter().getVideoList("30536", "afb5409eac144403a8f13c6bb51cac1f", "41", String.valueOf(pager));
    }

    @Override
    public void onResume() {
        super.onResume();
        //得到Fragment的根布局并使该布局可以获得焦点
        getView().setFocusableInTouchMode(true);
        //得到Fragment的根布局并且使其获得焦点
        getView().requestFocus();
        //对该根布局View注册KeyListener的监听
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    if (JCVideoPlayer.backPress()) {//监听视频播放的全屏退出
                        return true;
                    }
                }
                return false;
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
