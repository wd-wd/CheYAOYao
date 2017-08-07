package com.lanxiang.cheyaoyao.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.MainActivity;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.base.activity.BaseActivity;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.ui.activity.TabBottomActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.animation;

/**
 * Desc :启动页 品牌或者情怀展示
 * Created by WangDong on 2017/8/2.
 */

public class SplashActivity extends BaseActivity implements Animator.AnimatorListener {
    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    @BindView(R.id.tv_splash)
    TextView tvSplash;
    private ObjectAnimator mAnimator;

    @Override
    protected void initView() {
        mAnimator = ObjectAnimator.ofFloat(ivSplash, "alpha", 0f, 1f);
    }

    @Override
    protected void initListener() {
        mAnimator.addListener(this);
    }

    @Override
    protected void initData() {
        mAnimator.setDuration(3000);//设置时长
        mAnimator.start();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Intent intent = new Intent(SplashActivity.this, TabBottomActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
