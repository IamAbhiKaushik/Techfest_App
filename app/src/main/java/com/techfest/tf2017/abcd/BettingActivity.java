package com.techfest.tf2017.abcd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.techfest.tf2017.abcd.R;

public class BettingActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri tt = Uri.parse("https://www.techfest.org");
                // Create a new intent to view the news URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, tt);
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }
}
