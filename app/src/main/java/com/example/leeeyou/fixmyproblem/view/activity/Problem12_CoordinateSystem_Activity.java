package com.example.leeeyou.fixmyproblem.view.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;

/**
 * 坐标体系
 */
public class Problem12_CoordinateSystem_Activity extends BaseActivity {

    TextView tv_desc1;
    StringBuilder mStringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem12_coordinate_system);

        tv_desc1 = (TextView) findViewById(R.id.tv_desc1);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.d("xxx", "屏幕高度" + metrics.heightPixels + "；屏幕宽度" + metrics.widthPixels);

        mStringBuilder.append("屏幕高度").append(metrics.heightPixels).append(";").append("屏幕宽度").append(metrics.widthPixels).append("\n");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        Log.d("xxx", "app内容区域高度" + rect.height() + "；app内容区域宽度" + rect.width());
        Log.d("xxx", "状态栏高度" + rect.top + "；状态栏宽度" + rect.right);

        mStringBuilder.append("app内容区域高度").append(rect.height()).append(";").append("app内容区域宽度").append(rect.width()).append("\n");
        mStringBuilder.append("状态栏高度").append(rect.top).append(";").append("状态栏宽度").append(rect.right).append("\n");

        tv_desc1.setText(mStringBuilder.toString());
    }

}
