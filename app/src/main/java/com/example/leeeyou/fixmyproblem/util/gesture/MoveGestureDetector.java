package com.example.leeeyou.fixmyproblem.util.gesture;

import android.graphics.PointF;
import android.view.MotionEvent;

/**
 * Created by leeeyou on 2017/5/8.
 */

public class MoveGestureDetector extends BaseGestureDetector {

    //用于记录最终结果，并返回
    private PointF mExternalPointer = new PointF();

    private OnMoveGestureListener mListener;

    public MoveGestureDetector(OnMoveGestureListener listener) {
        this.mListener = listener;
    }

    @Override
    void handleInProgressEvent(MotionEvent event) {
        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mListener.onMoveEnd(this);
                resetState();
                break;
            case MotionEvent.ACTION_MOVE:
                updateStateByEvent(event);
                boolean update = mListener.onMove(this);
                if (update) {
                    mPreMotionEvent.recycle();
                    mPreMotionEvent = MotionEvent.obtain(event);
                }
                break;

        }
    }

    @Override
    void handleStartProgressEvent(MotionEvent event) {
        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_DOWN:
                resetState();//防止没有接收到CANCEL or UP ,保险起见
                mPreMotionEvent = MotionEvent.obtain(event);
                updateStateByEvent(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mGestureInProgress = mListener.onMoveBegin(this);
                break;
        }
    }

    @Override
    protected void updateStateByEvent(MotionEvent event) {
        final MotionEvent prev = mPreMotionEvent;

        PointF mPrePointer = calculateFocalPointer(prev);
        PointF mCurrentPointer = calculateFocalPointer(event);

        //Log.e("TAG", mPrePointer.toString() + " ,  " + mCurrentPointer);

        //上一次的手指数和当前手指数不同的时候则跳过这一次的MotionEvent
        boolean mSkipThisMoveEvent = prev.getPointerCount() != event.getPointerCount();

//        Log.e("TAG", "mSkipThisMoveEvent = " + mSkipThisMoveEvent);

        //这里得到的是最后移动的距离
        mExternalPointer.x = mSkipThisMoveEvent ? 0 : mCurrentPointer.x - mPrePointer.x;
        mExternalPointer.y = mSkipThisMoveEvent ? 0 : mCurrentPointer.y - mPrePointer.y;
//        Log.e("TAG", "mExternalPointer.x--" + mExternalPointer.x);
//        Log.e("TAG", "mExternalPointer.y--" + mExternalPointer.y);
    }

    /**
     * 根据event计算多指中心点
     */
    private PointF calculateFocalPointer(MotionEvent event) {
        final int count = event.getPointerCount();
        float x = 0, y = 0;
        for (int i = 0; i < count; i++) {
            x += event.getX(i);
            y += event.getY(i);
        }

        x /= count;
        y /= count;

        return new PointF(x, y);
    }

    interface OnMoveGestureListener {
        boolean onMoveBegin(MoveGestureDetector detector);

        boolean onMove(MoveGestureDetector detector);

        void onMoveEnd(MoveGestureDetector detector);
    }

    public static class SimpleMoveGestureDetector implements OnMoveGestureListener {

        @Override
        public boolean onMoveBegin(MoveGestureDetector detector) {
            return true;
        }

        @Override
        public boolean onMove(MoveGestureDetector detector) {
            return false;
        }

        @Override
        public void onMoveEnd(MoveGestureDetector detector) {
        }
    }

    public float getMoveX() {
        return mExternalPointer.x;
    }

    public float getMoveY() {
        return mExternalPointer.y;
    }

}
