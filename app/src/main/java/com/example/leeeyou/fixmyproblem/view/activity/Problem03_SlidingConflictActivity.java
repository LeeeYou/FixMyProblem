package com.example.leeeyou.fixmyproblem.view.activity;

import android.support.v4.view.ViewPager;

import com.example.leeeyou.fixmyproblem.R;
import com.example.leeeyou.fixmyproblem.view.fragment.PageFragment;
import com.example.leeeyou.fixmyproblem.view.fragment.PageSlidingConflictFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * 事件冲突案例
 */
public class Problem03_SlidingConflictActivity extends BaseDefaultActivity {

    private ViewPager mViewPager;
    private SmartTabLayout mViewPagerTab;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sliding_conflict;
    }

    @Override
    public void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
    }

    @Override
    public void initData() {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("title_A", PageFragment.class)
                .add("title_B", PageSlidingConflictFragment.class)
                .add("title_c", PageFragment.class)
                .add("title_D", PageFragment.class)
                .create());

        mViewPager.setAdapter(adapter);
        mViewPagerTab.setViewPager(mViewPager);
    }

}
