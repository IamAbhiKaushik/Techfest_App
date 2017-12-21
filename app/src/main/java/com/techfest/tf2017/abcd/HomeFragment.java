package com.techfest.tf2017.abcd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.techfest.tf2017.abcd.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout[] linearLayout = new LinearLayout[9];
        linearLayout[0] = (LinearLayout) rootView.findViewById(R.id.compi);
        linearLayout[1] = (LinearLayout) rootView.findViewById(R.id.ozone);
        linearLayout[2] = (LinearLayout) rootView.findViewById(R.id.workshop);
        linearLayout[3] = (LinearLayout) rootView.findViewById(R.id.technoholix);
        linearLayout[4] = (LinearLayout) rootView.findViewById(R.id.summit);
        linearLayout[5] = (LinearLayout) rootView.findViewById(R.id.exibitions);
        linearLayout[6] = (LinearLayout) rootView.findViewById(R.id.initiative);
        linearLayout[7] = (LinearLayout) rootView.findViewById(R.id.ideate);
        linearLayout[8] = (LinearLayout) rootView.findViewById(R.id.lectures);
//        linearLayout[9] = (LinearLayout) rootView.findViewById(R.id.mun);
//        linearLayout[10] = (LinearLayout) rootView.findViewById(R.id.cyclothon);
//        linearLayout[11] = (LinearLayout) rootView.findViewById(R.id.sponsers);

        int i;
        for (i = 0; i < 9; i += 1) {
            final int finalI = i;
            linearLayout[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(), CompetetionActivity.class);
                    intent.putExtra("_ID", finalI);
                    startActivity(intent);
                }
            });
        }


        return rootView;


    }

}