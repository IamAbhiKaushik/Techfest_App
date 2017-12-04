package com.example.nautatvanavlakha.abcd;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VerificationActivity extends AppCompatActivity {

    Button VerificationBtn;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    DatabaseReference mDatabaseReference;
    TextView hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        mAuth = FirebaseAuth.getInstance();
        VerificationBtn=(Button) findViewById(R.id.Verified);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {

                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    final boolean emailVerified = user.isEmailVerified();
                    hello=(TextView) findViewById(R.id.display_name);
                    hello.setText("Hello " + email);

                    // Check if user's email is verified
                    VerificationBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            mAuth.addAuthStateListener(mAuthListner);
                            boolean emailVerified=user.isEmailVerified();
                            if (emailVerified){
                                startActivity(new Intent(VerificationActivity.this,HomePage.class));

                            }else {
                                Toast.makeText(VerificationActivity.this, "Email not verified", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }
            }
        };

//        if (user != null) {
//            // Name, email address, and profile photo Url
//
//
//            // The user's ID, unique to the Firebase project. Do NOT use this value to
//            // authenticate with your backend server, if you have one. Use
//            // FirebaseUser.getToken() instead.
//            String uid = user.getUid();
//        }

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
