package com.example.leeeyou.fixmyproblem.view.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by leeeyou on 2017/5/4.
 * <p>
 * 加载高清大图
 */
public class BigImageView extends View {
    private BitmapRegionDecoder mBitmapRegionDecoder;
    private int mImageWidth, mImageHeight;
    private final Rect mRect = new Rect();

    private static final BitmapFactory.Options mOption = new BitmapFactory.Options();

    private int downX, downY;

    static {
        mOption.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public BigImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setImageInputStream(InputStream is) {
        try {
            mBitmapRegionDecoder = BitmapRegionDecoder.newInstance(is, false);
            BitmapFactory.Options tempOption = new BitmapFactory.Options();
            tempOption.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, tempOption);
            mImageWidth = tempOption.outWidth;
            mImageHeight = tempOption.outHeight;

            requestLayout();
            invalidate();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        //默认直接显示图片的中心区域，可以自己去调节
        mRect.left = mImageWidth / 2 - width / 2;
        mRect.top = mImageHeight / 2 - height / 2;
        mRect.right = mRect.left + width;
        mRect.bottom = mRect.top + height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmapRegionDecoder == null) {
            return;
        }

        Bitmap bitmap = mBitmapRegionDecoder.decodeRegion(mRect, mOption);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (downX - event.getRawX());
                int dy = (int) (downY - event.getRawY());

                if (mImageWidth > getWidth()) {
                    mRect.offset(dx, 0);
                    checkWidth();
                    invalidate();
                }

                if (mImageHeight > getHeight()) {
                    mRect.offset(0, dy);
                    checkHeight();
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    private void checkHeight() {
        Rect rect = mRect;
        int imageHeight = mImageHeight;

        if (rect.bottom > imageHeight) {
            rect.bottom = imageHeight;
            rect.top = imageHeight - getHeight();
        }

        if (rect.top < 0) {
            rect.top = 0;
            rect.bottom = getHeight();
        }
    }

    private void checkWidth() {
        Rect rect = mRect;
        int imageWidth = mImageWidth;

        if (rect.right > imageWidth) {
            rect.right = imageWidth;
            rect.left = imageWidth - getWidth();
        }

        if (rect.left < 0) {
            rect.left = 0;
            rect.right = getWidth();
        }
    }
}
