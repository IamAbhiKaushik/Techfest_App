package com.example.nautatvanavlakha.abcd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    DatabaseReference mDatabaseReference;
    ListView notificationList;
    List<NotificationData> notiList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Notifications");

        notificationList = (ListView) findViewById(R.id.list);
        notiList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notiList.clear();
                for (DataSnapshot notiSnapshot : dataSnapshot.getChildren()) {
                    NotificationData noti = notiSnapshot.getValue(NotificationData.class);

                    notiList.add(noti);

                }
                NotificationList adapter = new NotificationList(NotificationActivity.this, notiList);
                notificationList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
