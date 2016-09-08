package com.example.leeeyou.fixmyproblem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_problem_01 = (Button) findViewById(R.id.btn_problem_01);
        btn_problem_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Problem01_ImageActivity.class));
            }
        });

        Button btn_problem_02 = (Button) findViewById(R.id.btn_problem_02);
        btn_problem_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Problem02_GlideActivity.class));
            }
        });


        Button btn_problem_03 = (Button) findViewById(R.id.btn_problem_03);
        btn_problem_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Problem03_SlidingConflictActivity.class));
            }
        });

        Button btn_problem_04 = (Button) findViewById(R.id.btn_problem_04);
        btn_problem_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Problem04_ShapeSourceActivity.class));
            }
        });

        Button btn_problem_05 = (Button) findViewById(R.id.btn_problem_05);
        btn_problem_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Problem05_EventBusActivity.class));
            }
        });

        Button btn_problem_06 = (Button) findViewById(R.id.btn_problem_06);
        btn_problem_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Problem06_EventDispatchActivity.class));
            }
        });


    }

}
