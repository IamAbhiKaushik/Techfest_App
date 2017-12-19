package com.techfest.tf2017.abcd;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.techfest.tf2017.abcd.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by amank on 2/12/17.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Activity context, ArrayList<Item> news) {

        super(context, 0, news);
    }


    @Override
    public View getView(int position, View currentView, ViewGroup parent) {

        View listItemView = currentView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
//        final ImageView = (ImageView) listItemView.findViewById(R.id.main_view);
        Item currentFile = getItem(position);
        ImageView iv1 = (ImageView) listItemView.findViewById(R.id.tv0);
        Picasso.with(getContext()).load(currentFile.getImageResource()).placeholder(R.drawable.no_internet).fit().centerCrop().into(iv1);

        TextView tv1 = (TextView) listItemView.findViewById(R.id.tv1);
        tv1.setText(currentFile.getEvent_name());
        TextView tv2 = (TextView) listItemView.findViewById(R.id.tv2);
        tv2.setText(currentFile.getTime_venue());
        return listItemView;
    }
}
