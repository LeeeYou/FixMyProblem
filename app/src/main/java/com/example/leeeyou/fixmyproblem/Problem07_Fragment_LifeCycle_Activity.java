package com.example.leeeyou.fixmyproblem;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.leeeyou.fixmyproblem.fragment.LifeCycle01Fragment;
import com.example.leeeyou.fixmyproblem.fragment.LifeCycle02Fragment;

/**
 * fragment生命周期
 */
public class Problem07_Fragment_LifeCycle_Activity extends BaseActivity {

    private LifeCycle01Fragment lifeCycle01Fragment;
    private LifeCycle02Fragment lifeCycle02Fragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_cycle);

//        replaceWay();

        addWay();
    }

    /* replace方式 观察fragment生命周期 */
    private void replaceWay() {
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();

                lifeCycle01Fragment = (LifeCycle01Fragment) getSupportFragmentManager().findFragmentByTag("LifeCycle01Fragment");

                hideFragment(fragmentTransaction);

                if (lifeCycle01Fragment == null) {
                    lifeCycle01Fragment = new LifeCycle01Fragment();
                    fragmentTransaction.replace(R.id.container, lifeCycle01Fragment, "LifeCycle01Fragment");
                } else {
                    fragmentTransaction.show(lifeCycle01Fragment);
                }

                fragmentTransaction.commit();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();

                lifeCycle02Fragment = (LifeCycle02Fragment) getSupportFragmentManager().findFragmentByTag("LifeCycle02Fragment");

                hideFragment(fragmentTransaction);

                if (lifeCycle02Fragment == null) {
                    lifeCycle02Fragment = new LifeCycle02Fragment();
                    fragmentTransaction.replace(R.id.container, lifeCycle02Fragment, "LifeCycle02Fragment");
                } else {
                    fragmentTransaction.show(lifeCycle02Fragment);
                }

                fragmentTransaction.commit();
            }
        });
    }

    /* add方式 观察fragment生命周期 */
    private void addWay() {

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注意调用hide和show方法的fragmentTransaction需要为同一个引用
                //在hideFragment方法中调用getSupportFragmentManager().beginTransaction().hide不起作用

                fragmentTransaction = getSupportFragmentManager().beginTransaction();

                hideFragment(fragmentTransaction);

                lifeCycle01Fragment = (LifeCycle01Fragment) getSupportFragmentManager().findFragmentByTag("LifeCycle01Fragment");

                if (lifeCycle01Fragment == null) {
                    lifeCycle01Fragment = new LifeCycle01Fragment();
                    fragmentTransaction.add(R.id.container, lifeCycle01Fragment, "LifeCycle01Fragment");
                    fragmentTransaction.addToBackStack(null);
                } else {
                    fragmentTransaction.show(lifeCycle01Fragment);
                }

                fragmentTransaction.commit();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();

                hideFragment(fragmentTransaction);

                lifeCycle02Fragment = (LifeCycle02Fragment) getSupportFragmentManager().findFragmentByTag("LifeCycle02Fragment");

                if (lifeCycle02Fragment == null) {
                    lifeCycle02Fragment = new LifeCycle02Fragment();
                    fragmentTransaction.add(R.id.container, lifeCycle02Fragment, "LifeCycle02Fragment");
                    fragmentTransaction.addToBackStack(null);
                } else {
                    fragmentTransaction.show(lifeCycle02Fragment);
                }

                fragmentTransaction.commit();
            }
        });
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (lifeCycle01Fragment != null) {
            fragmentTransaction.hide(lifeCycle01Fragment);
        }

        if (lifeCycle02Fragment != null) {
            fragmentTransaction.hide(lifeCycle02Fragment);
        }
    }

}

