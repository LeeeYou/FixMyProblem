package com.example.leeeyou.fixmyproblem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * ImageView background和src体会
 */
public class Problem01_ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView image4 = (ImageView) findViewById(R.id.image4);
        image4.setImageResource(R.mipmap.play_pk_pic);
    }

}
