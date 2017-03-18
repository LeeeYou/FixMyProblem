package com.example.leeeyou.fixmyproblem.view.custom;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
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

    private GestureDetectorCompat simpleOnGestureListener;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".onInterceptTouchEvent");

        if (simpleOnGestureListener == null) {
            simpleOnGestureListener = new GestureDetectorCompat(getContext(), new MySimpleOnGestureListener());
        }

        simpleOnGestureListener.onTouchEvent(ev);

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("event dispatch", this.getClass().getSimpleName() + ".onTouchEvent");
        return true;
    }

    private class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e("OnGesture", "执行了 onScroll 方法");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.e("OnGesture", "执行了 onDown 方法");
            return super.onDown(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("OnGesture", "执行了 onSingleTapUp 方法");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.e("OnGesture", "执行了 onShowPress 方法");
            super.onShowPress(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.e("OnGesture", "执行了 onLongPress 方法");
            super.onLongPress(e);
        }

    }

}
