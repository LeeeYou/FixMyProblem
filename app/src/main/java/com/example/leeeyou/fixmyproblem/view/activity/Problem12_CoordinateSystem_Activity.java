package com.example.leeeyou.fixmyproblem.view.activity;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;

import static com.example.leeeyou.fixmyproblem.R.id.webView;

/**
 * 坐标体系
 */
public class Problem12_CoordinateSystem_Activity extends BaseDefaultActivity {

    TextView mTv;
    WebView mWebView;
    StringBuilder mStringBuilder = new StringBuilder();

    @Override
    public int getLayoutId() {
        return R.layout.activity_problem12_coordinate_system;
    }

    @Override
    public void initViews() {
        mTv = findView(R.id.tv_desc1);
        mWebView = findView(webView);
    }

    @Override
    public void initData() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.loadUrl("http://leeeyou.xyz/2016/01/22/blog-2016-01-22-Android%E5%BC%80%E5%8F%91%E4%B8%AD%E5%BF%85%E5%A4%87%E7%9A%84%E5%9D%90%E6%A0%87%E4%BD%93%E7%B3%BB%E7%9F%A5%E8%AF%86/");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.d("xxx", "屏幕高度" + metrics.heightPixels + "；屏幕宽度" + metrics.widthPixels);

        mStringBuilder.setLength(0);
        mStringBuilder.append("屏幕高度").append(metrics.heightPixels).append(";").append("屏幕宽度").append(metrics.widthPixels).append("\n");

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        Log.d("xxx", "app内容区域高度" + rect.height() + "；app内容区域宽度" + rect.width());
        Log.d("xxx", "状态栏高度" + rect.top + "；状态栏宽度" + rect.right);

        mStringBuilder.append("app内容区域高度").append(rect.height()).append(";").append("app内容区域宽度").append(rect.width()).append("\n");
        mStringBuilder.append("状态栏高度").append(rect.top).append(";").append("状态栏宽度").append(rect.right).append("\n");

        mTv.setText(mStringBuilder.toString());
    }

}
