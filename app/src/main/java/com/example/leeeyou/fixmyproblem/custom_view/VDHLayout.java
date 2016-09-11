package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class VDHLayout extends LinearLayout {
    private ViewDragHelper mDragger;

    private View mDragView;
    private View mAutoBackView;
    private View mEdgeTrackerView;

    private Point mAutoBackOriginPos = new Point();

    public VDHLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                Log.e("VDHLayout", "tryCaptureView");

                //mEdgeTrackerView禁止直接移动
                return child == mDragView || child == mAutoBackView;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                Log.e("VDHLayout", "clampViewPositionHorizontal");
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                Log.e("VDHLayout", "clampViewPositionVertical");
                return top;
            }

            @Override
            public void onViewCaptured(View capturedChild, int activePointerId) {
                Log.e("VDHLayout", "onViewCaptured");

                super.onViewCaptured(capturedChild, activePointerId);
            }

            @Override
            public void onViewDragStateChanged(int state) {
                Log.e("VDHLayout", "onViewDragStateChanged");

                super.onViewDragStateChanged(state);
            }

            //手指释放的时候回调
            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                Log.e("VDHLayout", "onViewReleased");

                //mAutoBackView手指释放时可以自动回去
                if (releasedChild == mAutoBackView) {
                    mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
                    invalidate();
                }
            }

            //在边界拖动时回调
            /*该方法可以绕过tryCaptureView，所以我们的tryCaptureView虽然并为返回true，但却不影响。*/
            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                Log.e("VDHLayout", "onEdgeDragStarted");

                mDragger.captureChildView(mEdgeTrackerView, pointerId);
            }

            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                Log.e("VDHLayout", "onEdgeTouched");

                super.onEdgeTouched(edgeFlags, pointerId);
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                Log.e("VDHLayout", "getViewHorizontalDragRange");

                return getMeasuredWidth() - child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                Log.e("VDHLayout", "getViewVerticalDragRange");

                return getMeasuredHeight() - child.getMeasuredHeight();
            }

        });
        mDragger.setEdgeTrackingEnabled(ViewDragHelper.EDGE_ALL);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.e("VDHLayout", "onInterceptTouchEvent");

        return mDragger.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("VDHLayout", "onTouchEvent");

        mDragger.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        Log.e("VDHLayout", "computeScroll");

        if (mDragger.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("VDHLayout", "onLayout");

        super.onLayout(changed, l, t, r, b);

        //记录AutoBackView的x和y坐标
        mAutoBackOriginPos.x = mAutoBackView.getLeft();
        mAutoBackOriginPos.y = mAutoBackView.getTop();
    }

    @Override
    protected void onFinishInflate() {
        Log.e("VDHLayout", "onFinishInflate");

        super.onFinishInflate();

        mDragView = getChildAt(0);
        mAutoBackView = getChildAt(1);
        mEdgeTrackerView = getChildAt(2);
    }
}