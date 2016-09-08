package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by leeeyou on 16/9/8.
 */
public class OuterLayout extends LinearLayout {
    public OuterLayout(Context context) {
        super(context);
    }

    public OuterLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OuterLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".dispatchTouchEvent");
//        return false;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".onInterceptTouchEvent");
        return false;
//        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".onTouchEvent");
        return false;
//        return super.onTouchEvent(event);
    }

}
