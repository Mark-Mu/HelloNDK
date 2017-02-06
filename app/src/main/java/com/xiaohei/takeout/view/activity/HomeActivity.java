package com.xiaohei.takeout.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaohei.takeout.R;
import com.xiaohei.takeout.view.fragment.HomeFragment;
import com.xiaohei.takeout.view.fragment.MeFragment;
import com.xiaohei.takeout.view.fragment.MoreFragment;
import com.xiaohei.takeout.view.fragment.OrderFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeActivity extends BaseActivity {

    @InjectView(R.id.home_fragment)
    FrameLayout mHomeFragment;
    @InjectView(R.id.home_tabs)
    LinearLayout mHomeTabs;
    @InjectView(R.id.activity_home)
    LinearLayout mActivityHome;
    private int mCurrentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        mCurrentTab = 0;
        initTab();
        initStatusBar(Color.parseColor("#39AEFF"));

    }



    private void initTab() {
        final int childCount = mHomeTabs.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final int cur = i;
            FrameLayout child = (FrameLayout) mHomeTabs.getChildAt(i);
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCurrentTab = cur;
                    selectTabIndex(childCount);
                }
            });
        }

        selectTabIndex(childCount);
    }


    private void selectTabIndex(int childCount) {

        for (int i = 0; i < childCount; i++) {
            FrameLayout child = (FrameLayout) mHomeTabs.getChildAt(i);
            ImageView iv_child0 = (ImageView) child.getChildAt(0);
            TextView tv_child1 = (TextView) child.getChildAt(1);
            if(mCurrentTab == i){
                iv_child0.setEnabled(false);
                tv_child1.setEnabled(false);
            }else{
                iv_child0.setEnabled(true);
                tv_child1.setEnabled(true);
            }
        }
        // 切换Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment,mFragments[mCurrentTab]).commit();
    }

    Fragment[] mFragments = new Fragment[]{
            new HomeFragment(),
            new OrderFragment(),
            new MeFragment(),
            new MoreFragment()
    };
}
