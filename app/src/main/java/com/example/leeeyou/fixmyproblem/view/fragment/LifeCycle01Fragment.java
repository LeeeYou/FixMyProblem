package com.example.leeeyou.fixmyproblem.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.leeeyou.fixmyproblem.R;

/**
 * Created by leeeyou on 16/8/31.
 * <p>
 */
public class LifeCycle01Fragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_life_cycle_01, null);

        Button btn_1 = (Button) inflate.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

                hideFragment();

                LifeCycle02Fragment lifeCycle02Fragment = (LifeCycle02Fragment) getActivity().getSupportFragmentManager().findFragmentByTag("LifeCycle02Fragment");

                if (lifeCycle02Fragment == null) {
                    lifeCycle02Fragment = new LifeCycle02Fragment();
                    fragmentTransaction.add(R.id.container, lifeCycle02Fragment, "LifeCycle02Fragment");
                } else {
                    fragmentTransaction.show(lifeCycle02Fragment);
                }

                fragmentTransaction.commit();
            }
        });

        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onCreateView");

        return inflate;
    }

    private void hideFragment() {
        LifeCycle01Fragment lifeCycle01Fragment = (LifeCycle01Fragment) getActivity().getSupportFragmentManager().findFragmentByTag("LifeCycle01Fragment");
        getActivity().getSupportFragmentManager().beginTransaction().hide(lifeCycle01Fragment);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onDetach");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("fragment lifecycle", this.getClass().getSimpleName() + " onSaveInstanceState");
    }

}
