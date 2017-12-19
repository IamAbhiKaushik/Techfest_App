package com.techfest.tf2017.abcd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nautatvanavlakha.abcd.R;


public class ESportsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView button;

    public ESportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag = inflater.inflate(R.layout.fragment_esports, container, false);
        button = (Button) frag.findViewById(R.id.dabao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri tt = Uri.parse("https://www.techfest.org/gamersleague");
                        // Create a new intent to view the news URI
                        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, tt);
                        // Send the intent to launch a new activity
                        startActivity(websiteIntent);
            }
        });
        return frag;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
