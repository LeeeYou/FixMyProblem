package com.example.leeeyou.fixmyproblem.view.activity;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.model.vo.IndexView;
import com.example.leeeyou.fixmyproblem.util.UniversalAdapter;
import com.example.leeeyou.fixmyproblem.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    UniversalAdapter<IndexView> adapter;
    List<IndexView> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] index_title = getResources().getStringArray(R.array.index_title);
        String[] index_title_desc = getResources().getStringArray(R.array.index_title_desc);


        for (int i = 0; i < index_title.length; i++) {
            IndexView data = new IndexView();
            data.setTitle(index_title[i]);
            data.setDesc(index_title_desc[i]);
            dataList.add(data);
        }

//        Button btn_problem_01 = (Button) findViewById(R.id.btn_problem_01);
//        btn_problem_01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem01_ImageActivity.class));
//            }
//        });
//
//        Button btn_problem_02 = (Button) findViewById(R.id.btn_problem_02);
//        btn_problem_02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem02_GlideActivity.class));
//            }
//        });
//
//        Button btn_problem_03 = (Button) findViewById(R.id.btn_problem_03);
//        btn_problem_03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem03_SlidingConflictActivity.class));
//            }
//        });
//
//        Button btn_problem_04 = (Button) findViewById(R.id.btn_problem_04);
//        btn_problem_04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem04_ShapeSourceActivity.class));
//            }
//        });
//
//        Button btn_problem_05 = (Button) findViewById(R.id.btn_problem_05);
//        btn_problem_05.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem05_EventBusActivity.class));
//            }
//        });
//
//        Button btn_problem_06 = (Button) findViewById(R.id.btn_problem_06);
//        btn_problem_06.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem06_EventDispatchActivity.class));
//            }
//        });
//
//        Button btn_problem_07 = (Button) findViewById(R.id.btn_problem_07);
//        btn_problem_07.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem07_Fragment_LifeCycle_Activity.class));
//            }
//        });
//
//        Button btn_problem_08 = (Button) findViewById(R.id.btn_problem_08);
//        btn_problem_08.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem08_Math_Activity.class));
//            }
//        });
//
//        Button btn_problem_09 = (Button) findViewById(R.id.btn_problem_09);
//        btn_problem_09.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem09_ViewDragHelper_Activity.class));
//            }
//        });
//
//        Button btn_problem_10 = (Button) findViewById(R.id.btn_problem_10);
//        btn_problem_10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem10_JSONArray_Activity.class));
//            }
//        });
//
//        Button btn_problem_11 = (Button) findViewById(R.id.btn_problem_11);
//        btn_problem_11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Problem11_CoordinatorLayout_Activity.class));
//            }
//        });

        if (adapter == null) {
            adapter = new UniversalAdapter<IndexView>(this, dataList, R.layout.item_index_activity) {
                @Override
                public void convert(ViewHolder vh, IndexView item, int position) {
                    vh.setText()
                }
            };
        }

        setListAdapter(adapter);

    }

}
