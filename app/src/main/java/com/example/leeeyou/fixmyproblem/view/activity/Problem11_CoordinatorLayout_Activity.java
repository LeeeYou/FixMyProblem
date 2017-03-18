package com.example.leeeyou.fixmyproblem.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step1Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step2Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step3Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step4Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step5Activity;

public class Problem11_CoordinatorLayout_Activity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem11_coordinator_layout);

        Button btn_01 = (Button) findViewById(R.id.btn_01);
        Button btn_02 = (Button) findViewById(R.id.btn_02);
        Button btn_03 = (Button) findViewById(R.id.btn_03);
        Button btn_04 = (Button) findViewById(R.id.btn_04);
        Button btn_05 = (Button) findViewById(R.id.btn_05);

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step1Activity.class));
            }
        });

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step2Activity.class));
            }
        });

        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step3Activity.class));
            }
        });

        btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step4Activity.class));
            }
        });

        btn_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step5Activity.class));
            }
        });


    }
}
