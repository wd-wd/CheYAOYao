package com.lanxiang.cheyaoyao.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.base.activity.BaseActivity;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.ui.fragment.ChatFragment;
import com.lanxiang.cheyaoyao.ui.fragment.HomeFragment;
import com.lanxiang.cheyaoyao.ui.fragment.MineFragment;
import com.lanxiang.cheyaoyao.ui.fragment.MovieFragment;
import com.lanxiang.cheyaoyao.ui.fragment.ShequFragment;
import com.lanxiang.cheyaoyao.ui.fragment.TestFragment;
import com.lanxiang.cheyaoyao.ui.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc :底部切换
 * Created by WangDong on 2017/8/3.
 */

public class TabBottomActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_movie)
    RadioButton rbMovie;
    @BindView(R.id.rb_chat)
    RadioButton rbChat;
    @BindView(R.id.rb_shequ)
    RadioButton rbShequ;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    private List<Fragment> mFragments;
    private HomeFragment mHomeFragment;
    private VideoFragment mVideoFragment;
    private ChatFragment mChatFragment;
    private ShequFragment mShequFragment;
    private MineFragment mMineFragment;
    private Fragment mFragment;//定义当前fragment

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tabbottom;
    }

    @Override
    protected void initView() {
        initFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl, mFragments.get(0)).commit();
    }

    @Override
    protected void initListener() {
        rgTab.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        mFragment = mFragments.get(0);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mHomeFragment = new HomeFragment();
        mVideoFragment = new VideoFragment();
        mChatFragment = new ChatFragment();
        mShequFragment = new ShequFragment();
        mMineFragment = new MineFragment();
        mFragments.add(mHomeFragment);
        mFragments.add(mVideoFragment);
        mFragments.add(mChatFragment);
        mFragments.add(mShequFragment);
        mFragments.add(mMineFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                swichFragment(mFragments.get(0));
                break;
            case R.id.rb_movie:
                swichFragment(mFragments.get(1));
                break;
            case R.id.rb_chat:
                swichFragment(mFragments.get(2));
                break;
            case R.id.rb_shequ:
                swichFragment(mFragments.get(3));
                break;
            case R.id.rb_mine:
                swichFragment(mFragments.get(4));
                break;
        }
    }

    private void swichFragment(Fragment fragment) {
        if (mFragment != fragment) {//如果当前的fragment不等于传入的fragment就创建
            if (!fragment.isAdded()) {//如果当前的fragment未添加就隐藏当前的，添加
                getSupportFragmentManager().beginTransaction().hide(mFragment).add(R.id.fl, fragment).commit();
            } else {//如果当前的fragment添加就隐藏当前的显示添加的
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            //将再添加的赋值给当前
            mFragment = fragment;
        }
    }
}
