package com.example.leeeyou.fixmyproblem.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.vo.IndexView;
import com.example.leeeyou.fixmyproblem.util.UniversalAdapter;
import com.example.leeeyou.fixmyproblem.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.lv_index)
    ListView lv_index;

    @BindArray(R.array.index_title)
    String[] index_title;

    @BindArray(R.array.index_title_desc)
    String[] index_title_desc;

    UniversalAdapter<IndexView> adapter;
    List<IndexView> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTitle("FixProblem");

        initData();
        initAdapter();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new UniversalAdapter<IndexView>(this, dataList, R.layout.item_index_activity) {
                @Override
                public void convert(ViewHolder vh, IndexView item, final int position) {
                    vh.setText(R.id.tv_title, dataList.get(position).getTitle());
                    vh.setText(R.id.tv_title_desc, dataList.get(position).getDesc());

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
                            }
                        }
                    });
                }
            };
        }
        lv_index.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < index_title.length; i++) {
            IndexView data = new IndexView();
            data.setTitle(index_title[i]);
            data.setDesc(index_title_desc[i]);
            dataList.add(data);
        }
    }

}
