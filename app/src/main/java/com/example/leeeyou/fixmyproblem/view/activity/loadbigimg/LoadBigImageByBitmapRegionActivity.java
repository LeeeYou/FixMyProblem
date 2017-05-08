package com.example.leeeyou.fixmyproblem.view.activity.loadbigimg;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.activity.BaseDefaultActivity;
import com.example.leeeyou.fixmyproblem.view.custom.BigImageView;

import java.io.IOException;
import java.io.InputStream;

public class LoadBigImageByBitmapRegionActivity extends BaseDefaultActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_load_big_img_by_bitmap_region;
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
