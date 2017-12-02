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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Create button and edittext
    Button createUser ,moveToLogin;
    EditText userEmailEdit, userPassEdit;
    //Create Firebase Fields
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign id
        createUser = (Button) findViewById(R.id.CreateUser);
        moveToLogin =(Button) findViewById(R.id.MoveLogin);
        userEmailEdit=(EditText) findViewById(R.id.EnterEmail);
        userPassEdit=(EditText) findViewById(R.id.EnterPass);

        mAuth=FirebaseAuth.getInstance();
        mDatabaseReference= FirebaseDatabase.getInstance().getReference();
        mAuthListner= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user =firebaseAuth.getCurrentUser();

                if (user!=null){
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                }
            }
        };

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userEmailString,userPassString;
                userEmailString = userEmailEdit.getText().toString().trim();
                userPassString = userPassEdit.getText().toString().trim();

                if (!TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPassString)){

                    mAuth.createUserWithEmailAndPassword(userEmailString,userPassString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                DatabaseReference mChildDataRef=mDatabaseReference.child("Users").push();

                                String key_user=mChildDataRef.getKey();
                                mChildDataRef.child("keyUser").setValue(key_user);
                                mChildDataRef.child("emailUser").setValue(userEmailString);
                                mChildDataRef.child("passUser").setValue(userPassString);

                                Toast.makeText(MainActivity.this,"User Account Created",Toast.LENGTH_LONG).show();

                                startActivity(new Intent(MainActivity.this, HomePage.class));
                            }else {
                                Toast.makeText(MainActivity.this," Fail to create User Account ",Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                }
            }
        });
        moveToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,LoginActivity.class));

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
