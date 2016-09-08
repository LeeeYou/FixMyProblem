package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by leeeyou on 16/9/8.
 */

public class InnerLayout extends LinearLayout {
    public InnerLayout(Context context) {
        super(context);
    }

    public InnerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InnerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*体验事件的完整传递顺序。onInterceptTouchEvent return false; onTouchEvent return false;*/

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e("event dispatch", this.getClass().getSimpleName() + ".dispatchTouchEvent");
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.e("event dispatch", this.getClass().getSimpleName() + ".onInterceptTouchEvent");
//        return false;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e("event dispatch", this.getClass().getSimpleName() + ".onTouchEvent");
//        return false;
//    }


    /*-----------分隔线-------------*/

    /*体验事件被子控件拦截传递顺序。*/

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".dispatchTouchEvent");

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".onInterceptTouchEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".onTouchEvent");
        return true;
    }

}
