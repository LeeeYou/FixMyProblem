package com.example.leeeyou.fixmyproblem.view.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.example.leeeyou.fixmyproblem.R;

/**
 * Glide 做圆形图片和圆角图片
 */
public class Problem02_GlideActivity extends BaseDefaultActivity {

    private ImageView img01;
    private ImageView img02;
    private ImageView img03;

    @Override
    public int getLayoutId() {
        return R.layout.activity_glide;
    }

    @Override
    public void initViews() {
        img01 = findView(R.id.img01);
        img02 = findView(R.id.img02);
        img03 = findView(R.id.img03);
    }

    @Override
    public void initData() {
        String imageUrl = "https://github.com/LeeeYou/Img/blob/master/leeeyou/getScrollX.png?raw=true";


        //Glide.with(this).load(imageUrl).thumbnail(0.1f).into(img01);

        // play gif
        Glide.with(this).load(R.mipmap.pkq).into(img01);

        // round image
        Glide.with(this)
                .load(imageUrl)
                .crossFade()
                .transform(new GlideRoundTransform(this))
                .into(img02);

        // circle image
        Glide.with(this)
                .load(imageUrl)
                .crossFade()
                .transform(new GlideCircleTransform(this))
                .into(img03);
    }

    public class GlideCircleTransform extends BitmapTransformation {

        GlideCircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();

            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);

            float radius = size / 2f;
            canvas.drawCircle(radius, radius, radius, paint);

            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }

    public class GlideRoundTransform extends BitmapTransformation {

        private float radius = 0f;

        GlideRoundTransform(Context context) {
            this(context, 4);
        }

        GlideRoundTransform(Context context, int dp) {
            super(context);
            this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return roundCrop(pool, toTransform);
        }

        private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }

}
