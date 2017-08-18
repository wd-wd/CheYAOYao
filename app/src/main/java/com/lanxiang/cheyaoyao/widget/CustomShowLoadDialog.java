package com.lanxiang.cheyaoyao.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.R;

/**
 * Desc :悬浮加载动画
 * Created by WangDong on 2017/8/18.
 */

public class CustomShowLoadDialog extends Dialog {
    private  String content;
    public CustomShowLoadDialog(Context context,String content) {
        super(context, R.style.cyy_CustomShowLoadDialog);
        this.content = content;
        initView();
    }
    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (CustomShowLoadDialog.this.isShowing())
                    CustomShowLoadDialog.this.dismiss();
                break;
        }
        return true;
    }

    private void initView() {
        setContentView(R.layout.load_dialog_view);
        ((TextView)findViewById(R.id.tvcontent)).setText(content);
        setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha=0.9f;
        getWindow().setAttributes(attributes);
        setCancelable(false);
    }
}
