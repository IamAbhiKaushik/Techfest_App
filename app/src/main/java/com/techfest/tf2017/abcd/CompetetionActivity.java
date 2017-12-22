package com.techfest.tf2017.abcd;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.techfest.tf2017.abcd.R;
import com.techfest.tf2017.abcd.BlankFragment;


public class CompetetionActivity extends AppCompatActivity {
    public BottomSheetBehavior behavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager);
        final int i = getIntent().getExtras().getInt("_ID");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        BlankAdapter adapter = new BlankAdapter(CompetetionActivity.this, getSupportFragmentManager());
        Log.e("i", i + "");
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.setCurrentItem(i, true);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

    }
}
