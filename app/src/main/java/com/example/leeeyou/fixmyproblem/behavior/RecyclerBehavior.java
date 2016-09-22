package com.example.leeeyou.fixmyproblem.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by leeeyou on 16/9/22.
 */
public class RecyclerBehavior extends CoordinatorLayout.Behavior<View> {
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof LinearLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int delta = (int) (dependency.getTranslationY() + dependency.getBottom());
        delta = delta - child.getTop();
        ViewCompat.offsetTopAndBottom(child, delta);
        return true;
    }

    public RecyclerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
