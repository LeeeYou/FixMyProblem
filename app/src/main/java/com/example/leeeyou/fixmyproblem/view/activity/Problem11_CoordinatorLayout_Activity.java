package com.example.leeeyou.fixmyproblem.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step1Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step2Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step3Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step4Activity;
import com.example.leeeyou.fixmyproblem.view.activity.coordinator.Step5Activity;

public class Problem11_CoordinatorLayout_Activity extends BaseDefaultActivity {


    private Button btn_01;
    private Button btn_02;
    private Button btn_03;
    private Button btn_04;
    private Button btn_05;

    @Override
    public int getLayoutId() {
        return R.layout.activity_problem11_coordinator_layout;
    }

    @Override
    public void initViews() {
        btn_01 = findView(R.id.btn_01);
        btn_02 = findView(R.id.btn_02);
        btn_03 = findView(R.id.btn_03);
        btn_04 = findView(R.id.btn_04);
        btn_05 = findView(R.id.btn_05);
    }

    @Override
    public void initListener() {
        setOnClick(btn_01);
        setOnClick(btn_02);
        setOnClick(btn_03);
        setOnClick(btn_04);
        setOnClick(btn_05);
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step1Activity.class));
                break;
            case R.id.btn_02:
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step2Activity.class));
                break;
            case R.id.btn_03:
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step3Activity.class));
                break;
            case R.id.btn_04:
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step4Activity.class));
                break;
            case R.id.btn_05:
                startActivity(new Intent(Problem11_CoordinatorLayout_Activity.this, Step5Activity.class));
                break;
        }
    }

}
