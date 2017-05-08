package com.example.leeeyou.fixmyproblem.view.activity.loadbigimg;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.util.RandomAccessFileInputStream;
import com.example.leeeyou.fixmyproblem.view.custom.ImageSurfaceView;

import java.io.InputStream;

public class LoadBigImageBySurfaceViewActivity extends AppCompatActivity {

    private static final String TAG = "LoadBigImgActivity";
    private static final String KEY_X = "X";
    private static final String KEY_Y = "Y";
    private static final String KEY_FN = "FN";

    private ImageSurfaceView imageSurfaceView;
    private String filename = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_load_big_image_by_surface_view);
        imageSurfaceView = (ImageSurfaceView) findViewById(R.id.worldview);

        // Setup/restore state
        if (savedInstanceState != null
                && savedInstanceState.containsKey(KEY_X)
                && savedInstanceState.containsKey(KEY_Y)) {
            Log.d(TAG, "restoring state");
            int x = (Integer) savedInstanceState.get(KEY_X);
            int y = (Integer) savedInstanceState.get(KEY_Y);

            String fn = null;
            if (savedInstanceState.containsKey(KEY_FN))
                fn = (String) savedInstanceState.get(KEY_FN);

            try {
                if (fn == null || fn.length() == 0) {
                    imageSurfaceView.setInputStream(getAssets().open("world.jpg"));
                } else {
                    imageSurfaceView.setInputStream(new RandomAccessFileInputStream(fn));
                }
                imageSurfaceView.setViewport(new Point(x, y));
            } catch (java.io.IOException e) {
                Log.e(TAG, e.getMessage());
            }
        } else {
            // Centering the map to start
            Intent intent = getIntent();
            try {
                Uri uri = null;
                if (intent != null) {
                    uri = getIntent().getData();
                }

                InputStream is;
                if (uri != null) {
                    filename = uri.getPath();
                    is = new RandomAccessFileInputStream(uri.getPath());
                } else {
                    is = getAssets().open("world.jpg");
                }

                imageSurfaceView.setInputStream(is);
            } catch (java.io.IOException e) {
                Log.e(TAG, e.getMessage());
            }
            imageSurfaceView.setViewportCenter();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        imageSurfaceView.setViewport(new Point(imageSurfaceView.getWidth() / 2, imageSurfaceView.getHeight() / 2));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Point p = new Point();
        imageSurfaceView.getViewport(p);
        outState.putInt(KEY_X, p.x);
        outState.putInt(KEY_Y, p.y);
        if (filename != null) {
            outState.putString(KEY_FN, filename);
        }
        super.onSaveInstanceState(outState);
    }
}
