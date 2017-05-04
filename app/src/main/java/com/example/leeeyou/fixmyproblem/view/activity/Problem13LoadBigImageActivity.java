package com.example.leeeyou.fixmyproblem.view.activity;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.custom.BigImageView;

import java.io.IOException;
import java.io.InputStream;

public class Problem13LoadBigImageActivity extends BaseDefaultActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_problem13_load_big_image;
    }

    @Override
    public void initViews() {
        BigImageView bigImageView = findView(R.id.bigImageView);
        try {
            InputStream open = getAssets().open("world.jpg");
            bigImageView.setImageInputStream(open);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
