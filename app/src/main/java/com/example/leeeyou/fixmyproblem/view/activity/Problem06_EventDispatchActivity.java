package com.example.leeeyou.fixmyproblem.view.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 事件传递
 */
public class Problem06_EventDispatchActivity extends BaseDefaultActivity {

    private TextView mBtn1;
    private TextView mBtn2;
    private TextView tv_logcat;

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
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                Log.e("event dispatch", this.getClass().getSimpleName() + ".onClick");
                break;
            case R.id.btn_2:
                try {
                    Process process = Runtime.getRuntime().exec("logcat -d");
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));

                    StringBuilder log = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        log.append(line);
                    }
                    TextView tv = (TextView) findViewById(R.id.tv_logcat);
                    tv.setText(log.toString());
                } catch (IOException e) {
                }
                break;
        }
    }

}

