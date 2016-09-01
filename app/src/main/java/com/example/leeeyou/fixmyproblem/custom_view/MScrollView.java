package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by leeeyou on 16/6/7.
 * <p>
 * 内部法处理事件冲突时,自定义的ScrollView
 */
public class MScrollView extends ScrollView {
    int distance;

    public MScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        distance = (int) (context.getResources().getDisplayMetrics().density * 400);
    }

    float dx, dy;
    float downX, downY;
    float moveX, moveY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getRawX();
                downY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = ev.getRawX();
                moveY = ev.getRawY();

                dx = Math.abs(moveX - downX);
                dy = Math.abs(moveY - downY);

                //水平滑动,事件给到父控件
                if (dx > dy) {
//                if ((Math.abs(ev.getY()) >= distance || getScrollY() >= distance || ev.getY() == 0) && dx > dy) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                //垂直滑动,事件给到父控件
                if (dy > dx) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}