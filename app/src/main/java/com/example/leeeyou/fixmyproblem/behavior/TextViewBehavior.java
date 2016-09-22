package com.example.leeeyou.fixmyproblem.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by leeeyou on 16/9/22.
 */

public class TextViewBehavior extends CoordinatorLayout.Behavior<View> {

    public TextViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return target instanceof RecyclerView;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);

        float trY = 0;
        int childHeight;
        int childY = (int) (child.getTranslationY() - dy);

        if (dy > 0) {//scroll up
            childHeight = -child.getHeight();
            trY = Math.max(childY, childHeight);
        } else if (dy < 0) {//scroll down
            childHeight = 0;
            trY = Math.min(childY, childHeight);
        }

        consumed[1] = (int) (child.getTranslationY() - trY);

        child.setTranslationY(trY);
    }
}
