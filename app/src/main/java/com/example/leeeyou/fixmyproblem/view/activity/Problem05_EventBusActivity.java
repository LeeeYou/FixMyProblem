package com.example.leeeyou.fixmyproblem.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.event.MessageEvent;
import com.example.leeeyou.fixmyproblem.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * EventBus
 * <p>
 * 1 两个EventBus实例各自发送消息
 * 2 EventBus粘性事件的使用场景
 */
public class Problem05_EventBusActivity extends BaseActivity {

    private EventBus mNewEventBus;
    private Button mBtnPost1;
    private Button mBtnPost2;
    private Button mBtnPost3;
    private Button mBtnPost4;

    @Override
    public int getLayoutId() {
        return R.layout.activity_event_bus;
    }

    @Override
    public void initViews() {
        mBtnPost1 = findView(R.id.btn_post_1);
        mBtnPost2 = findView(R.id.btn_post_2);
        mBtnPost3 = findView(R.id.btn_post_3);
        mBtnPost4 = findView(R.id.btn_post_4);
    }

    @Override
    public void initListener() {
        setOnClick(mBtnPost1);
        setOnClick(mBtnPost2);
        setOnClick(mBtnPost3);
        setOnClick(mBtnPost4);
    }

    @Override
    public void initData() {
        mNewEventBus = EventBus.builder().build();
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_post_1:
                EventBus.getDefault().post(new MessageEvent("默认EventBus实例发来的消息"));
                break;
            case R.id.btn_post_2:
                if (!mNewEventBus.isRegistered(Problem05_EventBusActivity.this)) {
                    mNewEventBus.register(Problem05_EventBusActivity.this);
                }
                break;
            case R.id.btn_post_3:
                //粘性事件:就是在事件发送之后,再订阅该事件也能收到该事件，跟黏性广播类似。
                mNewEventBus.postSticky(new StickyEvent("自定义EventBus实例发送的粘性事件"));
                break;
            case R.id.btn_post_4:
                mNewEventBus.unregister(Problem05_EventBusActivity.this);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEvent(StickyEvent message) {
        Toast.makeText(this, message.message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNewEventBus.unregister(this);
    }
}

