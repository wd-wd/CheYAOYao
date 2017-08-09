package com.lanxiang.cheyaoyao.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.adapter.MovieListAdapter;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :  视频笑话图片的列表
 * Created by WangDong on 2017/8/3.
 */
public class MovieListFragment extends Fragment {
    private static final String ARGS_PAGE = "ARGS_PAGE";
    @BindView(R.id.tv_list)
    TextView tvList;
    Unbinder unbinder;
    @BindView(R.id.rv_movie_list)
    RecyclerView rvMovieList;
    private String mType;
    private LinearLayoutManager mLinearLayoutManager;
    private MovieListAdapter mMovieListAdapter;
    private String[] strs = {"video","video","image","gif","text","video","gif","text","video",
            "video","gif","text","image","video","gif","text","image","video","gif","text","image","video"};
    private List<String> mStringList = Arrays.asList(strs);

    public static MovieListFragment newInstance(String page) {
        Bundle args = new Bundle();
        args.putString(ARGS_PAGE, page);
        MovieListFragment movieListFragment = new MovieListFragment();
        movieListFragment.setArguments(args);
        return movieListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_movie, null, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initListener();
        initData();
        return view;
    }

    private void initView() {
        mLinearLayoutManager = new LinearLayoutManager(CheYaoYaoApp.getsContext(), LinearLayoutManager.VERTICAL, false);
        mMovieListAdapter = new MovieListAdapter(mStringList);
    }

    private void initListener() {

    }

    private void initData() {
        mType = getArguments().getString(ARGS_PAGE);
        tvList.setText(mType);
        rvMovieList.setLayoutManager(mLinearLayoutManager);
        rvMovieList.setAdapter(mMovieListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
