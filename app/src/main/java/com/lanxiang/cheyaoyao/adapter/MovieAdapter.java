package com.lanxiang.cheyaoyao.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanxiang.cheyaoyao.domain.MovieTabListData;
import com.lanxiang.cheyaoyao.ui.fragment.MovieListFragment;

import java.util.List;

/**
 * Desc :
 * Created by WangDong on 2017/8/4.
 */

public class MovieAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<MovieTabListData.MenusBean.SubmenusBean> mDataLists;

    public MovieAdapter(FragmentManager fm, Context context, List<MovieTabListData.MenusBean.SubmenusBean> dataLists) {
        super(fm);
        mContext = context;
        mDataLists = dataLists;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (fragment == null){
            fragment = MovieListFragment.newInstance(mDataLists.get(position).name);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mDataLists==null?0:mDataLists.size();
    }
}
