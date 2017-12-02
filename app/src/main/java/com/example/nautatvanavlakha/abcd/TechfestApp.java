package com.example.nautatvanavlakha.abcd;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Abhishek on 02-12-2017.
 */

public class TechfestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (FirebaseApp.getApps(this).isEmpty()){

            FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        }
    }
}
