package com.example.leeeyou.fixmyproblem.coordinator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.custom_view.StickyNavLayout;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class Step4Activity extends AppCompatActivity {

    private PtrClassicFrameLayout ptrFrame;
    private StickyNavLayout mStickyNavLayout;

    private List<String> mDatas;

    private BaseQuickAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);

        mStickyNavLayout = (StickyNavLayout) findViewById(R.id.activity_problem11_coordinator_layout_);
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
                        for (int i = 0; i < 2; i++) {
                            mDatas.add(0, "New Data " + i);
                        }

                        if (mAdapter != null) {
                            mAdapter.notifyDataSetChanged();
                        }

                        ptrFrame.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return mStickyNavLayout.getScrollY() == 0;
            }
        });
    }

    private void initRecyclerView() {
        RecyclerView recycylerView = (RecyclerView) findViewById(R.id.id_stickynavlayout_viewpager);
        recycylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new BaseQuickAdapter<String>(R.layout.item_coordinator_layout, mDatas) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, String s) {
                ((TextView) baseViewHolder.getView(R.id.tv)).setText(s);
            }
        };
        recycylerView.setAdapter(mAdapter);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            mDatas.add(" RecyclerView --> " + i);
        }
    }

}
