package com.example.leeeyou.fixmyproblem.view.activity;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * shape 资源整理
 * <p>
 * 实心圆角框
 * 空心圆角框
 * <p>
 * 实心圆形图
 * 空心圆形图
 * <p>
 * 点
 * <p>
 * 水平线
 * 垂直线
 * <p>
 * 带按下效果的圆角框
 */
public class Problem04_ShapeSourceActivity extends BaseDefaultActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_shape_source;
    }

    @Override
    public void initData() {
        EventBus.getDefault().postSticky("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().post(new MessageEvent("Problem04_ShapeSourceActivity 测试EventBus发送事件"));
    }

}
