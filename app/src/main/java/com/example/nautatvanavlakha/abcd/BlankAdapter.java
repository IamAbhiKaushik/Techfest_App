package com.example.nautatvanavlakha.abcd;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BlankAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String tabTitle[] = new String[]{"COMPETETION", "OZONE", "WORKSHOPS", "TECHNOHOLIX", "SUMMIT", "EXHIBITIONS", "INITIATIVES", "IDEATE", "LECTURES"};

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


//        if(position == 0){
//            return Blanosition == 1){
//            return kFragment.newInstance(position+1,tabTitle[position]);
//        } else if(pBlankFragment.newInstance(position+1,tabTitle[position]);
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
