package com.example.nautatvanavlakha.abcd;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HomePage extends AppCompatActivity {

    DrawerLayout mDrawer;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView mNavigation;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    TextView displayEmail ,emailNoti;
    String emailDisplay;
    ImageView logoutImage ,notificationUser;
    Drawable noti;
    Bitmap imagebit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        displayEmail = (TextView) findViewById(R.id.emailUserDisplay);
        emailDisplay = (String) getString(R.string.emaildrawer);
        noti = (Drawable) getDrawable(R.drawable.ic_notifications_active_24px);
        logoutImage = (ImageView) findViewById(R.id.logout_noti);
        emailNoti =(TextView) findViewById(R.id.email_noti);
        notificationUser =(ImageView) findViewById(R.id.notificationimg);
        logoutImage.setOnClickListener(new View.OnClickListener() {  /*Logout for button in notification*/
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(HomePage.this, LoginActivity.class));
            }
        });

        setSupportActionBar(toolbar);
        if (getActionBar() != null) {
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

        mNavigation = (NavigationView) findViewById(R.id.nav_view);


        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (item.isChecked()) {
                    mDrawer.closeDrawer(GravityCompat.START);
                    item.setChecked(true);
                    return false;
                }
                if (id == R.id.LogoutBTN) {      /*Logout button*/
                    mAuth.signOut();
                    finish();
                    item.setChecked(true);
                    startActivity(new Intent(HomePage.this, LoginActivity.class));

                }

                return false;
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    String email = user.getDisplayName();
                    Uri imageUrl = user.getPhotoUrl();
                    ImageView i = (ImageView)findViewById(R.id.profile_image);
//                    i.setImageURI(imageUrl);
//                    emailDisplay =
                    assert imageUrl != null;
                    String strURL = imageUrl.toString();
                    imagebit = getBitmapfromURL(strURL);
                    if (imagebit!=null){ //TODO: User image update is not working fix it
                        i.setImageBitmap(imagebit);
                        notificationUser.setImageBitmap(imagebit);
                    }
                    emailNoti.setText(email);


                    // TODO: Update the email in drawer header for the user
//                    displayEmail.setText(email);
                    Toast.makeText(HomePage.this,"Hello " + email , Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(HomePage.this, LoginActivity.class));

                }

            }
        };

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
    public Bitmap getBitmapfromURL(String src){

        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(HomePage.this,"Image could not be loaded",Toast.LENGTH_SHORT).show();
            return null;


        }
    }

    @Override
    public void onBackPressed() {
        // TODO: Back press for homepage is not correct correct it
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
