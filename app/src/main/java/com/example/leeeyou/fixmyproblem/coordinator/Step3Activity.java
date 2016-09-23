package com.example.leeeyou.fixmyproblem.coordinator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leeeyou.fixmyproblem.R;

import java.util.ArrayList;
import java.util.List;

public class Step3Activity extends AppCompatActivity {

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem11_coordinator_layout_3);

        step_3();
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
            return new MyViewHolder(LayoutInflater.from(Step3Activity.this).inflate(R.layout.item_coordinator_layout, parent, false));
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

    private void step_3() {
        initData();

        RecyclerView recycylerView = (RecyclerView) findViewById(R.id.id_stickynavlayout_viewpager);
        recycylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycylerView.setAdapter(new Step3Activity.MyAdapter());
    }

}
