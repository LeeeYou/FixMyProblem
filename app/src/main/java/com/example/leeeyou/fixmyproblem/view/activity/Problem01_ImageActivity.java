package com.example.leeeyou.fixmyproblem.view.activity;

import android.widget.ImageView;

import com.example.leeeyou.fixmyproblem.R;

/**
 * ImageView background和src体会
 */
public class Problem01_ImageActivity extends BaseDefaultActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    public void initViews() {
        ImageView image4 = (ImageView) findViewById(R.id.image4);
        image4.setImageResource(R.mipmap.play_pk_pic);
    }

}
