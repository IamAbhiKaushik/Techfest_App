package com.example.nautatvanavlakha.abcd;

import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {

    DrawerLayout mDrawer;
    ActionBarDrawerToggle mDrawerToggle;
    MenuItem mLogout;
//    Create Firebase Fields
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mLogout= (MenuItem) findViewById(R.id.LogoutBTN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getActionBar() != null) {
            // Display the top-left hamburger button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setHomeButtonEnabled(true);

        // Make the hamburger button work
        mDrawer = (DrawerLayout) findViewById(R.id.DL);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };

        mDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mAuth=FirebaseAuth.getInstance();
        mAuthListner= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user =firebaseAuth.getCurrentUser();

                if (user!=null){

                }else {


                }

            }
        };

    mLogout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
         @Override
         public boolean onMenuItemClick(MenuItem item) {
            mAuth.signOut();
            finish();
            startActivity(new Intent(HomePage.this,MainActivity.class));
            return false;

    }
});

        // toasts the message when ListView item is clicked
// ListView mDrawerListView = (ListView) findViewById(R.id.left_drawer);
//        mDrawerListView.setOnItemClickListener(new ListView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String drawerstring = ("Menu Item at position " + position + " clicked.");
//                mDrawer.closeDrawer(GravityCompat.START);
//                Toast.makeText(getApplicationContext(), drawerstring, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DL);
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListner);
    }
}
