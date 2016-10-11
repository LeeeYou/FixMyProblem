package com.example.leeeyou.fixmyproblem.coordinator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.adapter.MultipleItemQuickAdapter;
import com.example.leeeyou.fixmyproblem.custom_view.StickyNavLayout;
import com.example.leeeyou.fixmyproblem.entity.MultipleItem;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class Step5Activity extends AppCompatActivity {

    private PtrClassicFrameLayout ptrFrame;
    private StickyNavLayout mStickyNavLayout;

    private List<MultipleItem> mDatas;

    private MultipleItemQuickAdapter mAdapter;

    private View notLoadingView;

    private static final int PAGESIZE = 10;

    private static final int TOTAL_COUNTER = 40;

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
                        mAdapter.openLoadMore(PAGE_SIZE);
                        mAdapter.removeAllFooterView();

                        if (mDatas != null) {
                            mDatas.clear();
                        } else {
                            mDatas = new ArrayList<>();
                        }

                        for (int i = 0; i < 2; i++) {
                            MultipleItem item = new MultipleItem(i % 3 == 0 ? MultipleItem.TEXT : MultipleItem.IMG, "New Data " + i);
                            mDatas.add(0, item);
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
        final RecyclerView recycylerView = (RecyclerView) findViewById(R.id.id_stickynavlayout_viewpager);
        recycylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new MultipleItemQuickAdapter(this, mDatas);

        recycylerView.setAdapter(mAdapter);

        mAdapter.openLoadAnimation();
        mAdapter.openLoadMore(PAGESIZE);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ptrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<MultipleItem> datas = new ArrayList<>(PAGESIZE);
                        for (int i = 0; i < PAGESIZE; i++) {
                            MultipleItem item = new MultipleItem(i % 3 == 0 ? MultipleItem.TEXT : MultipleItem.IMG, "Load More Data " + i);
                            datas.add(item);
                        }

                        mAdapter.addData(datas);

                        if (mAdapter.getData().size() >= TOTAL_COUNTER) {
                            mAdapter.loadComplete();
                            if (notLoadingView == null) {
                                notLoadingView = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) recycylerView.getParent(), false);
                            }
                            mAdapter.addFooterView(notLoadingView);
                        }
                    }
                }, 1500);
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MultipleItem item = new MultipleItem(i % 3 == 0 ? MultipleItem.TEXT : MultipleItem.IMG, " RecyclerView --> " + i);
            mDatas.add(item);
        }
    }

}
