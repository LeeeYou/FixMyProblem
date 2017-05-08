package com.example.leeeyou.fixmyproblem.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.activity.loadbigimg.LoadBigImageByBitmapRegionActivity;
import com.example.leeeyou.fixmyproblem.view.activity.loadbigimg.LoadBigImageBySurfaceViewActivity;

public class Problem13_LoadBigImageActivity extends BaseDefaultActivity {

    private Button btn_big_img_01;
    private Button btn_big_img_02;

    @Override
    public int getLayoutId() {
        return R.layout.activity_problem13_load_big_image;
    }

    @Override
    public void initViews() {
        btn_big_img_01 = findView(R.id.btn_big_img_01);
        btn_big_img_02 = findView(R.id.btn_big_img_02);
    }

    @Override
    public void initListener() {
        setOnClick(btn_big_img_01);
        setOnClick(btn_big_img_02);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_big_img_01:
                startActivity(new Intent(Problem13_LoadBigImageActivity.this, LoadBigImageByBitmapRegionActivity.class));
                break;
            case R.id.btn_big_img_02:
                startActivity(new Intent(Problem13_LoadBigImageActivity.this, LoadBigImageBySurfaceViewActivity.class));
                break;
            default:
                break;
        }
    }
}
