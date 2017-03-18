package com.example.leeeyou.fixmyproblem.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leeeyou.fixmyproblem.R;

/**
 * Created by leeeyou on 16/8/31.
 * <p>
 * 事件冲突案例默认的Fragment
 */
public class PageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_sliding_conflict, null);
        return inflate;
    }

}
