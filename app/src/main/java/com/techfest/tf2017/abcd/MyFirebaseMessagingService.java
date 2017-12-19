package com.techfest.tf2017.abcd;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.techfest.tf2017.abcd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    DatabaseReference mDatabaseReference;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    public void onCreate() {
        super.onCreate();
        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Notifications");
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Intent intent=new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("FCM NOTIFICATION");
        notificationBuilder.setContentTitle(remoteMessage.getNotification().getBody());
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setColor(554654);
        notificationBuilder.setSmallIcon(R.drawable.tf);
        notificationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());


//        String id = mDatabaseReference.push().getKey();
//        String message = remoteMessage.getNotification().getBody();
//        String tittle = remoteMessage.getNotification().getTitle();
////        DatabaseReference mChildDataRef = mDatabaseReference.child("Notifications").push();
////        String key_notification = mChildDataRef.getKey();
////        mChildDataRef.child("Message").setValue(remoteMessage.getNotification().getBody());
////        mChildDataRef.child("Tittle").setValue(remoteMessage.getNotification().getTitle());
////
////        mAuth = FirebaseAuth.getInstance();
////        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        mDatabaseReference.child(id).setValue(notiData);




    }

}
