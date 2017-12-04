package com.example.nautatvanavlakha.abcd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Create button and edittext
    Button createUser;
    EditText userEmailEdit, userPassEdit, userNameEdit;
    //Create Firebase Fields
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    DatabaseReference mDatabaseReference;
    TextView moveToLogin;

    //ADDING THE USERNAME FIELD TO THE DATABASE FOR CREATING USER
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign id
        createUser = (Button) findViewById(R.id.CreateUser);
        moveToLogin = (TextView) findViewById(R.id.MoveLogin);
        userEmailEdit = (EditText) findViewById(R.id.EnterEmail);
        userPassEdit = (EditText) findViewById(R.id.EnterPass);
        userNameEdit = (EditText) findViewById(R.id.EnterUsername);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                }
            }
        };

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userEmailString, userPassString, userNameString;
                userEmailString = userEmailEdit.getText().toString().trim();
                userPassString = userPassEdit.getText().toString().trim();
                userNameString = userNameEdit.getText().toString().trim();


                if (!TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPassString)) {
                    final ProgressDialog progress = new ProgressDialog(MainActivity.this);
                    progress.setMessage("Please wait....");
                    progress.show();
                    mAuth.createUserWithEmailAndPassword(userEmailString, userPassString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                user.sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(MainActivity.this, "Account Created and verification email sent ", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                                DatabaseReference mChildDataRef = mDatabaseReference.child("Users").push();

                                String key_user = mChildDataRef.getKey();
                                mChildDataRef.child("keyUser").setValue(key_user);
                                mChildDataRef.child("emailUser").setValue(userEmailString);
                                mChildDataRef.child("passUser").setValue(userPassString);
                                mChildDataRef.child("nameUser").setValue(userNameString);


//                                sendVerificationEmail();

                                startActivity(new Intent(MainActivity.this, VerificationActivity.class));

                            } else {
                                progress.dismiss();

                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(MainActivity.this, "User with this email already exist.", Toast.LENGTH_SHORT).show();
                                } else if (userPassString.length() < 6) {
                                    Toast.makeText(MainActivity.this, "Password must be of Minimum 6 characters", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(MainActivity.this, " Fail to create User Account ", Toast.LENGTH_SHORT).show();
                                }

                            }

                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, " Please fill the details first", Toast.LENGTH_SHORT).show();

                }
            }
        });
        moveToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

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
