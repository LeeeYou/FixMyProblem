package com.example.leeeyou.fixmyproblem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.leeeyou.fixmyproblem.coordinator.Step1Activity;
import com.example.leeeyou.fixmyproblem.coordinator.Step2Activity;
import com.example.leeeyou.fixmyproblem.coordinator.Step3Activity;

public class Problem11_CoordinatorLayout_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem11_coordinator_layout);

        Button btn_01 = (Button) findViewById(R.id.btn_01);
        Button btn_02 = (Button) findViewById(R.id.btn_02);
        Button btn_03 = (Button) findViewById(R.id.btn_03);
        Button btn_04 = (Button) findViewById(R.id.btn_04);

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

//        btn_04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
}
