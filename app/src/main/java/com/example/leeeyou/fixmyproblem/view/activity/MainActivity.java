package com.example.leeeyou.fixmyproblem.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.vo.IndexView;
import com.example.leeeyou.fixmyproblem.util.UniversalAdapter;
import com.example.leeeyou.fixmyproblem.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseDefaultActivity {

    ListView mListView;

    String[] mIndexTitleList;
    String[] mIndexTitleDescList;

    UniversalAdapter<IndexView> mAdapter;
    List<IndexView> mDataList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        setTitle("FixProblem");
        mListView = findView(R.id.lv_index);
    }

    @Override
    public void initData() {
        mIndexTitleList = getResources().getStringArray(R.array.index_title);
        mIndexTitleDescList = getResources().getStringArray(R.array.index_title_desc);

        for (int i = 0; i < mIndexTitleList.length; i++) {
            IndexView data = new IndexView();
            data.setTitle(mIndexTitleList[i]);
            data.setDesc(mIndexTitleDescList[i]);
            mDataList.add(data);
        }

        initAdapter();
    }

    private void initAdapter() {
        if (mAdapter == null) {
            mAdapter = new UniversalAdapter<IndexView>(this, mDataList, R.layout.item_index_activity) {
                @Override
                public void convert(ViewHolder vh, IndexView item, final int position) {
                    vh.setText(R.id.tv_title, mDataList.get(position).getTitle());
                    vh.setText(R.id.tv_title_desc, mDataList.get(position).getDesc());

                    vh.setOnClickListener(R.id.ll_item, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (position) {
                                case 0:
                                    startActivity(new Intent(MainActivity.this, Problem01_ImageActivity.class));
                                    break;
                                case 1:
                                    startActivity(new Intent(MainActivity.this, Problem02_GlideActivity.class));
                                    break;
                                case 2:
                                    startActivity(new Intent(MainActivity.this, Problem03_SlidingConflictActivity.class));
                                    break;
                                case 3:
                                    startActivity(new Intent(MainActivity.this, Problem04_ShapeSourceActivity.class));
                                    break;
                                case 4:
                                    startActivity(new Intent(MainActivity.this, Problem05_EventBusActivity.class));
                                    break;
                                case 5:
                                    startActivity(new Intent(MainActivity.this, Problem06_EventDispatchActivity.class));
                                    break;
                                case 6:
                                    startActivity(new Intent(MainActivity.this, Problem07_Fragment_LifeCycle_Activity.class));
                                    break;
                                case 7:
                                    startActivity(new Intent(MainActivity.this, Problem08_Math_Activity.class));
                                    break;
                                case 8:
                                    startActivity(new Intent(MainActivity.this, Problem09_ViewDragHelper_Activity.class));
                                    break;
                                case 9:
                                    startActivity(new Intent(MainActivity.this, Problem10_JSONArray_Activity.class));
                                    break;
                                case 10:
                                    startActivity(new Intent(MainActivity.this, Problem11_CoordinatorLayout_Activity.class));
                                    break;
                                case 11:
                                    startActivity(new Intent(MainActivity.this, Problem12_CoordinateSystemActivity.class));
                                    break;
                                case 12:
                                    startActivity(new Intent(MainActivity.this, Problem13_LoadBigImageActivity.class));
                                    break;
                            }
                        }
                    });
                }
            };
        }
        mListView.setAdapter(mAdapter);
    }

}

