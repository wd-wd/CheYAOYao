package com.lanxiang.cheyaoyao.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.adapter.CircleAdapter;
import com.lanxiang.cheyaoyao.widget.gallery.GalleryLayoutManager;
import com.lanxiang.cheyaoyao.widget.gallery.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc :  聊天
 * Created by WangDong on 2017/8/3.
 */
public class ChatFragment extends Fragment {
    @BindView(R.id.rv_chat)
    RecyclerView rvChat;
    Unbinder unbinder;
    private List<String> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, null, false);
        unbinder = ButterKnife.bind(this, view);
        initListener();
        initData();
        return view;
    }

    private void initListener() {

    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 1;i<32;i++){
            mDatas.add("8月"+i+"日");
        }
        GalleryLayoutManager layoutManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        layoutManager.setItemTransformer(new ScaleTransformer());
        layoutManager.attach(rvChat,0);
        CircleAdapter circleAdapter = new CircleAdapter(mDatas);
        rvChat.setAdapter(circleAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
