package com.example.nautatvanavlakha.abcd;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by amank on 3/12/17.
 */

public class BlankAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String tabTitle[] = new String[]{"COMPETETION", "TECHNOHOLIX", "IDEATE", "WORKSHOPS", "INITIATIVES", "OZONE", "SUMMIT", "LECTURES", "EXHIBITIONS", "WORLD MUN", "CYCLOTHON", "SPONSERS"};

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
        return 12;
    }
}


//        if(position == 0){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 1){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 2){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 3){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 4){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 5){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 6){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 7){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 8){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 9){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else if(position == 10){
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        } else {
//            return BlankFragment.newInstance(position+1,tabTitle[position]);
//        }