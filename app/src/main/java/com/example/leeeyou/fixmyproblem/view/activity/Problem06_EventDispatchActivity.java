package com.example.leeeyou.fixmyproblem.view.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;

/**
 * 事件传递
 */
public class Problem06_EventDispatchActivity extends BaseActivity {

    private TextView mBtn1;
    private TextView mBtn2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_event_dispatch;
    }

    @Override
    public void initViews() {
        mBtn1 = findView(R.id.btn_1);
        mBtn2 = findView(R.id.btn_2);

    }

    @Override
    public void initListener() {
        setOnClick(mBtn1);
        setOnClick(mBtn2);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                Log.e("event dispatch", this.getClass().getSimpleName() + ".onClick");
                break;
        }
    }

}

