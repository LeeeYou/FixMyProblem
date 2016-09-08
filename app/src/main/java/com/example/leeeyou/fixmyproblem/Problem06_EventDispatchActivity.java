package com.example.leeeyou.fixmyproblem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * 事件传递
 */
public class Problem06_EventDispatchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dispatch);

        TextView btn_1 = (TextView) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("event dispatch", this.getClass().getSimpleName() + ".onClick");
            }
        });

        TextView btn_2 = (TextView) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}

