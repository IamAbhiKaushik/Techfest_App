package com.techfest.tf2017.abcd;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BlankAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String tabTitle[] = new String[]{"COMPETITION", "OZONE", "WORKSHOPS", "TECHNOHOLIX", "SUMMIT", "EXHIBITIONS", "INITIATIVES", "IDEATE", "LECTURES"};

    public BlankAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }

    @Override
    public Fragment getItem(int position) {

        return BlankFragment.newInstance(position + 1, tabTitle[position]);

    }

    @Override
    public int getCount() {
        return 9;
    }
}
