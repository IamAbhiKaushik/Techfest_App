package com.techfest.tf2017.abcd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nautatvanavlakha.abcd.R;


public class BettingFragment extends Fragment {
    Button button;
    public BettingFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag = inflater.inflate(R.layout.fragment_esports, container, false);
        button = (Button) frag.findViewById(R.id.betting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri tt = Uri.parse("https://www.techfest.org/betting");
                // Create a new intent to view the news URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, tt);
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
        return frag;
    }
}
