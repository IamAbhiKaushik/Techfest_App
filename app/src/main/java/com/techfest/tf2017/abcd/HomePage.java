package com.techfest.tf2017.abcd;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.techfest.tf2017.abcd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    DrawerLayout mDrawer;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView mNavigation;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    TextView displayEmail, emailNoti, displayName;
    String emailDisplay;
    ImageView logoutImage, notificationUser, mapimage, homeimage, aboutimage, schedimage;
    Drawable noti;
    Bitmap imagebit;
    Fragment ak;
    int count = 0;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_page);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        emailDisplay = getString(R.string.emaildrawer);
//        noti = getDrawable(R.drawable.ic_notifications_active_24px);
        logoutImage = (ImageView) findViewById(R.id.logout_noti);
        emailNoti = (TextView) findViewById(R.id.email_noti);
        notificationUser = (ImageView) findViewById(R.id.notificationimg);
        mapimage = (ImageView) findViewById(R.id.map_bottom);
        homeimage = (ImageView) findViewById(R.id.QR_bottom);
        schedimage = (ImageView) findViewById(R.id.schedule_bottom);
        aboutimage = (ImageView) findViewById(R.id.favorite_bottom);
//        ak = (Fragment) findViewById(R.id.fragment_space);


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
        HomeFragment mapFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        mDrawer.closeDrawer(GravityCompat.START);
        transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
        transaction.addToBackStack(null);
        transaction.commit();
        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new Fragment();

                int id = item.getItemId();
                if (item.isChecked()) {
                    item.setChecked(true);

                    return false;
                }
                if (id == R.id.LogoutBTN) {      /*Logout button*/
                    mAuth.signOut();
                    finish();
                    item.setChecked(true);
                    mDrawer.closeDrawer(GravityCompat.START);
                    count++;
                    startActivity(new Intent(HomePage.this, LoginActivity.class));

                }
                if (id == R.id.drawer_compi) {

                    RobowarsFragment mapFragment = new RobowarsFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    mDrawer.closeDrawer(GravityCompat.START);
                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    count++;
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);

                }
                if (id == R.id.drawer_ozone) {
                    ESportsFragment mapFragment = new ESportsFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    count++;
                    mDrawer.closeDrawer(GravityCompat.START);

                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);
                }
                if (id == R.id.drawer_contact) {

                    ContactFragment mapFragment = new ContactFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    count++;
                    mDrawer.closeDrawer(GravityCompat.START);

                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);
                }

                if (id == R.id.drawer_dev) {

                    DevelopersFragment mapFragment = new DevelopersFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    count++;
                    mDrawer.closeDrawer(GravityCompat.START);
                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);
                }
                if (id == R.id.drawer_sponser) {

//                    SponserFragment mapFragment = new SponserFragment();
//                    FragmentManager manager = getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                    count++;
//                    mDrawer.closeDrawer(GravityCompat.START);
//                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
//                    transaction.addToBackStack(null);
//                    transaction.commit();
                    SponserFragment mapFragment = new SponserFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    count++;
                    mDrawer.closeDrawer(GravityCompat.START);
                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
//                    item.setChecked(true);
                    item.setChecked(true);
                }
                if (id == R.id.drawer_home) {

                    HomeFragment mapFragment = new HomeFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    while (manager.getBackStackEntryCount() != 0) {
                        manager.popBackStackImmediate();
                    }
                    count = 0;
                    mDrawer.closeDrawer(GravityCompat.START);
                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);
                }
                if (id == R.id.drawer_mun) {

                    MunFragment2 mapFragment = new MunFragment2();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    count++;
                    mDrawer.closeDrawer(GravityCompat.START);
                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);
                }
                if (id == R.id.drawer_faq) {

                    FAQragment mapFragment = new FAQragment();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    count++;
                    mDrawer.closeDrawer(GravityCompat.START);
                    transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    item.setChecked(true);
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
                    String email = user.getEmail();
                    String name = user.getDisplayName();
                    Uri imageUrl = user.getPhotoUrl();
                    ImageView i = (ImageView) mNavigation.getHeaderView(0).findViewById(R.id.profile_image);
                    displayEmail = (TextView) mNavigation.getHeaderView(0).findViewById(R.id.emailUserDisplay);
                    displayName = (TextView) mNavigation.getHeaderView(0).findViewById(R.id.username);

                    String strURL = imageUrl.toString();
                    imagebit = getBitmapfromURL(strURL);
                    if (imagebit != null) {
                        i.setImageBitmap(imagebit);
//                        notificationUser.setImageBitmap(imagebit);
                    }
//                    emailNoti.setText(email);
                    displayEmail.setText(email);
                    displayName.setText(name);
//                    Toast.makeText(HomePage.this,"Hello " + email , Toast.LENGTH_SHORT).show();
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
//        logoutImage.setOnClickListener(new View.OnClickListener() {  /*Logout for button in notification*/
//            @Override
//            public void onClick(View v) {
//                mAuth.signOut();
//                finish();
//                startActivity(new Intent(HomePage.this, LoginActivity.class));
//            }
//        });
        mapimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapListFragment mapFragment = new MapListFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                count++;
                mDrawer.closeDrawer(GravityCompat.START);
                transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        homeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                QRFragment mapFragment = new QRFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                count++;
                mDrawer.closeDrawer(GravityCompat.START);
                transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        aboutimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeFragment faqFragment = new HomeFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_space, faqFragment, faqFragment.getTag());
                transaction.addToBackStack(null);
                while (manager.getBackStackEntryCount() != 0) {
                    manager.popBackStackImmediate();
                }
                count = 0;
                transaction.commit();
            }
        });
        schedimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RobowarsFragment mapFragment = new RobowarsFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_space, mapFragment, mapFragment.getTag());
                transaction.addToBackStack(null);
                count++;
                transaction.commit();
            }
        });

    }

    public Bitmap getBitmapfromURL(String src) {

        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(HomePage.this, "Image could not be loaded", Toast.LENGTH_SHORT).show();
            return null;


        }
    }

    @Override
    public void onBackPressed() {
        if (count == 0) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            count = count - 1;
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
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.addAuthStateListener(mAuthListner);
    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mAuth.removeAuthStateListener(mAuthListner);
//    }

    public static class Data_super {
        public static final ArrayList<data> loff = new ArrayList<data>();
    }

}
