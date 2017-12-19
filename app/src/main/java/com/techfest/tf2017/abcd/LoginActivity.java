package com.techfest.tf2017.abcd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nautatvanavlakha.abcd.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private final static int RC_SIGN_IN = 123;
    //Views and Widgets
    Button LoginBtn ;
    TextView MoveToSignin ,displayEmail,ndisplayEmail;
    EditText userEmail,userPass ;
    String userEmailString,userPassString,userNameString;
    //Create Firebase Fields
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    SignInButton button;
    GoogleSignInClient mGoogleSignInClient;
    GoogleApiClient mGoogleApiClient;
    DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        LoginBtn = (Button) findViewById(R.id.LoginButton);
//        userEmail=(EditText) findViewById(R.id.LoginEmail);
//        userPass=(EditText) findViewById(R.id.LoginPass);
        button=(SignInButton) findViewById(R.id.googleBtn);
//        MoveToSignin=(TextView) findViewById(R.id.moveToSignin);
        displayEmail = (TextView) findViewById(R.id.emailUserDisplay);
        ndisplayEmail = (TextView) findViewById(R.id.email_noti);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mAuth=FirebaseAuth.getInstance();
        mAuthListner= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user =firebaseAuth.getCurrentUser();



                if (user!=null){
                    Intent home_intnet = new Intent(LoginActivity.this, HomePage.class);
                    home_intnet.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(home_intnet);
                    finish();

                }else {


                }

            }
        };
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signIn();
                ProgressDialog progress = new ProgressDialog(LoginActivity.this);
                progress.setMessage("Logging in...");
                progress.show();
            }
        });
//        MoveToSignin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(LoginActivity.this,MainActivity.class));
//
//            }
//        });
//        LoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                userEmailString=userEmail.getText().toString().trim();
//                userPassString=userPass.getText().toString().trim();
//
//
//                if (!TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPassString)){
//
//
//                    mAuth.signInWithEmailAndPassword(userEmailString, userPassString ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//
//                            if (task.isSuccessful()){
//                                ProgressDialog progress = new ProgressDialog(LoginActivity.this);
//                                progress.setMessage("Logging in...");
//                                progress.show();
//
//                                startActivity(new Intent(LoginActivity.this, HomePage.class));
//                            }else{
//
//                                Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    });
//                }else {
//                    Toast.makeText(LoginActivity.this,"Please fill the details first",Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
               Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        ProgressDialog progress = new ProgressDialog(LoginActivity.this);
                                progress.setMessage("Logging in...");
                                progress.show();
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            userEmailString = user.getEmail();
                            userPassString = null;
                            userNameString = user.getDisplayName();
                            Uri userUrl = user.getPhotoUrl();
                            String userImageString = userUrl.toString();
                            DatabaseReference mChildDataRef = mDatabaseReference.child("Users").push();
                            String key_user = mChildDataRef.getKey();
                            mChildDataRef.child("keyUser").setValue(key_user);
                            mChildDataRef.child("emailUser").setValue(userEmailString);
                            mChildDataRef.child("passUser").setValue(userPassString);
                            mChildDataRef.child("nameUser").setValue(userNameString);
                            mChildDataRef.child("photoUser").setValue(userImageString);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
