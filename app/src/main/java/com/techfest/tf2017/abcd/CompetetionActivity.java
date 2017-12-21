package com.techfest.tf2017.abcd;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.techfest.tf2017.abcd.R;
import com.techfest.tf2017.abcd.BlankFragment;


public class CompetetionActivity extends AppCompatActivity {
    public BottomSheetBehavior behavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager);
        final int i = getIntent().getExtras().getInt("_ID");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


//        final ArrayList<String> name = new ArrayList<String>();
//        final ArrayList<String> link = new ArrayList<String>();
//        final ArrayList<String> imglink = new ArrayList<String>();
//        final ArrayList<String> intro = new ArrayList<String>();
//        final ArrayList<String> time = new ArrayList<String>();
//
//        final String[] super_events = new String[]{"competitions","technoholix","ideate","workshops","initiatives","ozone","summit","lectures","exhibitions","World_Mun","cyclothon","sponsers"};
//
//
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        DatabaseReference myRef = database.getReference();
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//
//
//                String value;
//                for  (DataSnapshot postSnap : dataSnapshot.child(super_events[i]).getChildren()) {
//
//                    value = postSnap.child("name").getValue(String.class);
//                    name.add(value);
//
//                    value = postSnap.child("link").getValue(String.class);
//                    link.add(value);
//
//                    value = postSnap.child("imglink").getValue(String.class);
//                    imglink.add(value);
//
//                    value = postSnap.child("intro").getValue(String.class);
//                    intro.add(value);
//
//                    value = postSnap.child("time").getValue(String.class);
//                    time.add(value);
//
//
//
//
//                }
//
//                //   Log.d(TAG, "Value is: " + kvalue.get(0));
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("BlankNew", "Failed to read value.", error.toException());
//            }
//        });
//
//


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        BlankAdapter adapter = new BlankAdapter(CompetetionActivity.this, getSupportFragmentManager());
        Log.e("i", i + "");
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.setCurrentItem(i, true);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        tabLayout.setScrollX(tabLayout.getWidth());
//        tabLayout.getTabAt(i).select();
        tabLayout.setupWithViewPager(viewPager);

    }


}


//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_competetion);
//
//        final View bottomSheet = findViewById(R.id.design_bottom_sheet);
//        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
//        behavior.setPeekHeight(0);
//        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                switch (newState) {
//                    case BottomSheetBehavior.STATE_DRAGGING:
//                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_DRAGGING");
//                        break;
//                    case BottomSheetBehavior.STATE_SETTLING:
//                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_SETTLING");
//                        break;
//                    case BottomSheetBehavior.STATE_EXPANDED:
//                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_EXPANDED");
//                        break;
//                    case BottomSheetBehavior.STATE_COLLAPSED:
//                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_COLLAPSED");
//                        break;
//                    case BottomSheetBehavior.STATE_HIDDEN:
//                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_HIDDEN");
//                        break;
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
//
//
//            }
//        });
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("COMPETETIONS");
//        ArrayList<Item> item  =  new ArrayList<Item>();
//        item.add(new Item("Opera Hat","https://techfest.org/img/workshop/nvidia.jpg","23:00 | LH101"));
//        item.add(new Item("Gamers","https://techfest.org/img/workshop/9.jpg","17:00 | SOM WELL"));
//        item.add(new Item("Android","https://techfest.org/img/workshop/14G.jpg","02:30 | LA201"));
//        final ItemAdapter adapter = new ItemAdapter(this , item);
//        ListView lv = (ListView) findViewById(R.id.list);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Item currentItem = adapter.getItem(i);
//
//                String event_name= currentItem.getEvent_name();
//                String description = getString(R.string.sample_description);
//                final String link = "https://www.techfest.org";
//
//                TextView eventVenue = (TextView) findViewById(R.id.event_venue);
//
//                TextView eventDescription = (TextView) findViewById(R.id.event_description);
//                TextView know_more = (TextView) findViewById(R.id.km);
//
//                ImageView eventImage = (ImageView) findViewById(R.id.event_image);
//                TextView toolbar = (TextView) findViewById(R.id.toolbar_title_1);
//                toolbar.setText(event_name);
//                eventDescription.setText(description);
//
//                eventVenue.setText(currentItem.getTime_venue());
//                Picasso.with(getApplicationContext()).load(currentItem.getImageResource()).placeholder(R.drawable.unnamed).into(eventImage);
//                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
//                    //bottomSheet.setLayoutParams(new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT));
//                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                } else {
//                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                }
//
//                know_more.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Uri tt = Uri.parse(link);
//                        // Create a new intent to view the news URI
//                        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, tt);
//
//                        // Send the intent to launch a new activity
//                        startActivity(websiteIntent);
//                    }
//                });
//
//
//            }
//
//        });
//
//        ImageView close = (ImageView) findViewById(R.id.kclose);
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//            }
//        });
//    }
