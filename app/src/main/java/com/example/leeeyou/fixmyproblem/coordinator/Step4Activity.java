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
import com.example.leeeyou.fixmyproblem.custom_view.StickyNavLayout;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class Step4Activity extends AppCompatActivity {

    private PtrClassicFrameLayout ptrFrame;
    private StickyNavLayout activity_problem11__coordinator_layout_;

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4_2);

        activity_problem11__coordinator_layout_ = (StickyNavLayout) findViewById(R.id.activity_problem11__coordinator_layout_);
        ptrFrame = (PtrClassicFrameLayout) findViewById(R.id.store_house_ptr_frame);

        initPullToRefresh();
        initData();
        initRecyclerView();
    }

    private void initPullToRefresh() {
        ptrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrame.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return activity_problem11__coordinator_layout_.getScrollY() == 0;
            }
        });
    }

    private void initRecyclerView() {
        RecyclerView recycylerView = (RecyclerView) findViewById(R.id.id_stickynavlayout_viewpager);
        recycylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycylerView.setAdapter(new Step4Activity.MyAdapter());
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            mDatas.add(" RecyclerView --> " + i);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<Step4Activity.MyAdapter.MyViewHolder> {
        @Override
        public Step4Activity.MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Step4Activity.MyAdapter.MyViewHolder(LayoutInflater.from(Step4Activity.this).inflate(R.layout.item_coordinator_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(Step4Activity.MyAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv);
            }
        }

    }

}
