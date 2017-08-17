package com.lanxiang.cheyaoyao.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.base.activity.BaseActivity;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.domain.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Desc :注册
 * Created by WangDong on 2017/8/17.
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.et_user_name)
    TextInputEditText etUserName;
    @BindView(R.id.et_pass_word)
    TextInputEditText etPassWord;
    @BindView(R.id.bt_register)
    Button btRegister;
    private String mUsername;
    private String mPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.et_user_name, R.id.et_pass_word, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_user_name:
                break;
            case R.id.et_pass_word:
                break;
            case R.id.bt_register:
                mUsername = etUserName.getText().toString().trim();

                mPassword = etPassWord.getText().toString().trim();
                if (TextUtils.isEmpty(mUsername)||TextUtils.isEmpty(mPassword)) {
                    Toast.makeText(CheYaoYaoApp.getsContext(),"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                register(mUsername,mPassword);
                break;
        }
    }

    private void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //Bmob所有回调方法都是在主线程被调用的
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {//他讲成功和失败封装到一起了
                if (e==null){//注册成功
                    Toast.makeText(CheYaoYaoApp.getsContext(),"注册成功",Toast.LENGTH_SHORT).show();
                }else {//注册失败
                    LogUtils.e(e);
                    Toast.makeText(CheYaoYaoApp.getsContext(),"注册失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
