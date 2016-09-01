package com.example.leeeyou.fixmyproblem.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by leeeyou on 16/6/2.
 *
 * 可嵌入ScrollView或者ListView中
 */
public class MListView extends ListView {
    public MListView(Context context) {
        super(context);
    }

    public MListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
