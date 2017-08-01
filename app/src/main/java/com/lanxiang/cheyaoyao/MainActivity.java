package com.lanxiang.cheyaoyao;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.lanxiang.cheyaoyao.adapter.MyAdapter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.common.CYYApi;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.ActivityListData;
import com.lanxiang.cheyaoyao.utils.PermissionUtils;
import com.lanxiang.cheyaoyao.widget.LoadStateLayout;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Desc :  主界面
 * Created by WangDong on 2017/7/26.
 */
public class MainActivity extends AppCompatActivity implements MvpView<ActivityListData> {
    private static final String TAG = "MainActivity";
    @BindView(R.id.loadStateLayout)
    LoadStateLayout loadStateLayout;
    private String[] mStrings = {"sadfsaf", "asfsf", "safwef", "saf", "sfsghg", "afasgdgdfhfg", "ereryeryr"};
    private List<String> mData = Arrays.asList(mStrings);
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private MyAdapter mMyAdapter;
    private List<ActivityListData.DataBean.ItemsBean> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionUtils.checkPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        ButterKnife.bind(this);
        loadStateLayout.setEmptyView(R.layout.stateview_empty);
        loadStateLayout.setErrorView(R.layout.stateview_error);
        loadStateLayout.setLoadingView(R.layout.stateview_loading);
        loadStateLayout.setState(LoadStateLayout.STATE_LOADING);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                loadStateLayout.setState(LoadStateLayout.STATE_SUCCESS);
//                getNetData();
                loadData();
            }
        }, 2000);
        rvMain.setLayoutManager(new LinearLayoutManager(CheYaoYaoApp.getsContext(), LinearLayoutManager.VERTICAL, false));
        mMyAdapter = new MyAdapter(this);
        rvMain.setAdapter(mMyAdapter);
    }

    private void getNetData() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.retryOnConnectionFailure(true)
                .connectTimeout(12, TimeUnit.SECONDS).readTimeout(12, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CYYConstants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        CYYApi cyyApi = retrofit.create(CYYApi.class);
        Call<ActivityListData> activityList = cyyApi.getActivityList("0", "132", "1");
        activityList.enqueue(new Callback<ActivityListData>() {
            @Override
            public void onResponse(Call<ActivityListData> call, Response<ActivityListData> response) {
                if (response.body() != null && response.code() == 200) {
                    Gson gson = new Gson();
                    String json = gson.toJson(response);
                    Log.d(TAG, json);
                    mItems = response.body().data.items;
                    System.out.println("mItems:" + mItems);
                    if (mItems.size() > 0) {
                        if (mMyAdapter == null) {
//                            mMyAdapter = new MyAdapter(mItems);
                            rvMain.setAdapter(mMyAdapter);
                        }
                        loadStateLayout.setState(LoadStateLayout.STATE_SUCCESS);
                    } else {
                        loadStateLayout.setState(LoadStateLayout.STATE_EMPTY);
                    }
                }
            }

            @Override
            public void onFailure(Call<ActivityListData> call, Throwable t) {
                loadStateLayout.setState(LoadStateLayout.STATE_ERROR);
            }
        });
    }

    @Override
    public void showLoadingView() {
        loadStateLayout.setState(LoadStateLayout.STATE_LOADING);
    }

    @Override
    public void showErrorView() {
        loadStateLayout.setState(LoadStateLayout.STATE_ERROR);
    }

    @Override
    public void showSuccessEmptyView() {
        loadStateLayout.setState(LoadStateLayout.STATE_EMPTY);
    }

    @Override
    public void showSuccessContentView() {
        loadStateLayout.setState(LoadStateLayout.STATE_SUCCESS);
    }

    @Override
    public void setData(ActivityListData data) {
        mItems = data.data.items;
        mMyAdapter.setItems(mItems);
    }

    @Override
    public void loadData() {
        MainPresenter mainPresenter = new MainPresenter(new MainModelImp(), this);
        mainPresenter.getData("0", "132", "1");
    }
}
