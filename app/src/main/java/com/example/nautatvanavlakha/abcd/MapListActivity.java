package com.example.nautatvanavlakha.abcd;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MapListActivity extends AppCompatActivity {

    DrawerLayout mDrawer;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView mNavigation;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);

        TextView[] textViews = new TextView[17];

        textViews[0] = (TextView) findViewById(R.id.convo);
        textViews[1] = (TextView) findViewById(R.id.lhc);
        textViews[2] = (TextView) findViewById(R.id.pcsa);
        textViews[3] = (TextView) findViewById(R.id.gymkhana);
        textViews[4] = (TextView) findViewById(R.id.ncc);
        textViews[5] = (TextView) findViewById(R.id.fck);
        textViews[6] = (TextView) findViewById(R.id.newSwim);
        textViews[7] = (TextView) findViewById(R.id.kv);
        textViews[8] = (TextView) findViewById(R.id.sac);
        textViews[9] = (TextView) findViewById(R.id.som);
        textViews[10] = (TextView) findViewById(R.id.oat);
        textViews[11] = (TextView) findViewById(R.id.chub);
        textViews[12] = (TextView) findViewById(R.id.bb);
        textViews[13] = (TextView) findViewById(R.id.gulmohar);
        textViews[14] = (TextView) findViewById(R.id.sacfc);
        textViews[15] = (TextView) findViewById(R.id.dayfc);
        textViews[16] = (TextView) findViewById(R.id.amul);
        textViews[17] = (TextView) findViewById(R.id.coffees);


        textViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.131973, 72.914285(Convocation Hall)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.130735, 72.916900(Lecture Hall Complex (LHC)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.131973, 72.914285(LT-PCSA)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.134446, 72.912217(Gymkhana Grounds)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.133572, 72.913399(NCC Grounds)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.130480, 72.915724(FC Kohli Auditorium (FCK)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.135574, 72.912930(New Swimming Pool)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.129113, 72.918408(Kendriya Vidyalaya (KV))");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.135422, 72.913674(Student Activity Centre (SAC))");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.131651, 72.915758(SJM SOM)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.135045, 72.913401(Open Air Theatre (OAT))");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.134599, 72.910057(The Campus Hub)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.133698, 72.911471(Brews n Bites)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.129769, 72.915152(Gulmohar)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.134865, 72.913824(SAC Food Court)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.129861, 72.915798(Day Food Court)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.135148, 72.905608(Amul Parlour)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        textViews[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.131994, 72.915479(Coffee Shack)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//                setSupportActionBar(toolbar);
//        if (getActionBar() != null) {
//            // Display the top-left hamburger button
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
//        getSupportActionBar().setHomeButtonEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        // Make the hamburger button work
//        mDrawer = (DrawerLayout) findViewById(R.id.DL_map);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.app_name, R.string.app_name) {
//            @Override
//            public void onDrawerClosed(View drawerView) {
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//            }
//        };
//
//        mDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
//
//        mDrawer.addDrawerListener(mDrawerToggle);
//        mDrawerToggle.syncState();

    }
}
