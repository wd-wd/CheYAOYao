package com.lanxiang.cheyaoyao.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Desc :LoadStateLayout，用来作为网络数据加载显示界面，可以设置加载中，空数据，加载成功，
 * 加载错误4种状态所显示的View
 * Created by WangDong on 2017/7/26.
 */

public class LoadStateLayout extends FrameLayout {
    public static final int STATE_LOADING = 0;//正在加载状态
    public static final int STATE_EMPTY = 1;//加载成功数据为空状态
    public static final int STATE_SUCCESS = 2;//加载成功数据不为空显示内容状态
    public static final int STATE_ERROR = 3;//加载失败状态

    private int mState = STATE_LOADING;//当前状态，默认是正在加载状态

    //四种状态显示的view
    private View mLoadingView;//正在加载时显示的View
    private View mEmptyView;//数据为空时显示的View
    private View mContentView;//加载成功时显示的View
    private View mErrorView;//加载错误时显示的View

    private LayoutInflater mInflater;//布局加载器

    public LoadStateLayout(@NonNull Context context) {
        this(context, null);
    }

    public LoadStateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadStateLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mInflater = LayoutInflater.from(getContext());
    }

    /**
     * 重写结束加载布局的方法，默认隐藏加载成功布局
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //当布局加载完成后只能有一个子布局，即四种布局的任意一个,子布局的个数大于1就抛非法的状态异常
        if (getChildCount() > 1) {
            throw new IllegalStateException(
                    /*"LoadStateLayout can host only one content child for STATE_SUCCESS!"*/
                    "加载状态布局对于成功状态只能允许一个子布局");
        }
        mContentView = getChildAt(0);
        //默认隐藏加载成功布局
        mContentView.setVisibility(GONE);
    }

    /**
     * 获取当前视图状态
     *
     * @return
     */
    public int getState() {
        return mState;
    }

    /**
     * 设置当前显示状态，更新显示视图
     *
     * @param state
     */
    public void setState(int state) {
        switch (state) {
            case STATE_LOADING:
            case STATE_EMPTY:
            case STATE_SUCCESS:
            case STATE_ERROR:
                mState = state;
                updateViewState();//更新视图状态，根据当前状态，显示对应的视图view
                break;
            default:
                throw new IllegalStateException("必须是STATE_LOADING,STATE_EMPTY,STATE_SUCCESS,STATE_ERROR状态中的一个！"
                        /*"must be one of STATE_LOADING,STATE_EMPTY,STATE_SUCCESS,STATE_ERROR !"*/
                );
        }
    }

    /**
     * 根据当前状态，显示对应的视图view
     */
    private void updateViewState() {
        //四种状态布局是否存在和是否显示的判断
        if (mLoadingView != null) {
            mLoadingView.setVisibility(mState == STATE_LOADING ? VISIBLE : GONE);
        }
        if (mEmptyView != null) {
            mEmptyView.setVisibility(mState == STATE_EMPTY ? VISIBLE : GONE);
        }
        if (mContentView != null) {
            mContentView.setVisibility(mState == STATE_SUCCESS ? VISIBLE : GONE);
        }
        if (mErrorView != null) {
            mErrorView.setVisibility(mState == STATE_ERROR ? VISIBLE : GONE);
        }
    }

    /**
     * 获取数据显示为空时的布局
     *
     * @return
     */
    public View getEmptyView() {
        return mEmptyView;
    }

    /**
     * 设置加载数据为空时显示的布局id
     *
     * @param layoutResId 布局id
     */
    public void setEmptyView(int layoutResId) {
        setEmptyView(mInflater.inflate(layoutResId, this, false));
    }

    /**
     * 设置加载数据为空时显示的View
     *
     * @param view
     */
    public void setEmptyView(View view) {
        removeView(mEmptyView);
        mEmptyView = view;
        addStateView(view);//添加状态跟布局rootView，默认隐藏
        updateViewState();
    }
    /**
     * 获取加载错误适合显示的View
     *
     * @return
     */
    public View getErrorView() {
        return mErrorView;
    }

    /**
     * 设置加载数据错误时显示的布局id
     *
     * @param layoutResId
     */
    public void setErrorView(int layoutResId) {
        setErrorView(mInflater.inflate(layoutResId, this, false));
    }

    /**
     * 设置加载数据错误时显示的View
     *
     * @param view
     */
    public void setErrorView(View view) {
        removeView(mErrorView);
        mErrorView = view;
        addStateView(view);
        updateViewState();
    }

    /**
     * 获取显示数据的View
     *
     * @return
     */
    public View getContentView() {
        return mContentView;
    }


    /**
     * 获取加载时显示的View
     *
     * @return
     */
    public View getLoadingView() {
        return mLoadingView;
    }

    /**
     * 设置加载数据错误时显示的布局id
     *
     * @param layoutResId
     */
    public void setLoadingView(int layoutResId) {
        setLoadingView(mInflater.inflate(layoutResId, this, false));
    }

    /**
     * 设置加载数据错误时显示的View
     *
     * @param view
     */
    public void setLoadingView(View view) {
        removeView(mLoadingView);
        mLoadingView = view;
        addStateView(view);
        updateViewState();
    }

    /**
     * 添加状态跟布局rootView，初始隐藏
     *
     * @param view
     */
    private void addStateView(View view) {
        if (view != null) {
            //如果默认没有LayoutParams或者不是FrameLayout.LayoutParams,重新生成一个
            ViewGroup.LayoutParams defaultParams = view.getLayoutParams();
            if (defaultParams==null||!(defaultParams instanceof ViewGroup.LayoutParams)){
                defaultParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
            LayoutParams params = (LayoutParams) defaultParams;
            params.gravity = Gravity.CENTER;//居中显示
            view.setVisibility(GONE);
            addView(view,params);
        }
    }
}
