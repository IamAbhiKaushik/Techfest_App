package com.example.nautatvanavlakha.abcd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    //Views and Widgets
    Button LoginBtn;
    EditText userEmail,userPass;
    String userEmailString,userPassString;

    //Create Firebase Fields
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginBtn = (Button) findViewById(R.id.LoginButton);
        userEmail=(EditText) findViewById(R.id.LoginEmail);
        userPass=(EditText) findViewById(R.id.LoginPass);




        mAuth=FirebaseAuth.getInstance();
        mAuthListner= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user =firebaseAuth.getCurrentUser();

                if (user!=null){
                    startActivity(new Intent(LoginActivity.this, HomePage.class));


                }else {

                }

            }
        };
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmailString=userEmail.getText().toString().trim();
                userPassString=userPass.getText().toString().trim();

                if (!TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPassString)){

                    mAuth.signInWithEmailAndPassword(userEmailString, userPassString ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                startActivity(new Intent(LoginActivity.this, HomePage.class));
                            }else{

                                Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                
            }
        });
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
