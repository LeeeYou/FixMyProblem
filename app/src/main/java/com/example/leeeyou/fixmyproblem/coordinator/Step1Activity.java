package com.example.leeeyou.fixmyproblem.coordinator;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;

public class Step1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem11_coordinator_layout_1);

        step_1();
    }

    private void step_1() {
        TextView tv_dependent = (TextView) findViewById(R.id.tv_dependent);
        tv_dependent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 5);
            }
        });
    }
}
