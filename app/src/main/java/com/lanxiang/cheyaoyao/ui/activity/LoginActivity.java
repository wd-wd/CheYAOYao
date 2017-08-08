package com.lanxiang.cheyaoyao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.mob.MobSDK;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * Desc :
 * Created by WangDong on 2017/8/8.
 */

public class LoginActivity extends AppCompatActivity implements PlatformActionListener {
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    private PlatformDb platDB;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                authorize(weibo);
                Intent intent = new Intent(LoginActivity.this,TabBottomActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 执行授权,获取用户信息
     *
     * @param plat
     */
    private void authorize(Platform plat) {
        if (plat == null) {
            return;
        }
//判断指定平台是否已经完成授权
        if (plat.isAuthValid()) {
            String token = plat.getDb().getToken();
            String userId = plat.getDb().getUserId();
            String name = plat.getDb().getUserName();
            String gender = plat.getDb().getUserGender();
            String headImageUrl = plat.getDb().getUserIcon();
            String platformNname = plat.getDb().getPlatformNname();
            if (userId != null) {

                //已经授权过，直接下一步操作
                if (platformNname.equals(SinaWeibo.NAME)) {
                    //微博授权
                } else if (platformNname.equals(QQ.NAME)) {
                    //QQ授权
                } else if (platformNname.equals(Wechat.NAME)) {
                    //微信授权
                }
                return;
            }
        }

        // true不使用SSO授权，false使用SSO授权
        plat.SSOSetting(false);
        plat.setPlatformActionListener(this);
        plat.authorize();

        //获取用户资料
        plat.showUser(null);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        String headImageUrl = null;//头像
        String token;//token
        String gender;//年龄
        String userId;
        String name = null;//用户名

        // 用户资源都保存到res
        // 通过打印res数据看看有哪些数据是你想要的
        if (i == Platform.ACTION_USER_INFOR) {
            platDB = platform.getDb(); // 获取数平台数据DB
            if (platform.getName().equals(Wechat.NAME)) {

                // 通过DB获取各种数据
                token = platDB.getToken();
                userId = platDB.getUserId();
                name = platDB.getUserName();
                gender = platDB.getUserGender();
                headImageUrl = platDB.getUserIcon();
                if ("m".equals(gender)) {
                    gender = "1";
                } else {
                    gender = "2";
                }

            } else if (platform.getName().equals(SinaWeibo.NAME)) {
                // 微博登录
                name = hashMap.get("nickname").toString(); // 名字
                gender = hashMap.get("gender").toString(); // 年龄
                headImageUrl = hashMap.get("figureurl_qq_2").toString(); // 头像figureurl_qq_2 中等图，figureurl_qq_1缩略图
                getUserInfo(name, headImageUrl);

            } else if (platform.getName().equals(QQ.NAME)) {
                // QQ登录
                token = platDB.getToken();
                userId = platDB.getUserId();
                name = hashMap.get("nickname").toString(); // 名字
                gender = hashMap.get("gender").toString(); // 年龄
                headImageUrl = hashMap.get("figureurl_qq_2").toString(); // 头像figureurl_qq_2 中等图，figureurl_qq_1缩略图
                String city = hashMap.get("city").toString(); // 城市
                String province = hashMap.get("province").toString(); // 省份
                getUserInfo(name, headImageUrl);
            }
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(Platform platform, int i) {

    }

    private void getUserInfo(final String name, final String imgUrl) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvUserName.setText(name);
                Glide.with(CheYaoYaoApp.getsContext()).load(imgUrl).into(ivImage);
            }
        });
    }
}
