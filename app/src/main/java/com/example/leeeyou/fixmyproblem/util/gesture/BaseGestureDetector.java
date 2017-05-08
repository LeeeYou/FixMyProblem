package com.example.leeeyou.fixmyproblem.util.gesture;

import android.view.MotionEvent;

/**
 * Created by leeeyou on 2017/5/8.
 */

public abstract class BaseGestureDetector {
    boolean mGestureInProgress;

    MotionEvent mPreMotionEvent;
    private MotionEvent mCurrentMotionEvent;

    public boolean onTouchEvent(MotionEvent event) {
        if (!mGestureInProgress) {
            handleStartProgressEvent(event);
        } else {
            handleInProgressEvent(event);
        }

        return true;
    }

    abstract void handleInProgressEvent(MotionEvent event);

    abstract void handleStartProgressEvent(MotionEvent event);

    protected abstract void updateStateByEvent(MotionEvent event);

    void resetState() {
        if (mPreMotionEvent != null) {
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }
        if (mCurrentMotionEvent != null) {
            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent = null;
        }
        mGestureInProgress = false;
    }

}
