package com.example.leeeyou.fixmyproblem;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Problem11_CoordinatorLayout_Activity extends AppCompatActivity {
    private List<String> mDatas;

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

            }
        });

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        step_1();//customize Behavior, click
//        step_2();//customize Behavior, scroll
//        step_3();

    }

    private void step_2() {
        //nothing to do , ScrollBehavior can be observed
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

    private void step_3() {
        initData();

        RecyclerView recycylerView = (RecyclerView) findViewById(R.id.id_stickynavlayout_viewpager);
        recycylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycylerView.setAdapter(new MyAdapter());
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            mDatas.add(" RecyclerView --> " + i);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(Problem11_CoordinatorLayout_Activity.this).inflate(R.layout.item_coordinator_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv);
            }
        }

    }

}
