package com.lanxiang.cheyaoyao.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :  聊天
 * Created by WangDong on 2017/8/3.
 */
public class MovieListFragment extends Fragment {
    private static final String ARGS_PAGE = "ARGS_PAGE";
    @BindView(R.id.tv_list)
    TextView tvList;
    Unbinder unbinder;
    private String mType;

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
        mType = getArguments().getString(ARGS_PAGE);
        tvList.setText(mType);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
