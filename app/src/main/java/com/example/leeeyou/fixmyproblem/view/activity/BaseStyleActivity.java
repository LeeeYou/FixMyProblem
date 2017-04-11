package com.example.leeeyou.fixmyproblem.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.leeeyou.fixmyproblem.R;

import qiu.niorgai.StatusBarCompat;

/**
 * 基类 - 处理样式相关的问题
 */
public class BaseStyleActivity extends AppCompatActivity {
    private LinearLayout contentLayout;
    private Toolbar toolbar;

    private String[] status_bg_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status_bg_color = getResources().getStringArray(R.array.status_bg_color);
        initContentView();
        initTitleBar();
    }

    private void initTitleBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setToolbarBackgroundColor(getResources().getColor(R.color.status_bg_green));
    }

    private void initContentView() {
        ViewGroup content = (ViewGroup) findViewById(android.R.id.content);
        content.removeAllViews();
        contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        content.addView(contentLayout);
        LayoutInflater.from(this).inflate(R.layout.common_title_bar, contentLayout, true);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, contentLayout, true);
    }

    protected void setToolbarStyle() {
        String simpleName = getClass().getSimpleName();
        try {
            String title = simpleName.substring(0, simpleName.indexOf("_"));
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
                int bgColor = Color.parseColor(status_bg_color[Integer.parseInt(title.substring(title.lastIndexOf("m") + 1)) % status_bg_color.length]);
                setToolbarBackgroundColor(bgColor);
                StatusBarCompat.setStatusBarColor(this, bgColor);
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    protected void setToolbarBackgroundColor(int color) {
        toolbar.setBackgroundColor(color);
    }

}
