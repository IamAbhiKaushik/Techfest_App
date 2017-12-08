package com.example.nautatvanavlakha.abcd;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String REG_TOKEN ="REG_TOKEN";

    @Override
    public void onTokenRefresh() {

        String recentToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recentToken);

        sendRegistrationToServer(recentToken);


    }

    private void sendRegistrationToServer(String recentToken) {

    }


}
