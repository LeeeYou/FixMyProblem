package com.example.leeeyou.fixmyproblem.view.activity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        mNewEventBus = EventBus.builder().build();

        Button btn_post_1 = (Button) findViewById(R.id.btn_post_1);
        Button btn_post_2 = (Button) findViewById(R.id.btn_post_2);
        Button btn_post_3 = (Button) findViewById(R.id.btn_post_3);
        Button btn_post_4 = (Button) findViewById(R.id.btn_post_4);

        btn_post_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("默认EventBus实例发来的消息"));
            }
        });

        btn_post_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mNewEventBus.isRegistered(Problem05_EventBusActivity.this)) {
                    mNewEventBus.register(Problem05_EventBusActivity.this);
                }
            }
        });

        btn_post_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //粘性事件:就是在事件发送之后,再订阅该事件也能收到该事件，跟黏性广播类似。
                mNewEventBus.postSticky(new StickyEvent("自定义EventBus实例发送的粘性事件"));
            }
        });

        btn_post_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewEventBus.unregister(Problem05_EventBusActivity.this);
            }
        });

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

