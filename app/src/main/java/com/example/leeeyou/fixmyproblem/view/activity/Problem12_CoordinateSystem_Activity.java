package com.example.leeeyou.fixmyproblem.view.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.leeeyou.fixmyproblem.R;

public class Problem12_CoordinateSystem_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem12_coordinate_system);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.d("xxx", "屏幕高度" + metrics.heightPixels + "；屏幕宽度" + metrics.widthPixels);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        Log.d("xxx", "app内容区域高度" + rect.height() + "；app内容区域宽度" + rect.width());
        Log.d("xxx", "状态栏高度" + rect.top + "；状态栏宽度" + rect.right);
    }

}
